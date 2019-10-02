package java8Practice.interview.search;

public class SearchingSolution {

	public int binarySearch(int[] arr, int key) {	
		if (arr.length==0) {
			return -1;
		}
		int start = 0;
		int end = arr.length-1;
		
		while(start <= end) {
			int mid = (start+end)/2;
			if(arr[mid]>key) {
				end = mid-1;
			}else if (arr[mid]<key) {
				start = mid+1;
			}else {
				return mid;
			}
		}	
		return -1;
	}
	
	public int recursiveBinarySearch(int[] arr, int key, int start, int end) {
		if(start > end) {return -1;}
		else {
			int mid = (start+end)/2;
			if (arr[mid]==key) {
				return mid;
			}
			else if (arr[mid]>key) {
				return recursiveBinarySearch(arr, key, start, mid-1);
			}else {
				return recursiveBinarySearch(arr, key, mid+1, end);
			}
		}		
	}
	
	//Cracking 10.5
//	public int binarySearchSparse(String[] stringList, String key, int start, int end) {
//
//		int mid = (start+end)/2;
		
//		if (stringList[mid]=="") {
//			int left = mid-1;
//			int right = mid+1;
//			while(left >= 0 && stringList[left]=="") {
//				left --;				
//			}
//			while(right<=end && stringList[right]=="") {
//				right++;
//			}
//			if (left <0 || right > end) {
//				return -1;
//			}
//			if (key == stringList[left]) {
//				return left;
//			}
//			if (key == stringList[right]) {
//				return right;
//			}
//		}else {
//			if (key < stringList[mid]) {
//				return
//			}
//		}
//			
//		return -1;
//	}
}
