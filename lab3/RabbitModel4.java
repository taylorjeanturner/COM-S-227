package lab3;

import java.util.Random;

/**
 * A RabbitModel is used to simulate the growth of a population of rabbits.
 */
public class RabbitModel4 {
	private int population;
	private Random random;

	/**
	 * Constructs a new RabbitModel.
	 */
	public RabbitModel4() {
		random = new Random(137);
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
		
		population = population + random.nextInt(11);

	}

	/**
	 * Sets or resets the state of the model to the initial conditions.
	 */
	public void reset() {
		population = 2;
	}
}