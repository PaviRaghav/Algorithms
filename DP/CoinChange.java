package Algorithms;

public class CoinChange {
	public int coinChange(int n, int i, int[] S) {
		if (n <= 0)
			return 0;
		//if(n==0) return 1;
		if(n==S[i]) return 1;
		int there = coinChange(n - S[i], i, S);
		int notThere = (i<S.length-1)?coinChange(n, i+1, S):0;
		return there + notThere;
	}

	public int coinChange(int n, int[] S) {
		return coinChange(n, 0, S);
	}
	
	public static void main(String[] args) {
		CoinChange obj = new CoinChange();
		int[] S = {1,2,5};
		System.out.println(obj.coinChange(5, S));
	}
}
