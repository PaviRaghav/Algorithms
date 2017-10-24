package Algorithms;

public class FibonacciSeries {
	public int fib_BottomUp(int n) {
		int[] table = new int[n + 1];
		table[0] = 1;
		table[1] = 1;
		for (int i = 2; i < n; i++) {
			table[i] = table[i - 1] + table[i - 2];
		}
		return table[n - 1];
	}

	public int fib_TopDown(int n) {
		int[] table = new int[n + 1];
		table[0] = 1;
		table[1] = 1;
		return fib(n, table);
	}

	private int fib(int n, int[] table) {
		if (table[n] != 0) {
			table[n] = table[n - 1] + table[n - 2];
			return table[n];
		} else
			return table[n];
	}
}
