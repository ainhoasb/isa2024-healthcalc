package healthcalc;

public abstract class MessageDecorator implements HealthHospital{
    protected HealthHospital  calcDecorator;

    public MessageDecorator(HealthHospital calcDecorator) {
        this.calcDecorator = calcDecorator;
    }

    protected abstract void imprimirMensajes(float altura, int peso, double bmr);

    @Override
    public double bmr(char genero, int edad, float altura, int peso) throws Exception {
        double bmr= calcDecorator.bmr(genero, edad, altura, peso);
        imprimirMensajes(altura, peso, bmr);
        return bmr;
    }

    @Override
    public int pesoIdeal(char genero, float altura) throws Exception {
        // Pasar llamada al objeto decorado
        return calcDecorator.pesoIdeal(genero, altura);
    }

    
}