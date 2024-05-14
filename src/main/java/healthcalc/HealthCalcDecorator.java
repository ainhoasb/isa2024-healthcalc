package healthcalc;

public abstract class HealthCalcDecorator implements HealthHospital {
    protected HealthHospital  calcDecorator;

    public HealthCalcDecorator(HealthHospital  calcDecorator) {
        this.calcDecorator = calcDecorator;
    }

    @Override
    public double bmr(char genero, int edad, float altura, int peso) throws Exception {
        // Pasar llamada al objeto decorado
        return calcDecorator.bmr(genero, edad, altura, peso);
    }

    @Override
    public int pesoIdeal(char genero, float altura) throws Exception {
        // Pasar llamada al objeto decorado
        return calcDecorator.pesoIdeal(genero, altura);
    }
}
