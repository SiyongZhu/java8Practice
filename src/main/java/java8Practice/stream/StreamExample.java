package java8Practice.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import java8Practice.JavaExampleTest;

public class StreamExample implements JavaExampleTest{

	@Override
	public void run() {
		Stream<String> stream1 = Stream.of("a", "b", "c");
		
		List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f");
		Stream<String> stream2 = list.parallelStream();
		stream2.forEach(n -> {System.out.print(n+" ");});
		System.out.println("\n-----------------------------");
		
		
		ArrayList<Integer> arrL = new ArrayList<Integer>(); 
		for(int i=1; i<=10; i++) {
			arrL.add(i);
		}
		arrL.forEach(n -> {System.out.print(n+" ");});
		
		System.out.println("\n-----------------------------");
		
	}

}
