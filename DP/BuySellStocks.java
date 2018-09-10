import java.util.*;

/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
(ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions at the same time 
(ie, you must sell the stock before you buy again).
*/

/*
 1 2 3 4 5
profit
buy: profit - A[i];
sell: profit + A[i]
buy, sell, buy, sell, buy, sell...
 */

class BuySellStocks {
	public int maxProfit(final int[] A) {
		if (A.length < 2)
			return 0;
		int nextsell = A[A.length - 1];
		int nextbuy = 0;
		for (int col = A.length - 2; col >= 0; col--) {
			int currsell;
			int currbuy;
			currsell = Math.max(nextsell, A[col] + nextbuy);
			currbuy = Math.max(nextbuy, ((-1) * A[col]) + nextsell);
			nextsell = currsell;
			nextbuy = currbuy;
		}
		if (nextbuy < 0)
			return 0;
		return (int) nextbuy;
	}
}
