package java8Practice.interview.sort;

public class SortingSolution {

	public void quickSort(int[] arr, int start, int end) {		
		if(start >= end) {
			return;
		}
		int mid = partition(arr, start, end);
		quickSort(arr, start, mid-1);
		quickSort(arr, mid, end);		
	}
	
	private int partition(int[] arr, int start, int end ) {
		int pivot = arr[(start+end)/2];
		while (start <= end) {
			while(arr[start]<pivot) {
				start++;
			}
			while(arr[end]>pivot) {
				end--;
			}
			if(start <= end) {
				int temp = arr[end];
				arr[end] = arr[start];
				arr[start] = temp;		
				start++;
				end--;
			}
		}
		return start;
	}
	
	public void mergeSort(int[] arr, int start, int end)
	{
		
		if (start < end) {
			int mid = (start+end)/2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge (arr, start, mid, end);
		}
		
	}
	
	private void merge(int[] arr, int start, int mid, int end)
	{
		int[] copy = new int [end-start+1];
		for (int i=0; i<copy.length; i++) {
			copy[i] = arr[start+i];
		}
		int helperLeft = 0;
		int helperMid = mid-start;
		int helperRight = helperMid+1;
		int helperEnd = end-start;
		
		int current = start;

		while(helperLeft<=helperMid && helperRight<=helperEnd)
		{
			if(copy[helperLeft]>copy[helperRight]) {
				arr[current]=copy[helperRight];
				helperRight++;
			}else {
				arr[current] = copy[helperLeft];
				helperLeft++;
			}
			current++;
		}
		
		int remaining = helperMid - helperLeft;
		for (int i=0; i<=remaining; i++) {
			arr[current+i] = copy[helperLeft+i];
		}	
	}
	
	//Cracking 10.1
	public void sortedMerge(int[] a, int [] b, int lastA, int lastB) {
		int k=lastA+lastB+1;
		
		while (lastB>=0) {
			if(a[lastA]>b[lastB] && lastA >=0 ) {
				a[k]=a[lastA];
				lastA--;
			}else {
				a[k]=b[lastB];
				lastB--;
			}
			k--;
		}			
	}
	
	

	
	
}
