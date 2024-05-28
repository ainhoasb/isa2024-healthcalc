package healthcalc;

public interface MetabolicMetrics {

    /**
	 * Calculate the Basal Metabolic Rate (BMR) of a person with the following formula:
	 * For men: BMR = 10 * weight + 6.25 * height - 5 * age + 5
	 * For women: BMR = 10 * weight + 6.25 * height - 5 * age - 161
	 *   
	 * @param person	A person with the attributes weight, height, age and gender.
	 * @return	  		The Basal Metabolic Rate of the person.
	 * @throws Exception
	 */
    public double basalMetabolicRate(Person person) throws Exception;
}
