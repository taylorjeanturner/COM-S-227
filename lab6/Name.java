package lab6;

import java.util.Scanner;

public class Name {
	public static void main(String[] args) {
		System.out.println(Initials("Edna del Humboldt von der Schooch"));
		System.out.println(Vowel("Edna del Humboldt von der Schooch"));
	}

	public static String Initials(String name) {
		char firstLetter = '0';
		String initials = "";
		Scanner in = new Scanner(name);
		while (in.hasNext()) {
			firstLetter = in.next().charAt(0);
			initials = initials + "" + firstLetter;
		}
		return initials;
	}

	public static int Vowel(String name) {
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			if ("aeiouAEIOU".indexOf(c) >= 0) {
				return i;
			}
		}
		return -1;
	}
}
