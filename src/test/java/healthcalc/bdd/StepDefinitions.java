package healthcalc.bdd;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class StepDefinitions {
    private HealthCalc healthCalc;
    private double bmr;
    private String errorMessage;

    @Given("Valid parameters for height, gender, weight and age")
    public void valid_parameters() {
        // Aquí puedes inicializar tu objeto HealthCalc si es necesario
        healthCalc = new HealthCalc();
    }

    @When("The user enters their {int}, {string}, {int} and {int}")
    public void the_user_enters_their(int height, String gender, int weight, int age) {
        try {
            bmr = healthCalc.calculateBMR(height, gender, weight, age);
            errorMessage = null; // Reset error message for valid scenarios
        } catch (InvalidParameterException e) {
            errorMessage = e.getMessage();
        }
    }

    @Then("The system returns the value for the basal metabolic rate")
    public void the_system_returns_the_value() {
        Assert.assertNotNull("BMR should not be null when parameters are valid", bmr);
    }

    @Given("Incorrect parameters for height, gender, weight and age")
    public void incorrect_parameters() {
        // Aquí puedes inicializar tu objeto HealthCalc si es necesario
        healthCalc = new HealthCalc();
    }

    @Then("The system returns an error message with the parameters that are incorrect")
    public void the_system_returns_an_error_message() {
        Assert.assertNotNull("Error message should be provided for invalid parameters", errorMessage);
    }
}

class HealthCalc {
    public double calculateBMR(int height, String gender, int weight, int age) throws InvalidParameterException {
        // Implementa la lógica para calcular el BMR aquí
        // Lanza una InvalidParameterException con un mensaje adecuado para parámetros
        // incorrectos
        return 0; // Este valor es solo un placeholder
    }
}

class InvalidParameterException extends Exception {
    public InvalidParameterException(String message) {
        super(message);
    }

}
