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


    
}
