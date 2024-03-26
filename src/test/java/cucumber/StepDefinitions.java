package cucumber;

import org.junit.jupiter.api.Assertions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import healthcalc.HealthCalcImpl;

public class StepDefinitions {
	private HealthCalcImpl calculator;
    private float result;
    private boolean raiseException;
    
    @Before
    public void initialization() {
		calculator = null;
	    result = -1;
	    raiseException = false;
	}
    
    @Given("A HealthCalc user")
	public void a_health_calc_user() {
		calculator = new HealthCalcImpl();
	}
    
    @When("The user enters valid values for weight {float}, height {int}, gender {string} and age {int}")
    public void the_user_enters_valid_values_for_weight_height_gender_and_age(float float1, Integer int1, String string, Integer int2) {
    	try {
            result = calculator.basalMetabolicRate(float1, int1, string.charAt(0), int2);
        } catch (Exception e) {
            raiseException = true;
        }
    }
    @Then("The system returns the value {float}")
    public void the_system_returns_the_value(float float1) {
    	Assertions.assertEquals(float1, result, 0.01);
    }
    
    @When("The user enters incorrect values for weight {int}, height {int}, gender {string} and age {int}")
	public void the_user_enters_incorrect_values_for_weight_height_gender_and_age(Integer int1, Integer int2, String string, Integer int3) {
		try {
            result = calculator.basalMetabolicRate(int1, int2, string.charAt(0), int3);
        } catch (Exception e) {
            raiseException = true;
        }
	}
    
    @Then("The system raises an exception")
	public void the_system_raises_an_exception() {
		Assertions.assertTrue(raiseException);
	}
    
    @When("The user enters valid values for ideal weight, height {int} and gender {string}")
	public void the_user_enters_valid_values_for_ideal_weight_height_and_gender(Integer int1, String string) {
		try {
            result = calculator.idealWeight(int1, string.charAt(0));
        } catch (Exception e) {
            raiseException = true;
        }
	}
    
    @When("The user enters incorrect values for ideal weight, height {int} and gender {string}")
	public void the_user_enters_incorrect_values_for_ideal_weight_height_and_gender(Integer int1, String string) {
		try {
            result = calculator.idealWeight(int1, string.charAt(0));
        } catch (Exception e) {
            raiseException = true;
        }
	}
}
