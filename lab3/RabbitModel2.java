package lab3;

/**
 * A RabbitModel is used to simulate the growth of a population of rabbits.
 */
public class RabbitModel2 {
	private int population;

	/**
	 * Constructs a new RabbitModel.
	 */
	public RabbitModel2() {
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
		if ((population % 5) == 0) {
			reset();
		} 
		else {
			population++;
		}
	}

	/**
	 * Sets or resets the state of the model to the initial conditions.
	 */
	public void reset() {
		population = 0;
	}
}