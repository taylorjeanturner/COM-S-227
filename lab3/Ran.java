package lab3;

import java.util.Random;

public class Ran {
	public static void main(String[] args) {
//		Random rand = new Random();
		Random rand = new Random(137);
		System.out.println(rand.nextInt(6));
		System.out.println(rand.nextInt(6));
		System.out.println(rand.nextInt(6));
		System.out.println(rand.nextInt(6));

	}
}
