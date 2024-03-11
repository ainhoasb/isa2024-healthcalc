package healthcalc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests para la calculadora de salud.")
public class HealthCalcTest {

	//private HealthCalcImpl calculadora;


	@BeforeEach
    public void initTests() {
		//Antes de cada test se inicializa la variable calculadora.
        //calculadora = new HealthCalcImpl();
    }

	//Tests para el método idealWeight()

	@Test
	@DisplayName("Test de género incorrecto (distinto de 'm' o 'w') para idealWeight()")
	public void testGeneroIncorrectoIW() {
	
	}

	@Test
	@DisplayName("Test de altura incorrecta para idealWeight()")
	public void testAlturaIncorrectoIW() {
		//Se establece un rango normal de altura entre 140cm y 250cm
		//Al establecer este rango, también se comprueba que no sea la altura negativa y que esté en centímetros 
	
	}

	@Test
	@DisplayName("Test que comprueba si correcto el peso ideal masculino que devuelve idealWeight()")
	public void testIdealWeightM() {
	
	}

	@Test
	@DisplayName("Test que comprueba si correcto el peso ideal femenino que devuelve idealWeight()")
	public void testIdealWeightW() {
	
	}

	//Tests para el método basalMetabolicRate()

	@Test
	@DisplayName("Test de género incorrecto (distinto de 'm' o 'w') para basalMetabolicRate()")
	public void testGeneroIncorrectoBMR() {
	
	}

	@Test
	@DisplayName("Test de altura incorrecta para basalMetabolicRate()")
	public void testAlturaIncorrectoBMR() {
		//Se establece un rango normal de altura entre 140cm y 250cm
		//Al establecer este rango, también se comprueba que no sea la altura negativa y que esté en centímetros 
	
	}

	@Test
	@DisplayName("Test de peso incorrecto para basalMetabolicRate()")
	public void testPesoIncorrectoBMR() {
		//Debe ser mayor que 0kg
	
	}

	@Test
	@DisplayName("Test de peso incorrecto para basalMetabolicRate()")
	public void testEdadIncorrectoBMR() {
		//Debe estar entre 0 y 120 años
	
	}

	@Test
	@DisplayName("Test que comprueba si correcto el peso ideal masculino que devuelve basalMetabolicRate()")
	public void testBasalMetabolicRateM() {
	
	}

	@Test
	@DisplayName("Test que comprueba si correcto el peso ideal femenino que devuelve basalMetabolicRate()")
	public void testBasalMetabolicRateW() {
	
	}

}
