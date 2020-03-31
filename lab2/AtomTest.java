package lab2;

public class AtomTest {
	public static void main(String[] args) {
		Atom Uranium = new Atom(92, 146, 92);
		System.out.println("Atomic Charge: " + Uranium.getAtomicCharge());
		System.out.println("Atomic Mass: " + Uranium.getAtomicMass());
		Uranium.decay();
		System.out.println("Atomic Charge: " + Uranium.getAtomicCharge());
		System.out.println("Atomic Mass: " + Uranium.getAtomicMass());
	}

}
