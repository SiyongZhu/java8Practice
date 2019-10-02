package java8Practice.interview.search;

import java8Practice.JavaExampleTest;

public class SearchTest implements JavaExampleTest {

	@Override
	public void run() {

		int[] search = {2, 3, 4, 5, 6, 7, 8, 9};
		
		SearchingSolution ss = new SearchingSolution();
		
		int key = 0;
		System.out.println(String.format("binarysearch for %d is %d ", key, ss.binarySearch(search, key)));
		
		key = 10;
		System.out.println(String.format("RecursiveBinarysearch for %d is %d ", key, ss.recursiveBinarySearch(search, key, 0, search.length-1)));
	}

}
