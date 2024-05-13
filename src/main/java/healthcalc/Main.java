package healthcalc;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de la calculadora y del adaptador
        HealthCalc calculadora = HealthCalcImpl.getInstance();
        HealthHospital hospitalCalc = new HealthCalcAdapter();

        // Crear una instancia del Proxy
        HealthCalc calcProxy = new HealthCalcProxy();
        HealthStats statsProxy = (HealthStats) calcProxy;

        try {
            // Datos de prueba
            char genero1 = 'm';
            int edad1 = 25;
            float altura1m = 1.80f; // en metros
            int altura1cm = 180; // en cm
            int peso1g = 75000; // en gramos
            float peso1kg = 75; // en kg

            char genero2 = 'w';
            int edad2 = 30;
            float altura2m = 1.65f; // en metros
            int altura2cm = 165; // en cm
            int peso2g = 60000; // en gramos
            float peso2kg = 60; // en kg

            // Cálculos usando la implementación HealthCalcImpl
            float iw1 = calculadora.idealWeight(altura1cm, genero1);
            float bmr1 = calculadora.basalMetabolicRate(peso1kg, altura1cm, genero1, edad1);

            float iw2 = calculadora.idealWeight(altura2cm, genero2);
            float bmr2 = calculadora.basalMetabolicRate(peso2kg, altura2cm, genero2, edad2);

            // Cálculos usando el adaptador HealthCalcAdapter
            int iwAdapter1 = hospitalCalc.pesoIdeal(genero1, altura1m);
            double bmrAdapter1 = hospitalCalc.bmr(genero1, edad1, altura1m, peso1g);

            int iwAdapter2 = hospitalCalc.pesoIdeal(genero2, altura2m);
            double bmrAdapter2 = hospitalCalc.bmr(genero2, edad2, altura2m, peso2g);

            // Resultados
            System.out.println("Resultados HealthCalcImpl y Adapter:");
            System.out.println("Paciente 1 - Peso Ideal: " + iw1 + ", Adapter = " + iwAdapter1);
            System.out.println("Paciente 1 - BMR: " + bmr1 + ", Adapter = " + bmrAdapter1);
            System.out.println("Paciente 2 - Peso Ideal: " + iw2 + ", Adapter = " + iwAdapter2);
            System.out.println("Paciente 2 - BMR: " + bmr2 + ", Adapter = " + bmrAdapter2);

            // Se obeserva que se obtiene los mismos resultados, por lo tanto, el patrón Adapter está correctamente implementado
            
            // Comprobación del patrón Proxy de Registros
            // Realizar algunos cálculos para recoger estadísticas
             calcProxy.idealWeight(180, 'm');
             calcProxy.idealWeight(160, 'w');
             calcProxy.basalMetabolicRate(70, 180, 'm', 25);
             calcProxy.basalMetabolicRate(60, 160, 'w', 30);
 
             // Imprimir estadísticas recogidas por el proxy
             System.out.println("\nEstadísticas HealthCalc:");
             System.out.println("Altura media: " + statsProxy.alturaMedia());
             System.out.println("Peso medio: " + statsProxy.pesoMedio());
             System.out.println("Edad media: " + statsProxy.edadMedia());
             System.out.println("BMR medio: " + statsProxy.bmrMedio());
             System.out.println("Número total de pacientes: " + statsProxy.numTotalPacientes());
             System.out.println("Número de pacientes masculinos: " + statsProxy.numSexoH());
             System.out.println("Número de pacientes femeninos: " + statsProxy.numSexoM());

        } catch (Exception e) {
            System.err.println("Error en el cálculo: " + e.getMessage());
        }
    }
}
