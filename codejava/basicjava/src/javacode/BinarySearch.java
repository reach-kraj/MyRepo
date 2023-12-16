package javacode;

public class BinarySearch {

	public static int binarySearch(int[] arr, int x) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == x) {
				return mid;
			} else if (arr[mid] < x) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int x = 7;
		int result = binarySearch(arr, x);
		if (result == -1) {
			System.out.println("Element is not present in the Array");
		} else {
			System.out.println("Element is present in the Array");
		}
	}
}
