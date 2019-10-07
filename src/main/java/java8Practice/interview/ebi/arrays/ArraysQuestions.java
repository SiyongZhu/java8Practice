package java8Practice.interview.ebi.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArraysQuestions {

	// 6.7
	public int maxProfitOneStock(List<Integer> prices) {
		int localMin = prices.get(0);
		int maxProfit = 0;
		for(int i=0; i<prices.size(); i++) {
			if (prices.get(i) < localMin) { localMin = prices.get(i); }
			if (prices.get(i) - localMin > maxProfit) {
				maxProfit = prices.get(i) - localMin;
			}	
		}
		return maxProfit;
	}
	
	// 6.12
	public static List<Integer> GenerateRandomSubset(List<Integer> array, int k) {
		Random gen = new Random();
		
		List<Integer> subset = new ArrayList<Integer>();
		
		for (int i=0; i<k; i++) {
			int swapIndex = gen.nextInt(array.size()-i);
			int temp = array.get(i);
			array.set(i, array.get(i+swapIndex));
			array.set(swapIndex, temp);
			subset.add(array.get(i));
		}
		return subset;
	}
	
	public static void main(String[] args) {

		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		
		GenerateRandomSubset(list1, 3).forEach(i -> System.out.println(i));
		System.out.println();
		list1.forEach(i->System.out.println(i));
	}

}
