package Algorithms;

public class Cyclesort {

	public int[] cycleSort(int arr[], int n) {
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
				arr[pos] = temp;System.out.println();
				for (int i = 0; i < arr.length; i++)
					System.out.print(arr[i] + " ");
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
					arr[pos] = temp;System.out.println();
					for (int i = 0; i < arr.length; i++)
						System.out.print(arr[i] + " ");
				}
			}
		}
		return arr;
	}
}
