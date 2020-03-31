package lab3;

/**
 * A RabbitModel is used to simulate the growth of a population of rabbits.
 */
public class RabbitModel5 {
	private int lastYear;
	private int yearBefore;
	private int population;

	/**
	 * Constructs a new RabbitModel.
	 */
	public RabbitModel5() {
		reset();
	}

	/**
	 * Returns the current number of rabbits.
	 * 
	 * @return current rabbit population
	 */
	public int getPopulation() {

		return population;
	}

	/**
	 * Updates the population to simulate the passing of one year.
	 */
	public void simulateYear() {
		
		yearBefore = lastYear + population;
		lastYear = population;
		population = yearBefore;

	}

	/**
	 * Sets or resets the state of the model to the initial conditions.
	 */
	public void reset() {
		lastYear = 1;
		yearBefore = 0;
		population = lastYear + yearBefore ;

	}
}