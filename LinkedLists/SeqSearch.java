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
		for (int i = a.length - 1; i >= 0; i--)
			b[a.length - i - 1] = a[i];
		return b;
	}

	public int[] concatenate(int[] a, int[] b) {
		if (a.length < 2)
			return b;
		if (b.length < 2)
			return a;
		int[] c = new int[a.length + b.length];
		for (int i = 0; i < a.length; i++)
			c[i] = a[i];
		for (int i = 0; i < b.length; i++)
			c[i + a.length] = b[i];
		return c;
	}

	public int[] tally(String string) {
		int[] tally = new int[26];
		char[] a = new char[string.length()];
		string = string.toUpperCase();
		string.getChars(0, string.length(), a, 0);
		for (char i : a) {
			if (Character.isLetter(i))
				tally[(int) i - 65]++;
		}
		return tally;
	}

	public double innerProd(double[] x, double[] y) {
		double innerProduct = 0.0;
		if (x.length != y.length)
			return 0.0;
		for (int i = 0; i < x.length; i++) {
			innerProduct = innerProduct + (x[i] * y[i]);
		}
		return innerProduct;
	}

	public double[][] outerProduct(double[] x, double[] y) {
		double[][] a = new double[x.length][y.length];
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < y.length; j++)
				a[i][j] = x[i] * y[j];
		}
		return a;
	}

	public double[][] transpose(double[][] original) {
		double[][] trans = new double[original[0].length][original.length];
		if (original.length > 0) {
			for (int i = 0; i < original[0].length; i++) {
				for (int j = 0; j < original.length; j++)
					trans[i][j] = original[j][i];
			}
		}

		return trans;

	}

	public static void main(String[] args) {
		double[][] a = { { 1, 2 }, { 3, 4 } , {5,6}};
		double[] b = { 1, 2, 3, 4, 5, 6, 7 };
		SeqSearch obj = new SeqSearch();

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.printf("  " + a[i][j]);
			}
			System.out.println();
		}

		double[][] d = obj.transpose(a);
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.printf("  " + d[i][j]);
			}
			System.out.println();
		}

		// System.out.println("innerProduct = " + obj.innerProd(a, b));
	}
}
