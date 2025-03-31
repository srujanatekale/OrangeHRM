package com.neotech.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListOfMaps {

	public static void main(String[] args) {

		List<Map<String, String>> listOfMaps = new ArrayList<>();

		Map<String, String> user1 = new HashMap<>();
		user1.put("firstName", "Sepideh");
		user1.put("lastName", "Fattahi");

		listOfMaps.add(user1);

		Map<String, String> user2 = new HashMap<>();
		user2.put("firstName", "Emrah");
		user2.put("lastName", "Nalbantoglu");

		listOfMaps.add(user2);

		System.out.println(listOfMaps);

	}

}
