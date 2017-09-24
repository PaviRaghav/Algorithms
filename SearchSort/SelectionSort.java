package Algorithms;

public class SelectionSort {
	public int[] selectionSort(int[] A) {
		int tempIndex, temp;
		for (int i = 0; i < A.length - 1; i++) {
			temp = A[i];
			tempIndex = i;
			for (int j = i; j < A.length; j++) {
				if (A[j] < temp) {
					temp = A[j];
					tempIndex = j;
				}
			}
			if (tempIndex != i) {
				A[tempIndex] = A[i];
				A[i] = temp;
			}
		}
		return A;
	}
}
