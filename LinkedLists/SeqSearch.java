package Algorithms;

public class SeqSearch {
	public int seq_search(int[] a, int x) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == x)
				return i;
		}
		return -1;
	}

	public int binary_search(int[] a, int x) {
		int low = 0, high = a.length, mid;
		while (low < high) {
			mid = (low + high) / 2;
			if (a[mid] == x)
				return mid;
			else if (a[mid] < x)
				low = mid + 1;
			else
				high = mid;
		}
		return -1;
	}

	public boolean isSorted(int[] a) {
		for (int i = 1; i < a.length; i++) {
			if (a.length < 2)
				return true;
			if (a[i] < a[i - 1])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 7, 7 };
		SeqSearch obj = new SeqSearch();
		System.out.println("i = " + obj.isSorted(a));
	}
}
