package java8Practice.interview.sort;

import java.util.Arrays;

import java8Practice.JavaExampleTest;

public class SortTest  implements JavaExampleTest {

	

	@Override
	public void run() {
		int[] array1 = {3, 9, 4, 8, 10, 5, 3, 1};
		
		SortingSolution ss = new SortingSolution();
		ss.quickSort(array1, 0, array1.length-1);
		System.out.println(Arrays.toString(array1));
		
		int[] array2 = {3,1,2,4};
		ss.mergeSort(array2, 0, array2.length-1);
		System.out.println(Arrays.toString(array2));
		
		int[] array3A = {1,3,5,5,0,0};
		int[] array3B = {2,5};
		ss.sortedMerge(array3A, array3B, 3, 1);
		System.out.println(Arrays.toString(array3A));
	}
	
	
	

}
