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
            Gender generoEnum;
            if (genero =='m' || genero == 'M'){
                generoEnum = Gender.MALE;
            }else if (genero =='w' || genero == 'W'){
                generoEnum = Gender.FEMALE;
            }else{
                generoEnum = null;
            }
            
            return calculadora.basalMetabolicRate(pesoKg, alturaCm, generoEnum, edad);
        } catch (Exception e) {
            throw new Exception("Error al calcular la tasa metabólica basal: " + e.getMessage(), e);
        }
    }

    @Override
    public int pesoIdeal(char genero, float altura) throws Exception {
        try {
            // Convertir los parámetros según necesite el método idealWeight() de HealthCalcImpl
            // La altura de m se cambia a cm
            int alturaCm = (int) (altura*100);
            Gender generoEnum;
            if (genero =='m' || genero == 'M'){
                generoEnum = Gender.MALE;
            }else if (genero =='w' || genero == 'W'){
                generoEnum = Gender.FEMALE;
            }else{
                generoEnum = null;
            }

            float iW = calculadora.idealWeight(alturaCm, generoEnum);

            // Cambiar el peso ideal de kg a gramos. 
            int pesoIdeal = (int) (iW*1000);
            return pesoIdeal;
        } catch (Exception e) {
            throw new Exception("Error al calcular el peso ideal: " + e.getMessage(), e);
        }
    }
    
}
