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
	
	//Cracking 10.9 -- native solution
	public boolean findValueinSortedMatrix(int[][] matrix, int key) {
		int row = 0;
		int col = matrix[0].length;
		while (row<matrix.length && col > 0) {
			if(matrix[row][col]==key) {return true;}
			if(matrix[row][col]>key) {
				col--;
			}else {
				row++;
			}
		}
		return false;
		
	}
	
	//Cracking 10.3
	private int findPivotPos(int[] arr) {
		
		int start = 0;
		int end = arr.length-1;
		if (arr[end] >arr[start]) return -1;
		int mid=0;
		while(start <= end) {
			mid = (start +end) / 2;
			if(arr[mid]>arr[mid+1] && arr[mid]<arr[mid-1]) {
				return mid;
			}
			else if (arr[mid]<arr[end]) {
				end = mid-1;
			}else if (arr[mid]>arr[start]) {
				start = mid+1;
			}
		}
		return mid;
	}
	
	public int binarySearchRotated(int[] arr, int key) {
		
		int pivot = findPivotPos(arr);
		
		if (pivot == -1) { 
			return recursiveBinarySearch(arr, key, 0, arr.length-1);
		} else if (arr[pivot] == key) {
			return pivot;
		} else if (key >= arr[0]) {
			return recursiveBinarySearch(arr, key, 0, pivot-1);
		} else {
			return recursiveBinarySearch(arr, key, pivot+1, arr.length-1);
		}		
	}
	
	// 10.3 
	public int search(int[] arr, int key) {
	    int left = 0;
	    int right= arr.length-1;
	 
	    while(left<=right){
	        int mid = left + (right-left)/2;
	        if(key==arr[mid])
	            return mid;
	        // if left range doesn't contain breaking point
	        if(arr[left]<=arr[mid]){
	        	// if 
	            if(arr[left]<=key&& key<arr[mid]){
	                right=mid-1;
	            }else{
	                left=mid+1;
	            }
	        }else{ // right range doesn't contain breaking point
	            if(arr[mid]<key&& key<=arr[right]){
	                left=mid+1;
	            }else{
	                right=mid-1;
	            }
	        }    
	    }
	 
	    return -1;
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
