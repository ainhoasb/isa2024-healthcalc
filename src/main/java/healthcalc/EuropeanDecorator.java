package healthcalc;

public class EuropeanDecorator extends HealthCalcDecorator{
    public EuropeanDecorator(HealthHospital calcDecorator) {
        super(calcDecorator);
    }

    @Override
    public double bmr(char genero, int edad, float altura, int peso) throws Exception {
        try {
            // No es necesario modificar los valores introducidos ya que se usa la calculadora adaptada.
            return super.calcDecorator.bmr(genero, edad, altura, peso);
        } catch (Exception e) {
            System.err.println("Error al calcular la tasa metabólica basal: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public int pesoIdeal(char genero, float altura) throws Exception {
        try {
            // No es necesario modificar los valores introducidos ya que se usa la calculadora adaptada.
            return super.calcDecorator.pesoIdeal(genero, altura);
        } catch (Exception e) {
            System.err.println("Error al calcular el peso ideal: " + e.getMessage());
            throw e;
        }
    }
    
}
