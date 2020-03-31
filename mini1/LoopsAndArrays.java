package mini1;

import java.util.Arrays;
import java.util.Collections;

public class LoopsAndArrays {
	/**
	 * 
	 * Loops and arrays
	 * 
	 * @author Taylor Turner
	 * 
	 */
//	public static void main(String[] args) {
//		int[] a = { 1, 2, 3, 4 };
//		int[] b = { 2, 4, 6, 8 };
//		int[] c = { 2, 4, 7 };
//		int[] d = { 1, 2, 3 };
//		int[] e = { 4, 5, 6, 7, 8 };
//		int[] f = { 1, 3, 3 };
//
//		System.out.println("Expected: 2, Actual: " + countMatches("abcde", "xbydcazzz"));
//		System.out.println("Expected: 3, Actual: " + numFirstChar("computer science"));
//		System.out.println("Expected: 4, Actual: " + countSubstringsWithOverlap("aa", "aaaaa"));
//		System.out.println("Expected: 4321, Actual: " + arrayToString(a));
//		System.out.println("Expected: true, Actual: " + isArithmetic(b));
//		System.out.println("Expected: false, Actual: " + isArithmetic(c));
//		System.out.println("Expected: [7, 22, 11, 34], Actual: " + Arrays.toString(collatz(7, 3)));
//		System.out.println("Expected: [1, 4, 2, 5, 3, 6, 7, 8], Actual: " + Arrays.toString(interleaveArray(d, e)));
//		System.out.println("Expected: true, Actual: " + isAscending(d));
//		System.out.println("Expected: false, Actual: " + isAscending(f));
//
//	}

	/**
	 * Counts the number of positions in a pair of strings that have matching
	 * characters. For example, countMatches("abcde", "xbydcazzz") returns 2.
	 * 
	 * @param s Given string
	 * @param t Given string
	 * @return number of positions in which the characters match in the two strings
	 */
	public static int countMatches(java.lang.String s, java.lang.String t) {

		int matches = 0;
		for (int i = 0; i < Math.min(s.length(), t.length()); i++) {

			if (s.charAt(i) == t.charAt(i)) {
				matches++;
			}
		}

		return matches;

	}

	/**
	 * Counts the number of times the first character of a string appears. If the
	 * length of the string is 0, returns 0. For example, numFirstChar("computer
	 * science") returns 3.
	 * 
	 * @param s Given string
	 * @return number of times the first character of a string appears
	 */
	public static int numFirstChar(java.lang.String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(0)) {
				count++;
			}
		}
		return count;
	}

	/**
	 * Counts the number of times that one string occurs as a substring in another.
	 * For example, countSubstringsWithOverlap("aa", "aaaaa") returns 4
	 * 
	 * @param t Target string
	 * @param s String in which we are looking
	 * @return number of times that one string occurs as a substring in another.
	 */
	public static int countSubstringsWithOverlap(java.lang.String t, java.lang.String s) {
		int count = 0;
		if (t.length()>s.length()) {
			return count;
		}
		for (int i = 0; i <= Math.max(s.length(), t.length()) - Math.min(s.length(), t.length()); i++) {
			int j;
			for (j = 0; j < Math.min(s.length(), t.length()); j++) {
				if (s.charAt(i + j) != t.charAt(j)) {
					break;
				}
			
			}
			if (j == Math.min(s.length(), t.length())) {
				count++;
				j = 0;
			}
		}
		return count;

	}

	/**
	 * Returns a string which contains the elements in an array in reverse order.
	 * For example, if a = [1, 2, 3, 4], then arrayToString(a) returns "4321"
	 * 
	 * @param array Array of integers
	 * @return a string which contains the elements in an array in reverse order
	 */
	public static java.lang.String arrayToString(int[] array) {
		String a = "";
		for (int i = 0; i < array.length / 2; i++) {
			int temp = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = temp;
		}

		for (int i : array) {
			a += Integer.toString(i);
		}
		return a;
	}

	/**
	 * Given an array of integers, returns true if the numbers form an arithmetic
	 * sequence (a sequence in which each value differs from the previous one by a
	 * fixed amount). For example, given a = [2, 4, 6, 8], the method returns true.
	 * Given a = [2, 4, 7] the method returns false.
	 * 
	 * @param array Array of integers
	 * @return true if the numbers form an arithmetic sequence (a sequence in which
	 *         each value differs from the previous one by a fixed amount).
	 */
	public static boolean isArithmetic(int[] array) {
		if (array.length == 1 || array.length == 2) {
			return true;
		}
		for (int i = 1; i < array.length - 1; i++) {
			if (array[i - 1] - array[i] == array[i + 1] - array[i]) {
				return true;
			}
			i++;
		}
		return false;

	}

	/**
	 * Given integer start and integer numIterations, return an array containing the
	 * Collatz sequence beginning with start up to numIterations. The Collatz
	 * function is defined by: 3n + 1 if n is odd n/2 if n is even Given start = 7
	 * and numIterations = 3, this method returns [7, 22, 11, 34]
	 * 
	 * @param start         Starting integer
	 * @param numIterations How long to compute the Collatz sequence for
	 * @return an array containing the Collatz sequence beginning with start up to
	 *         numIterations
	 */
	public static int[] collatz(int start, int numIterations) {
		int n = start;
		int[] a = new int[numIterations + 1];
		for (int i = 0; i < a.length; i++) {
			a[i] = n;
			if (n % 2 == 1) {
				n = 3 * n + 1;
			} else if (n % 2 == 0) {
				n = n / 2;
			}
		}
		return a;

	}

	/**
	 * Given two arrays, return the array which interleaves the elements of the two
	 * arrays. The two arrays do not have to be the same length. For example, given
	 * a = [1, 2, 3] and b = [4, 5, 6, 7, 8], the method returns c = [1, 4, 2, 5, 3,
	 * 6, 7, 8]
	 * 
	 * @param a Given array
	 * @param b Given array
	 * @return the array which interleaves the elements of the two arrays
	 */
	public static int[] interleaveArray(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		int min = Math.min(a.length, b.length);
		for (int i = 0; i < min; i++) {
			c[2 * i] = a[i];
			c[2 * i + 1] = b[i];
		}
		if (a.length < b.length) {
			int d = b.length - a.length;
			for (int i = 0; i < d; i++) {
				c[a.length * 2 + i] = b[a.length + i];
			}
		}
		if (a.length > b.length) {
			int d = a.length - b.length;
			for (int i = 0; i < d; i++) {
				c[b.length * 2 + i] = a[b.length + i];
			}
		}
		return c;
	}

	/**
	 * Given an array of integers, return whether the array is in ascending order
	 * (duplicates are not allowed). For example, given a = [1, 2, 3] the method
	 * returns true. Given a = [1, 3, 3], the method returns false.
	 * 
	 * @param a Given array
	 * @return true of the array is in ascending order
	 */
	public static boolean isAscending(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				return false;
			}
			if (a[i] == a[i + 1]) {
				return false;
			}
		}
		return true;
	}
}
