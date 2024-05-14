package healthcalc;

public class SpanishMessage extends MessageDecorator {
    public SpanishMessage(HealthHospital  calcDecorator) {
        super(calcDecorator);
    }

    @Override
    protected void imprimirMensajes(float altura, int peso, double bmr) {
        //El enunciado de la práctica indica que el peso se debe dar en kg en el mensaje, por ello, se hace el cambio de gramos a kg.
        float pesoKg = peso/1000.0f;
        System.out.println(String.format("La persona con altura %.2f metros y %.2f Kg tiene un BMR de %.2f.", altura, pesoKg, bmr));
    }
    
    
}
