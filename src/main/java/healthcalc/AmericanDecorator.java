package healthcalc;

public class AmericanDecorator extends HealthCalcDecorator{
    public AmericanDecorator(HealthHospital calcDecorator) {
        super(calcDecorator);
    }

    @Override
    public double bmr(char genero, int edad, float altura, int peso) throws Exception {
        try {
            // Convertir la altura de pies a metros y el peso de libras a gramos
            float alturaM = altura * 0.3048f;
            int pesoG = (int) (peso * 453.592f);

            return super.calcDecorator.bmr(genero, edad, alturaM, pesoG);
        } catch (Exception e) {
            System.err.println("Error al calcular la tasa metabólica basal: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public int pesoIdeal(char genero, float altura) throws Exception {
        try {
            // Convertir la altura de pies a metros
            float alturaM = altura * 0.3048f;

            return super.calcDecorator.pesoIdeal(genero, alturaM);
        } catch (Exception e) {
            System.err.println("Error al calcular el peso ideal: " + e.getMessage());
            throw e;
        }
    }
    
}
