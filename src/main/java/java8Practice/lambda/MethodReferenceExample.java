package java8Practice.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import java8Practice.JavaExampleTest;

public class MethodReferenceExample implements JavaExampleTest {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// Thread t = new Thread(() -> printMessage()); // this is same as below
		Thread t = new Thread(MethodReferenceExample::printMessage); //<= this is a static reference
		t.start();
		
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 45),
				new Person("Robert Louis", "Steveson", 25),
				new Person("Jane", "Austin", 25),
				new Person("Charlotte", "Bronte", 25),
				new Person("Thomas", "Carlyle", 25),
				new Person("Lewis", "Carroll", 65),
				new Person("Matthew", "Arnold", 65)
				);
		
		performConditionally(people, p -> true, System.out::println); // <= This is an instance method reference
																	  // <= (p) <- method(p) can be replace with this format
	}
	
	private void performConditionally(List<Person> people, Predicate<Person> predicate,
										Consumer<Person> consumer) {
		people.forEach(p -> {if (predicate.test(p) ) { consumer.accept(p);}});
	}
	

	public static void printMessage() {
		System.out.println("Hello");
	}

}
