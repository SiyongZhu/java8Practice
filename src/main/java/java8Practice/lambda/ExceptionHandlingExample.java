package java8Practice.lambda;

import java.util.function.BiConsumer;

import java8Practice.JavaExampleTest;

public class ExceptionHandlingExample implements JavaExampleTest {

	@Override
	public void run() {
		int[] someNumbers = {1, 2, 3 ,4 ,5};
		int key = 0;
		
		process(someNumbers, key, wrapperLambda((v, k) -> System.out.println(v/k)));

	}

	private void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
		// TODO Auto-generated method stub
		for (int i: someNumbers) {
			consumer.accept(i, key);;
		}	
	}
	
	//Use a wrapper lambda to catch exception thrown by lambda function
	//wrapper lambda takes a functional interface and returns a functional interface
	private BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
		return (v, k) -> {
			try {
				consumer.accept(v, k);
			}catch (ArithmeticException ae) {
				System.out.println("Wrapper Lambda caught the exception");
			}
		};
	}

}
