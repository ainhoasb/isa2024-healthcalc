package healthcalc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests para la calculadora de salud.")
public class HealthCalcTest {

	private HealthCalcImpl calculadora = HealthCalcImpl.getCalculadora();

	//Tests para el método idealWeight()

	@Test
	@DisplayName("Test de género incorrecto (distinto de 'm' o 'w') para idealWeight()")
	public void testGeneroIncorrectoIW() {
		assertThrows(Exception.class, () -> {
            calculadora.idealWeight(170, 'x');
		});		
	}

	@Test
	@DisplayName("Test de altura incorrecta para idealWeight()")
	public void testAlturaIncorrectoIW() {
		//Se establece un rango normal de altura entre 140cm y 250cm, ambos incluidos
		//Al comprobar que se cumple este rango, también se comprueba que la altura no sea negativa y que esté en centímetros 

		//Para un valor inferior al rango establecido
		assertThrows(Exception.class, () -> {
            calculadora.idealWeight(30, 'm');
		});

		//Para un valor superior al rango establecido
		assertThrows(Exception.class, () -> {
            calculadora.idealWeight(300, 'm');
		});
	}

	@Test
	@DisplayName("Test que comprueba si es correcto el peso ideal masculino que devuelve idealWeight()")
	public void testIdealWeightM() throws Exception {
		int height = 170;		

		float IW = height - 100 - ((height - 150) / 4);

		assertEquals(IW,calculadora.idealWeight(height, 'm'));
	}

	@Test
	@DisplayName("Test que comprueba si es correcto el peso ideal femenino que devuelve idealWeight()")
	public void testIdealWeightW() throws Exception {
		int height = 170;		

		float IW = height - 100 - ((height - 150) / 2.5f);

		assertEquals(IW,calculadora.idealWeight(height, 'w'));
	}

	//Tests para el método basalMetabolicRate()

	@Test
	@DisplayName("Test de género incorrecto (distinto de 'm' o 'w') para basalMetabolicRate()")
	public void testGeneroIncorrectoBMR() {
		assertThrows(Exception.class, () -> {
            calculadora.basalMetabolicRate(70, 170, 'x', 50);
		});	
	}

	@Test
	@DisplayName("Test de altura incorrecta para basalMetabolicRate()")
	public void testAlturaIncorrectoBMR() {
		//Se establece un rango normal de altura entre 140cm y 250cm, ambos incluidos
		//Al comprobar que se cumple este rango, también se comprueba que la altura no sea negativa y que esté en centímetros.

		//Para un valor inferior al rango establecido
		assertThrows(Exception.class, () -> {
            calculadora.basalMetabolicRate(70, 30, 'm', 50);
		});

		//Para un valor superior al rango establecido
		assertThrows(Exception.class, () -> {
            calculadora.basalMetabolicRate(70, 300, 'm', 50);
		});
	}

	@Test
	@DisplayName("Test de peso incorrecto para basalMetabolicRate()")
	public void testPesoIncorrectoBMR() {
		//Debe ser mayor que 0kg
		assertThrows(Exception.class, () -> {
            calculadora.basalMetabolicRate(-45, 170, 'm', 50);
		});
	}

	@Test
	@DisplayName("Test de edad incorrecta para basalMetabolicRate()")
	public void testEdadIncorrectoBMR() {
		//Se establece un rango normal de edad entre 0 y 120 años, ambos incluidos

		//Para un valor inferior al rango establecido
		assertThrows(Exception.class, () -> {
            calculadora.basalMetabolicRate(70, 30, 'm', -5);
		});

		//Para un valor superior al rango establecido
		assertThrows(Exception.class, () -> {
            calculadora.basalMetabolicRate(70, 300, 'm', 200);
		});
	}

	@Test
	@DisplayName("Test que comprueba si es correcta la tasa metabólica basal masculina que devuelve basalMetabolicRate()")
	public void testBasalMetabolicRateM() throws Exception {
		float weight = 70;
		int height = 170;
		int age = 50;

		float BMR = 10 * weight + 6.25f * height - 5 * age + 5;

		assertEquals(BMR, calculadora.basalMetabolicRate(weight, height, 'm', age));
	
	}

	@Test
	@DisplayName("Test que comprueba si es correcta la tasa metabólica basal femenina que devuelve basalMetabolicRate()")
	public void testBasalMetabolicRateW() throws Exception{
		float weight = 70;
		int height = 170;
		int age = 50;

		float BMR = 10 * weight + 6.25f * height - 5 * age - 161;

		assertEquals(BMR, calculadora.basalMetabolicRate(weight, height, 'w', age));
	}
}
