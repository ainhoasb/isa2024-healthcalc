package healthcalc;

public class HealthCalcAdapter implements HealthHospital {
    private HealthCalcImpl calculadora;

    public HealthCalcAdapter() {
        this.calculadora = HealthCalcImpl.getInstance();
    }

    @Override
    public double bmr(char genero, int edad, float altura, int peso) throws Exception {
        try {
            // Convertir los parámetros según necesite el método basalMetabolicRate() de HealthCalcImpl
            // El peso de g se cambia a kg
            // La altura de m se cambia a cm
            float pesoKg = peso/1000.0f;
            int alturaCm = (int) (altura*100);

            return calculadora.basalMetabolicRate(pesoKg, alturaCm, genero, edad);
        } catch (Exception e) {
            throw new Exception("Error al calcular la tasa metabólica basal");
        }
    }

    @Override
    public int pesoIdeal(char genero, float altura) throws Exception {
        try {
            // Convertir los parámetros según necesite el método idealWeight() de HealthCalcImpl
            // La altura de m se cambia a cm
            int alturaCm = (int) (altura*100);
            return (int) calculadora.idealWeight(alturaCm, genero);
        } catch (Exception e) {
            throw new Exception("Error al calcular el peso ideal");
        }
    }
    
}
