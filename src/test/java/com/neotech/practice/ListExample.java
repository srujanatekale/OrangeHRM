package com.neotech.practice;

import java.util.ArrayList;
import java.util.List;

public class ListExample {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("Fasry");
		list.add("Nargiza");
		list.add("Preethi");

		System.out.println(list);

		for (String name : list) {
			System.out.println(name);
		}
	}

}
