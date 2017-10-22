package Algorithms;

public class Cyclesort {

	public static int[] cycleSort(int arr[], int n) {
		for (int cycle_start = 0; cycle_start <= n - 2; cycle_start++) {
			int item = arr[cycle_start];
			int pos = cycle_start;
			for (int i = cycle_start + 1; i < n; i++)
				if (arr[i] < item)
					pos++;
			if (pos == cycle_start)
				continue;
			while (item == arr[pos])
				pos += 1;
			if (pos != cycle_start) {
				int temp = item;
				item = arr[pos];
				arr[pos] = temp;
			}
			while (pos != cycle_start) {
				pos = cycle_start;
				for (int i = cycle_start + 1; i < n; i++)
					if (arr[i] < item)
						pos += 1;
				while (item == arr[pos])
					pos += 1;
				if (item != arr[pos]) {
					int temp = item;
					item = arr[pos];
					arr[pos] = temp;
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] A = { 2, 1, 4, 6, 3, 5, 8, 7 };
		for (int i = 0; i < A.length; i++)
			System.out.print(A[i] + " ");
		System.out.println();
		int[] B = cycleSort(A, A.length);
		for (int i = 0; i < B.length; i++)
			System.out.print(B[i] + " ");
	}
}
