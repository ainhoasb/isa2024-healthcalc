package healthcalc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests para la calculadora de salud.")
public class HealthCalcTest {

	private HealthCalcImpl calculadora = HealthCalcImpl.getInstance();

	//Tests para el método idealWeight()

	@Test
	@DisplayName("Test de género incorrecto (distinto de 'male' o 'female') para idealWeight()")
	public void testGeneroIncorrectoIW() {
		Person persona = new PersonImpl(170, null);
		assertThrows(Exception.class, () -> {
            calculadora.getIdealBodyWeight(persona);
		});		
	}

	@Test
	@DisplayName("Test de altura incorrecta para idealWeight()")
	public void testAlturaIncorrectoIW() {
		Person persona1 = new PersonImpl(30, Gender.MALE);
		Person persona2 = new PersonImpl(300, Gender.MALE);
		//Se establece un rango normal de altura entre 140cm y 250cm, ambos incluidos
		//Al comprobar que se cumple este rango, también se comprueba que la altura no sea negativa y que esté en centímetros 

		//Para un valor inferior al rango establecido
		assertThrows(Exception.class, () -> {
            calculadora.getIdealBodyWeight(persona1);
		});

		//Para un valor superior al rango establecido
		assertThrows(Exception.class, () -> {
            calculadora.getIdealBodyWeight(persona2);
		});
	}

	@Test
	@DisplayName("Test que comprueba si es correcto el peso ideal masculino que devuelve idealWeight()")
	public void testIdealWeightM() throws Exception {
		int height = 170;
		Person persona = new PersonImpl(height, Gender.MALE);		

		float IW = height - 100 - ((height - 150) / 4);

		assertEquals(IW,calculadora.getIdealBodyWeight(persona));
	}

	@Test
	@DisplayName("Test que comprueba si es correcto el peso ideal femenino que devuelve idealWeight()")
	public void testIdealWeightW() throws Exception {
		int height = 170;
		Person persona = new PersonImpl(height, Gender.FEMALE);		

		float IW = height - 100 - ((height - 150) / 2.5f);

		assertEquals(IW,calculadora.getIdealBodyWeight(persona));
	}

	//Tests para el método basalMetabolicRate()

	@Test
	@DisplayName("Test de género incorrecto (distinto de 'm' o 'w') para basalMetabolicRate()")
	public void testGeneroIncorrectoBMR() {
		Person persona = new PersonImpl(70, 170, null, 50);

		assertThrows(Exception.class, () -> {
            calculadora.basalMetabolicRate(persona);
		});	
	}

	@Test
	@DisplayName("Test de altura incorrecta para basalMetabolicRate()")
	public void testAlturaIncorrectoBMR() {
		Person persona1 = new PersonImpl(70, 30, Gender.MALE, 50);
		Person persona2 = new PersonImpl(70, 300, Gender.MALE, 50);
		
		//Se establece un rango normal de altura entre 140cm y 250cm, ambos incluidos
		//Al comprobar que se cumple este rango, también se comprueba que la altura no sea negativa y que esté en centímetros.
		//Para un valor inferior al rango establecido
		assertThrows(Exception.class, () -> {
            calculadora.basalMetabolicRate(persona1);
		});

		//Para un valor superior al rango establecido
		assertThrows(Exception.class, () -> {
            calculadora.basalMetabolicRate(persona2);
		});
	}

	@Test
	@DisplayName("Test de peso incorrecto para basalMetabolicRate()")
	public void testPesoIncorrectoBMR() {
		Person persona = new PersonImpl(0, 170, Gender.MALE, 50);
		//Debe ser mayor que 0kg
		assertThrows(Exception.class, () -> {
            calculadora.basalMetabolicRate(persona);
		});
	}

	@Test
	@DisplayName("Test de edad incorrecta para basalMetabolicRate()")
	public void testEdadIncorrectoBMR() {
		Person persona1 = new PersonImpl(70, 30, Gender.MALE, -5);
		Person persona2 = new PersonImpl(70, 300, Gender.MALE, 200);

		//Se establece un rango normal de edad entre 0 y 120 años, ambos incluidos
		//Para un valor inferior al rango establecido
		assertThrows(Exception.class, () -> {
            calculadora.basalMetabolicRate(persona1);
		});

		//Para un valor superior al rango establecido
		assertThrows(Exception.class, () -> {
            calculadora.basalMetabolicRate(persona2);
		});
	}

	@Test
	@DisplayName("Test que comprueba si es correcta la tasa metabólica basal masculina que devuelve basalMetabolicRate()")
	public void testBasalMetabolicRateM() throws Exception {
		float weight = 70;
		int height = 170;
		int age = 50;

		Person persona = new PersonImpl(weight, height, Gender.MALE, age);

		double BMR = 10 * weight + 6.25f * height - 5 * age + 5;
		assertEquals(BMR, calculadora.basalMetabolicRate(persona));
	
	}

	@Test
	@DisplayName("Test que comprueba si es correcta la tasa metabólica basal femenina que devuelve basalMetabolicRate()")
	public void testBasalMetabolicRateW() throws Exception{
		float weight = 70;
		int height = 170;
		int age = 50;

		Person persona = new PersonImpl(weight, height, Gender.FEMALE, age);

		double BMR = 10 * weight + 6.25f * height - 5 * age - 161;
		assertEquals(BMR, calculadora.basalMetabolicRate(persona));
	}
}
