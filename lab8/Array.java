package lab8;

import java.util.ArrayList;

public class Array {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("dog");
		list.add("dog");
		list.add("cat");
		list.add("cat");
		list.add("fish");
		list.add("fish");
		System.out.println(list);
		removeDuplicates(list);
		System.out.println(list);
	}

	public static void removeDuplicates(ArrayList<String> words) {
		ArrayList<String> newList = new ArrayList<>();
		for (int i = 0; i<words.size(); i++) {
			if (!newList.contains(words.get(i))) {
				newList.add(words.get(i));
			}
		}
		words.clear();
		words.addAll(newList);
	}
}
