package lab2;

public class Atom {
	 /**
	   * Number of protons the atom has.
	   */
	private int protons;
	/**
	   * Number of neutrons the atom has.
	   */
	private int neutrons;
	/**
	   * Number of electrons the atom has.
	   */
	private int electrons;
	/**
	   * Constructs an an Atom with the given number of protons, neutrons, and electrons.
	   * @param givenProtons, givenNuetrons, givenElectrons 
	   *   the number of protons, neutrons, and electrons the atom has
	   */
	public Atom(int givenProtons, int givenNeutrons, int givenElectrons) {
		   // insert code to assign given values to instance variables 
		protons = givenProtons;
		neutrons = givenNeutrons;
		electrons = givenElectrons;
		}
	
	/**
	 * @return
	 * 		Total number of protons plus neutrons
	 */
	public int getAtomicMass() {
		int atomicMass = protons + neutrons;
		return atomicMass;
	}
	
	/**
	 * @return
	 * 		The difference between the number of protons and electrons
	 */
	public int getAtomicCharge() {
		int atomicCharge = protons - electrons;
		return atomicCharge;
	}
	
	/**
	 * Decreases the number of protons by 2 and the number of neutrons by 2 
	 */
	public void decay() {
		protons = protons - 2;
		neutrons = neutrons - 2;
	}

}
