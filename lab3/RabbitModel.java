package lab3;

/**
 * A RabbitModel is used to simulate the growth of a population of rabbits.
 */
public class RabbitModel {
	
	private int population;

	/**
	 * Constructs a new RabbitModel.
	 */
	public RabbitModel() {
		population = 2;
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
		population ++;
	}

	/**
	 * Sets or resets the state of the model to the initial conditions.
	 */
	public void reset() {
		population = 2;
	}
}