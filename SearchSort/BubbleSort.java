package Algorithms;

public class BubbleSort {
	public static int[] bubbleSort(int[] A) {
		for (int i = A.length - 1; i > 0; i--) {
			for (int j = 0; j <= i - 1; j++) {
				if (A[j] > A[j + 1]) {
					// exchange
					int temp = A[j];
					A[j] = A[j + 1];
					A[j + 1] = temp;
				}
			}
		}
		return A;
	}
}
