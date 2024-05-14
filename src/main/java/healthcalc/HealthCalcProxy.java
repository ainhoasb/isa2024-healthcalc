package healthcalc;

import java.util.ArrayList;
import java.util.List;

public class HealthCalcProxy implements HealthHospital, HealthStats{
    private HealthCalcAdapter calculadora;
    private List<Float> alturas = new ArrayList<>();
    private List<Integer> pesos = new ArrayList<>();
    private List<Integer> edades = new ArrayList<>();
    private List<Double> bmrs = new ArrayList<>();
    private int numSexoH = 0;
    private int numSexoM = 0;

    public HealthCalcProxy() {
        this.calculadora = new HealthCalcAdapter();
    }

    @Override
    public double bmr(char genero, int edad, float altura, int peso) throws Exception {
        try {
            double bmr = calculadora.bmr(genero, edad, altura, peso);
            // Registrar los valores introducidos
            pesos.add(peso);
            alturas.add(altura);
            edades.add(edad);
            bmrs.add(bmr);
            if (genero == 'm' || genero == 'M') {
                numSexoH++;
            } else if (genero == 'w' || genero == 'W') {
                numSexoM++;
            }
            return bmr;
        } catch (Exception e) {
            System.err.println("Error al calcular la tasa metabólica basal: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public int pesoIdeal(char genero, float altura) throws Exception {
        try {
            int peso = calculadora.pesoIdeal(genero, altura);
            // Registrar los valores introducidos
            alturas.add(altura);
            if (genero == 'm' || genero == 'M') {
                numSexoH++;
            } else if (genero == 'w' || genero == 'W') {
                numSexoM++;
            }
            return peso;
        } catch (Exception e) {
            System.err.println("Error al calcular el peso ideal: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public float alturaMedia() {
        return (float) alturas.stream().mapToDouble(a -> a).average().orElse(0.0f);
    }

    @Override
    public float pesoMedio() {
        return (float) pesos.stream().mapToDouble(p -> p).average().orElse(0.0f);
    }

    @Override
    public float edadMedia() {
        return (float) edades.stream().mapToInt(e -> e).average().orElse(0.0);
    }

    @Override
    public float bmrMedio() {
        return (float) bmrs.stream().mapToDouble(b -> b).average().orElse(0.0f);
    }

    @Override
    public int numSexoH() {
        return numSexoH;
    }

    @Override
    public int numSexoM() {
        return numSexoM;
    }

    @Override
    public int numTotalPacientes() {
        // El número total de pacientes será la suma de los pacientes hombres y de las pacientes mujeres.
        return numSexoH+numSexoM; 
    }
    
}
