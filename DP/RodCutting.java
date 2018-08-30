import java.util.*;

/*
Length of a rod is given. cost of cutting the rod = length of the rod. Also give the points where the rod can be cut.
Find the order of cutting the rod so that the cost is minimised.
 */
class RodCutting {
	public int[] rodCut(int A, int[] B) {
		if (B.length <= 1)
			return B;
		int[] result = new int[B.length];
		int[] B1 = new int[B.length + 2];
		for (int i = 0; i < B.length; i++)
			B1[i + 1] = B[i];
		B1[B1.length - 1] = A;
		int[][] arr = new int[B1.length][B1.length];
		// diagonal and one above and below diagonal = 0
		for (int i = 0; i < arr.length - 2; i++) {
			int j = i + 2;
			arr[i][j] = B1[j] - B1[i];
			arr[j][i] = j - 1;
		}
		int m = 3;
		while (m < arr.length) {
			for (int i = 0; i < arr.length - m; i++) {
				int j = i + m;
				arr[i][j] = Integer.MAX_VALUE;
				for (int k = i + 1; k < j; k++) {
					int cost = arr[i][k] + arr[k][j];
					if (arr[i][j] > cost) {
						arr[i][j] = cost;
						arr[j][i] = k;
						// System.out.println("k " + arr[j][i]);
					}
				}
				if (arr[i][j] == Integer.MAX_VALUE)
					arr[i][j] = 0;
				else
					arr[i][j] += B1[j] - B1[i];
			}
			m++;
		}
		ArrayList<Integer> x = new ArrayList<Integer>();
		constructResult(arr, B1.length - 1, 0, x);
		// System.out.println(x);
		for (int i = 0; i < result.length; i++) {
			result[i] = B1[x.get(i)];
		}
		return result;
	}

	private void constructResult(int[][] arr, int a, int b, ArrayList<Integer> result) {
		int ind = arr[a][b];
		if (ind == 0)
			return;
		result.add(ind);
		constructResult(arr, ind, b, result);
		constructResult(arr, a, ind, result);
	}
}
