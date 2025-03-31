package com.neotech.practice;

import java.util.ArrayList;
import java.util.List;

public class ListOfPerson {

	public static void main(String[] args) {

		Person p1 = new Person("Tima", 27);

		List<Person> listOfPeople = new ArrayList<>();
		listOfPeople.add(p1);
		listOfPeople.add(new Person("Emin", 25));
		listOfPeople.add(new Person("Risha", 26));

		System.out.println(listOfPeople);

		for (Person p : listOfPeople) {
			System.out.println(p);
		}
	}

}

class Person {
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return name + " " + age;
	}
}
