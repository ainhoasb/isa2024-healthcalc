package healthcalc;

public interface HealthStats {
    /**
	 * Calcula la altura media de los usuarios de la calculadora
	 * @return	La altura media en centímetros.
	 */
    public float alturaMedia();

    /**
	 * Calcula el peso medio de los usuarios de la calculadora
	 * @return	El peso medio en kilogramos.
	 */
    public float pesoMedio();

    /**
	 * Calcula la edad media de los usuarios de la calculadora
	 * @return	La edad media.
	 */
    public float edadMedia();

    /**
	 * Calcula la tasa metabólica basal media de los usuarios de la calculadora
	 * @return	La tasa metabólica basal media en calorías/día.
	 */
    public float bmrMedio();

    /**
	 * Calcula el número de hombres que son usuarios de la calculadora
	 * @return	El número de usuarios masculinos.
	 */
    public int numSexoH(); 

    /**
	 * Calcula el número de mujeres que son usuarias de la calculadora
	 * @return	El número de usuarias femeninas.
	 */
    public int numSexoM(); 

    /**
	 * Calcula el número total de usuarios de la calculadora
	 * @return	El número total de usuarios.
	 */
    public int numTotalPacientes();
    
}
