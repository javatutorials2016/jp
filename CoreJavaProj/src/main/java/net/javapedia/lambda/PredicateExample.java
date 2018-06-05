package net.javapedia.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		intList.add(4);
		intList.add(5);
		intList.add(6);
		intList.forEach(i -> {
			System.out.println(i);
		});

		// Filter elements that has value greater than 4
		
		Predicate<Integer> filter = i -> i > 4;

		intList.removeIf(filter);
		System.out.println("After applying removeIf function");

		intList.forEach(i -> {
			System.out.println(i);
		});

	}

}
