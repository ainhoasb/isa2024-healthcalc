package healthcalc;

public class HealthCalcImpl implements HealthCalc {

    private static HealthCalcImpl instance;

    // Constructor privado para evitar la instanciación directa
    private HealthCalcImpl() {
    }

    // Método público estático para obtener la instancia
    public static HealthCalcImpl getInstance() {
        if (instance == null) {
            instance = new HealthCalcImpl();
        }
        return instance;
    }

    @Override
    public float idealWeight(int height, Gender gender) throws Exception{
        
        if(height<140 || height>250){
            throw new Exception("Altura incorrecta, debe estar entre 140cm y 250cm");
        }else if(gender != Gender.FEMALE && gender != Gender.MALE){
            throw new Exception("Género incorrecto, debe ser FEMALE o MALE ");
        }

        float idealWeight;
        
        if (gender == Gender.MALE){
            idealWeight = height - 100 - ((height - 150) / 4);
        }else{
            idealWeight = height - 100 - ((height - 150) / 2.5f);
        }

        return idealWeight;
    }

    @Override
    public float basalMetabolicRate(float weight, int height, Gender gender, int age) throws Exception{

        if(weight<=0){
            throw new Exception("Peso incorrecto, debe ser mayor que 0");
        }else if(height<140 || height>250){
            throw new Exception("Altura incorrecta, debe estar entre 140cm y 250cm");
        }else if(gender != Gender.FEMALE && gender != Gender.MALE){
            throw new Exception("Género incorrecto, debe ser FEMALE o MALE");
        }else if(age<0 || age>120){
            throw new Exception("Edad incorrecta, debe ser mayor que 0");
        }

        float basalMetabolicRate;

        if (gender == Gender.MALE){
            basalMetabolicRate = 10 * weight + 6.25f * height - 5 * age + 5;
        }else{
            basalMetabolicRate = 10 * weight + 6.25f * height - 5 * age - 161;
        }

        return basalMetabolicRate;
    }    
}
