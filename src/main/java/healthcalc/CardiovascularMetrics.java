package healthcalc;

public interface CardiovascularMetrics {

    /**
	 * Calculate the ideal weight (IW) of a person following the Lorentz formula:
	 * For men: IW = height - 100 - (height - 150) / 4)
	 * For women: IW = height - 100 - (height - 150) / 2.5)
	 *
	 * @param person 	A person with the attributes height and gender.
	 * @return 		 	The ideal weight of the person (kg).
	 * @throws Exception 
	 */
    public double getIdealBodyWeight(Person person);
    
}
