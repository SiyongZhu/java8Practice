package java8Practice.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import java8Practice.JavaExampleTest;

public class LambdaExpression implements JavaExampleTest {

	public void run() {
		System.out.println("Running some lambda example");
		
		MyLambda myLambdaFunc = () -> System.out.println("This is lambda function");
		
		MyLambda2 myLambdaFunc2 = (a, b) -> a+b;
		myLambdaFunc.foo();
		System.out.println(myLambdaFunc2.foo(2, 3));
		
		
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 45),
				new Person("Robert Louis", "Steveson", 25),
				new Person("Jane", "Austin", 25),
				new Person("Charlotte", "Bronte", 25),
				new Person("Thomas", "Carlyle", 25),
				new Person("Lewis", "Carroll", 65),
				new Person("Matthew", "Arnold", 65)
				);
		
		//The Comparator interface is a functional interface, thus it can take a lambda expression
		Collections.sort(people, (Person p1, Person p2) -> p1.getLastName().compareTo(p2.getLastName()));
		
		printAll(people);
		
		//Use a print and take a lambda function as input
		System.out.println("\n\nPrint last name starts with C ");
		printNames(people, p -> p.lastName.startsWith("C"));
		

		System.out.println("\n\nPrint first name starts with C ");
		printNames(people, p -> p.firstname.startsWith("C"));
		
		//Use a print and use return true as test function
		System.out.println("\n\nPrint all names again ");
		printNames(people, p -> true);
		
		System.out.println("\n\nPrint last name starts with D ");
		printWithPredicate(people, p -> p.lastName.startsWith("D"));
	}

	private void printAll(List<Person> people) {
		for (Person p: people) {
			System.out.println(p);
		}	
	}
	
	//Condition interface will run test function
	private void printNames(List<Person> people, Condition condition) {
		for(Person p: people) {
			if (condition.test(p)) {
				System.out.println(p);
			}
		}	
	}
	
	//Java provides existing interfaces that handle common input/out parameters 
	//e.g it is common to interface to include a method takes in any type, and returns boolean
	private void printWithPredicate(List<Person> people, Predicate<Person> predicate) {
		for (Person p: people) {
			if(predicate.test(p)) {
				System.out.println(p);
			}
		}
	}
}

//Define functional interface which contains a function with Person as parameter
@FunctionalInterface
interface Condition {
	boolean test(Person p);
}


interface MyLambda {
	void foo();
}

interface MyLambda2 {
	int foo(int a, int b);
}
