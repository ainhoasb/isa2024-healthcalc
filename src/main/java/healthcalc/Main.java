package healthcalc;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de la calculadora y del adaptador
        HealthCalcImpl calculadora = HealthCalcImpl.getInstance();
        HealthHospital hospitalCalc = new HealthCalcAdapter();

        // Crear una instancia del Proxy
        HealthHospital calcProxy = new HealthCalcProxy();
        HealthStats statsProxy = (HealthStats) calcProxy;

        try {
            // Datos de prueba
            char genero1 = 'm';
            Gender generoEnum1 = Gender.MALE;
            int edad1 = 25;
            float altura1m = 1.80f; // en metros
            int altura1cm = 180; // en cm
            int peso1g = 75000; // en gramos
            float peso1kg = 75; // en kg

            Person persona1 = new PersonImpl(peso1kg, altura1cm, generoEnum1, edad1);

            char genero2 = 'w';
            Gender generoEnum2 = Gender.FEMALE;
            int edad2 = 30;
            float altura2m = 1.65f; // en metros
            int altura2cm = 165; // en cm
            int peso2g = 60000; // en gramos
            float peso2kg = 60; // en kg

            Person persona2 = new PersonImpl(peso2kg, altura2cm, generoEnum2, edad2);

            // Cálculos usando la implementación HealthCalcImpl
            double iw1 = calculadora.getIdealBodyWeight(persona1);
            double bmr1 = calculadora.basalMetabolicRate(persona1);

            double iw2 = calculadora.getIdealBodyWeight(persona2);
            double bmr2 = calculadora.basalMetabolicRate(persona2);

            // Cálculos usando el adaptador HealthCalcAdapter
            int iwAdapter1 = hospitalCalc.pesoIdeal(genero1, altura1m);
            double bmrAdapter1 = hospitalCalc.bmr(genero1, edad1, altura1m, peso1g);

            int iwAdapter2 = hospitalCalc.pesoIdeal(genero2, altura2m);
            double bmrAdapter2 = hospitalCalc.bmr(genero2, edad2, altura2m, peso2g);

            // Resultados
            System.out.println("--- Resultados HealthCalcImpl y Adapter ---");
            System.out.println("Paciente 1 - Peso Ideal: " + iw1 + " kg , Adapter = " + iwAdapter1 + "g");
            System.out.println("Paciente 1 - BMR: " + bmr1 + " calorías/día , Adapter = " + bmrAdapter1 + " calorías/día");
            System.out.println("Paciente 2 - Peso Ideal: " + iw2 + " kg , Adapter = " + iwAdapter2 + "g");
            System.out.println("Paciente 2 - BMR: " + bmr2 + " calorías/día, Adapter = " + bmrAdapter2 + " calorías/día");

            // Se obeserva que se obtiene los mismos resultados, por lo tanto, el patrón Adapter está correctamente implementado
            
            // Comprobación del patrón Proxy de Registros
            // Realizar algunos cálculos para recoger estadísticas
             calcProxy.pesoIdeal('m', 1.80f);
             calcProxy.pesoIdeal('w', 1.60f);
             calcProxy.bmr('m', 25, 1.80f, 70);
             calcProxy.bmr('w', 30, 1.60f, 60);
 
             // Imprimir estadísticas recogidas por el proxy
             System.out.println("\n--- Estadísticas HealthCalc ---");
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

        // Envolver la calculadora HealthHospital con decoradores para manejar sistemas europeo y americano
        // Se añade ambos decoradores de mensajes para imprimir en español y en inglés
        HealthHospital europeanCalc = new SpanishMessage(new EnglishMessage(new EuropeanDecorator(hospitalCalc)));
        HealthHospital americanCalc = new SpanishMessage(new EnglishMessage(new AmericanDecorator(hospitalCalc)));

        // Datos de prueba
        char genero = 'm';
        int edad = 30;
        float alturaEuropea = 1.75f; // en metros
        int pesoEuropeo = 70000; // en gramos
        float alturaAmericana = 5.74f; // en pies (aproximadamente 1.75 metros)
        int pesoAmericano = 154; // en libras (aproximadamente 70 kilogramos)

        try {
            // Realizar cálculos usando la calculadora europea
            System.out.println("\n--- Resultados del Sistema Europeo ---");
            double bmrEuropeo = europeanCalc.bmr(genero, edad, alturaEuropea, pesoEuropeo);
            int pesoIdealEuropeo = europeanCalc.pesoIdeal(genero, alturaEuropea);
            System.out.println("BMR Europeo: " + bmrEuropeo + " calorías/día");
            System.out.println("Peso Ideal Europeo: " + pesoIdealEuropeo + " gramos");

            // Realizar cálculos usando la calculadora americana
            System.out.println("\n--- Resultados del Sistema Americano ---");
            double bmrAmericano = americanCalc.bmr(genero, edad, alturaAmericana, pesoAmericano);
            int pesoIdealAmericano = americanCalc.pesoIdeal(genero, alturaAmericana);
            System.out.println("BMR Americano: " + bmrAmericano  + " calorías/día");
            System.out.println("Peso Ideal Americano: " + pesoIdealAmericano + " gramos");

        } catch (Exception e) {
            System.err.println("Error en los cálculos: " + e.getMessage());
        }
    }
}
