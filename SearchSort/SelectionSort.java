package Algorithms;

public class SelectionSort {
	public int[] selectionSort(int[] A) {
		int tempIndex, temp;
		for (int i = 0; i < A.length - 1; i++) {
			tempIndex = i;
			for (int j = i+1; j < A.length; j++) {
				if (A[j] < A[tempIndex]) 
					tempIndex = j;
			}
			if (tempIndex != i) {
				temp = A[tempIndex];
				A[tempIndex] = A[i];
				A[i] = temp;
			}
		}
		return A;
	}
}
