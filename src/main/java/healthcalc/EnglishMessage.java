package healthcalc;

public class EnglishMessage extends MessageDecorator {
    public EnglishMessage(HealthHospital  calcDecorator) {
        super(calcDecorator);
    }

    @Override
    protected void imprimirMensajes(float altura, int peso, double bmr) {
        //El enunciado de la práctica indica que el peso se debe dar en kg en el mensaje, por ello, se hace el cambio de gramos a kg.
        float pesoKg = peso/1000.0f;
        System.out.println(String.format("The person with height %.2f meters and %.2f Kg has a BMR of %.2f.", altura, pesoKg, bmr));
    }
    
}
