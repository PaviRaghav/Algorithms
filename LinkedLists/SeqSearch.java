package Algorithms;

import java.util.Arrays;

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

	public int minElement(int[] a) {
		if (a.length == 0)
			return 0;
		int min = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] < min)
				min = a[i];
		}
		return min;
	}

	public double mean(int[] a) {
		int sum = a[0];
		for (int i = 1; i < a.length; i++) {
			sum += a[i];
		}
		return (double) sum / a.length;
	}

	public int[] withoutDup(int[] a) {
		if (a.length < 2)
			return a;
		int[] b = new int[a.length];
		int count = 1;
		b[0] = a[0];
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < count; j++) {
				if (a[i] == b[j])
					break;
				if (j == count - 1 && a[i] != b[j]) {
					b[count] = a[i];
					count++;
				}
			}
		}
		return b;
	}

	public int[] reverse(int[] a) {
		if (a.length < 2)
			return a;
		int[] b = new int[a.length];
		for(int i=a.length-1; i>=0 ; i--)
			b[a.length-i-1]=a[i];
		return b;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6 };
		SeqSearch obj = new SeqSearch();
		int[] b = obj.reverse(a);
		for (int i = 0; i < b.length; i++)
			System.out.println(b[i]);
		// System.out.println("i = " + obj.mean(a));
	}
}
