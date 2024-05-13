package healthcalc;

import java.util.ArrayList;
import java.util.List;

public class HealthCalcProxy implements HealthCalc, HealthStats{
    private HealthCalcImpl calculadora;
    private List<Float> alturas = new ArrayList<>();
    private List<Float> pesos = new ArrayList<>();
    private List<Integer> edades = new ArrayList<>();
    private List<Float> bmrs = new ArrayList<>();
    private int numSexoH = 0;
    private int numSexoM = 0;

    public HealthCalcProxy() {
        this.calculadora = HealthCalcImpl.getInstance();
    }

    @Override
    public float idealWeight(int height, char gender) throws Exception  {
        try {
            float peso = calculadora.idealWeight(height, gender);
            // Registrar los valores introducidos
            alturas.add((float) height);
            if (gender == 'm' || gender == 'M') {
                numSexoH++;
            } else if (gender == 'w' || gender == 'W') {
                numSexoM++;
            }
            return peso;
        } catch (Exception e) {
            System.err.println("Error al calcular el peso ideal: " + e.getMessage());
            throw e; 
        }
    }

    @Override
    public float basalMetabolicRate(float weight, int height, char gender, int age) throws Exception {
        try {
            float bmr = calculadora.basalMetabolicRate(weight, height, gender, age);
            // Registrar los valores introducidos
            pesos.add(weight);
            alturas.add((float) height);
            edades.add(age);
            bmrs.add(bmr);
            if (gender == 'm' || gender == 'M') {
                numSexoH++;
            } else if (gender == 'w' || gender == 'W') {
                numSexoM++;
            }
            return bmr;
        } catch (Exception e) {
            System.err.println("Error al calcular la tasa metabólica basal: " + e.getMessage());
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
