package lab7;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayExamples {
	public static void main(String[] args) {
		String s = "-12 5 -3 9 10";
		int[] result = readNumbers(s);
		System.out.println(Arrays.toString(result));
		System.out.println(Arrays.toString(getPositiveNumbers(result)));
		System.out.println(Arrays.toString(randomExperiment(10, 1000)));
		
	}

	public static int[] readNumbers(String text) {
		Scanner scanner = new Scanner(text);
		int count = 0;
		while (scanner.hasNextInt()) {
			scanner.nextInt();
			count += 1;
		}

		int[] nums = new int[count];
		scanner = new Scanner(text);
		int index = 0;
		while (scanner.hasNextInt()) {
			int num = scanner.nextInt();
			nums[index] = num;
			index += 1;
		}
		return nums;
	}

	public static int[] getPositiveNumbers(int[] numbers) {
		int positives = 0;
		int j = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > 0) {
				positives++;
			}
		}
		int[] positiveNumbers = new int[positives];
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > 0) {
				positiveNumbers[j] = numbers[i];
				j++;
			}
		}
		return positiveNumbers;
	}

	public static int[] randomExperiment(int max, int iters) {
		Random r = new Random();
		int[] array = new int[iters];
		for (int i = 0; i<iters; i++) {
			array[i] = r.nextInt(max-1);
			}
		return array;
		}
}
