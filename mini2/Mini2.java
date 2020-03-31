package mini2;

public class Mini2 {
	/**
	 * 
	 * @author Taylor Turner
	 */

	public static void main(String[] args) {
		System.out.println("Expected: cccc, Result: " + everyNth("abcabcabcabca", 3));

		System.out.println("Expected: ababababa, Result: " + noNth("abcabcabcabca", 3));

		System.out.println("Expected: Fo bar baz !, Result: " + unique("Foo bar bazzzzz !!"));

		System.out.println("Expected: 12345, Result: " + toInt("12345"));

		System.out.println("Expected: true, Result: " + isMatched(""));
		System.out.println("Expected: true, Result: " + isMatched("()"));
		System.out.println("Expected: true, Result: " + isMatched("<((({[]})))>()()[{}]<>"));
		System.out.println("Expected: false, Result: " + isMatched("{"));
		System.out.println("Expected: false, Result: " + isMatched("(])"));
		System.out.println("Expected: false, Result: " + isMatched(")("));
		System.out.println("Expected: false, Result: " + isMatched("<((({[]}))>()()[{}]<>"));

		System.out.println("Expected 1.0, Result: " + pow(5, 0));

	}

	/**
	 * Returns a string containing only the characters of s whose position in s,
	 * counting from 1, is zero mod n. No credit if your solution uses a loop. For
	 * instance, given the parameters s = "abcabcabcabca" and n = 3, the output
	 * should be "cccc".
	 * 
	 * @param s
	 * @param n
	 * @return the new string
	 */
	public static java.lang.String everyNth(java.lang.String s, int n) {
		return everyNth(s, n, 1);
	}

	private static java.lang.String everyNth(java.lang.String s, int n, int i) {
		if (i <= s.length()) {
			if (i % n == 0) {
				return s.charAt(i - 1) + everyNth(s, n, i + 1);
			} else {
				return everyNth(s, n, i + 1);
			}
		} else {
			return "";
		}
	}

	/**
	 * Returns a string containing only the characters of s whose position in s,
	 * counting from 1, is non-zero mod n. No credit if your solution uses a loop.
	 * For instance, given the parameters s = "abcabcabcabca" and n = 3, the output
	 * should be "ababababa".
	 * 
	 * @param s
	 * @param n
	 * @return the new string
	 */
	public static java.lang.String noNth(java.lang.String s, int n) {
		return noNth(s, n, 1);
	}

	private static java.lang.String noNth(java.lang.String s, int n, int i) {
		if (i <= s.length()) {
			if (i % n != 0) {
				return s.charAt(i - 1) + noNth(s, n, i + 1);
			} else {
				return noNth(s, n, i + 1);
			}
		} else {
			return "";
		}
	}

	/**
	 * Returns a copy of the input in which all contiguous sequences of identical
	 * characters are reduced to a single instance of that character. No credit if
	 * your solution uses a loop. For instance, on input "Foo bar bazzzzz !!", the
	 * output should be "Fo bar baz !"
	 * 
	 * @param s
	 * @return the new string
	 */
	public static java.lang.String unique(java.lang.String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}
		if (s.charAt(0) == s.charAt(1)) {
			return unique(s.substring(1, s.length()));
		}
		return s.charAt(0) + unique(s.substring(1, s.length()));

	}

	/**
	 * Returns the value of the numeric String number when converted to an integer.
	 * Use Character.getNumericValue() to get the numeric value of individual
	 * characters in number. No credit if your solution uses a loop or calls
	 * Integer.parseInt(). For instance, on input "12345" returns 12345.
	 * 
	 * @param number
	 * @return the string converted to int
	 */
	public static int toInt(java.lang.String number) {
		if (number.length() == 0) {
			return 0;
		}
		if (number.charAt(0) == '-') {
			return -1 * Math.abs(toInt(number.substring(1, number.length() - 1)) * 10
					+ Character.getNumericValue(number.charAt(number.length() - 1)));
		} else {
			return toInt(number.substring(0, number.length() - 1)) * 10
					+ Character.getNumericValue(number.charAt(number.length() - 1));
		}
	}

	/**
	 * Returns true if and only if the String s contains only matched brackets.
	 * There are four bracket types: '(' matches ')', '<' matches '>', '[' matches
	 * ']', and '{' matches '}' The opening bracket must always precede the matching
	 * closing bracket. A sequence of brackets is matching if it is empty, if it is
	 * an opening bracket immediately followed by its corresponding closing bracket,
	 * or if it is an opening bracket followed by a matched sequence of brackets and
	 * ends with a closing bracket. For instance, the following sequences are
	 * matched: "", "()", "<((({[]})))>()()[{}]<>" and these are unmatched: "{",
	 * "(])", ")(", "<((({[]}))>()()[{}]<>" HINT: This solution will need a loop to
	 * search for a pair of neighboring, matched braces. No credit if your solution
	 * uses more than one loop.
	 * 
	 * @param s
	 * @return true if the input sequence is matches, else false
	 */
	public static boolean isMatched(java.lang.String s) {
		if (s.length() == 0) {
			return true;
		}
		if (s.length() % 2 == 1 || s.charAt(0) == ')' || s.charAt(0) == '}' || s.charAt(0) == '>'
				|| s.charAt(0) == ']') {
			return false;
		}
		int x = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(0) == '<' && s.charAt(i) == '>') {
				x = i;
				i = s.length();
			}
			if (s.charAt(0) == '(' && s.charAt(i) == ')') {
				x = i;
				i = s.length();
			}
			if (s.charAt(0) == '[' && s.charAt(i) == ']') {
				x = i;
				i = s.length();
			}
			if (s.charAt(0) == '{' && s.charAt(i) == '}') {
				x = i;
				i = s.length();
			}
		}
		String str = s.substring(x + 1);
		return isMatched(str);
	}

	/**
	 * Efficiently computes base^exponent (where ^ is the exponentiation operator;
	 * that is 2^2 is 2 squared). No credit if your solution uses a loop. base^0 =
	 * 1, base^exponent = base * base^(exponent-1), and base^exponent =
	 * (base^(exponent/2))^2 = base^(exponent/2) * base^(exponent/2).
	 * 
	 * @param base
	 * @param exponent
	 * @return base raised to the power exponent
	 */
	public static double pow(double base, int exponent) {
		if (exponent == 0)
			return 1;
		else
			return base * pow(base, exponent - 1);
	}

}
