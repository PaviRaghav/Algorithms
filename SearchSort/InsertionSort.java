package Algorithms;

public class InsertionSort {
	public int[] insertionSort(int[] A) {
		for (int j = 1; j < A.length; j++) {
			int key = A[j];
			int i;
			for (i = j - 1; i >= 0; i--) {
				if (key > A[i])
					break;
				else
					A[i + 1] = A[i];
			}
			A[i + 1] = key;
		}
		return A;
	}
}
