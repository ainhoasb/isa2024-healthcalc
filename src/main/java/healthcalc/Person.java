package healthcalc;

public interface Person {
    
    /**
	 * @return El peso de una persona en kilogramos.
	 */
    public float weight();

    /**
	 * @return La altura de una persona en centímetros.
	 */
    public float height();

    /**
	 * @return El género de una persona (FEMALE o MALE).
	 */
    public Gender gender();

    /**
	 * @return La edad de una persona.
	 */
    public int age();
}
