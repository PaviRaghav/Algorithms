package Algorithms;

public class Quicksort {
	public int[] quickSort(int[] A) {
		if (A.length < 2)
			return A;
		return sort(A, 0, A.length - 1);
	}

	private int[] sort(int[] A, int start, int end) {
		if (start < end) {
			int q = partition(A, start, end);
			sort(A, start, q);
			sort(A, q + 1, end);
		}
		return A;
	}

	private int partition(int[] A, int start, int end) {
		// 7 2 9 3 6 4 1
		if (A.length == 2)
			return start;
		int key = A[start];
		int loop, partition = start, temp;
		for (loop = start+1; loop <=end; loop++) {
			if (A[loop] < key) {
				partition++;
				temp = A[loop];
				A[loop] = A[partition];
				A[partition] = temp;
			}
		}
		temp = A[partition];
		A[partition] = A[start];
		A[start] = temp;
		return partition;
	}
}
