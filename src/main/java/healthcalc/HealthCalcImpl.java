package healthcalc;

public class HealthCalcImpl implements HealthCalc {

    @Override
    public float idealWeight(int height, char gender) throws Exception{
        
        if(height<140 && height>250){
            throw new Exception("Altura incorrecta, debe estar entre 140cm y 250cm");
        }else if(gender != 'm' && gender != 'M' && gender != 'w' && gender != 'W'){
            throw new Exception("Género incorrecto, debe ser 'm' o 'w'");
        }

        float idealWeight;
        
        if (gender == 'm' || gender == 'M'){
            idealWeight = height - 100 - ((height - 150) / 4);
        }else{
            idealWeight = height - 100 - ((height - 150) / 2.5f);
        }

        return idealWeight;
    }

    @Override
    public float basalMetabolicRate(float weight, int height, char gender, int age) throws Exception{

        if(weight<=0){
            throw new Exception("Peso incorrecto, debe ser mayor que 0");
        }else if(height<140 && height>250){
            throw new Exception("Altura incorrecta, debe estar entre 140cm y 250cm");
        }else if(gender != 'm' && gender != 'M' && gender != 'w' && gender != 'W'){
            throw new Exception("Género incorrecto, debe ser 'm' o 'w'");
        }else if(age<0 && age>120){
            throw new Exception("Edad incorrecta, debe ser mayor que 0");
        }

        float basalMetabolicRate;

        if (gender == 'm' || gender == 'M'){
            basalMetabolicRate = 10 * weight + 6.25f * height - 5 * age + 5;
        }else{
            basalMetabolicRate = 10 * weight + 6.25f * height - 5 * age - 161;
        }

        return basalMetabolicRate;
    }    
}
