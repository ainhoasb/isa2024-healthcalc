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
    public void healthCalc_user() {
        calculator = new HealthCalcImpl();
    }

    @When("The user enters valid values for ideal weight (height {int} and gender {string})")
    public void the_user_enters_valid_values_for_ideal_weight(int height, String gender) {
        try {
            result = calculator.idealWeight(height, gender.charAt(0));
        } catch (Exception e) {
            raiseException = true;
        }
    }

    @When("The user enters valid values for weight {float}, height {int}, gender {string} and age {int}")
    public void the_user_enters_valid_values_for(float weight, int height, String gender, int age) {
        try {
            result = calculator.basalMetabolicRate(weight, height, gender.charAt(0), age);
        } catch (Exception e) {
            raiseException = true;
        }
    }

    @Then("The system returns the value {float}")
    public void the_system_returns_the_value(float float1) {
        Assertions.assertEquals(float1, result, 0.01);
    }

    @When("The user enters incorrect values for ideal weight (height {int} and gender {string})")
    public void the_user_enters_incorrect_values_for_ideal_weight(int height, String gender) {
        try {
            result = calculator.idealWeight(height, gender.charAt(0));
        } catch (Exception e) {
            raiseException = true;
        }
    }

    @When("The user enters incorrect values for weight {float}, height {int}, gender {string} and age {int}")
    public void the_user_enters_incorrect_values_for(float weight, int height, String gender, int age) {
        try {
            result = calculator.basalMetabolicRate(weight, height, gender.charAt(0), age);
        } catch (Exception e) {
            raiseException = true;
        }
    }

    @Then("The system raises an exception")
    public void the_system_raises_an_exception() {
        Assertions.assertTrue(raiseException);
    }
}
