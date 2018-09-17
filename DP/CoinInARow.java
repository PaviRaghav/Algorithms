import java.util.*;

/*
There are N coins (Assume N is even) in a line. 
Two players take turns to take a coin from one of the ends of the line until there are no more coins left. 
The player with the larger amount of money wins. Assume that you go first.

Write a program which computes the maximum amount of money you can win.
 */
class CoinInARow {
	public int maxcoin(int[] A) {
		return maxCoin(A, 0, A.length - 1, new int[A.length][A.length]);
	}

	private int maxCoin(int[] coins, int a, int b, int[][] max) {
		if (a > b)
			return 0;
		if (max[a][b] == 0) {
			int maxA = coins[a] + Math.min(maxCoin(coins, a + 2, b, max), maxCoin(coins, a + 1, b - 1, max));
			int maxB = coins[b] + Math.min(maxCoin(coins, a, b - 2, max), maxCoin(coins, a + 1, b - 1, max));
			max[a][b] = Math.max(maxA, maxB);
		}
		return max[a][b];
	}
}
