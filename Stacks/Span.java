package Algorithms;

import Implementation.*;

/**
 * This class is to find the span of every element in a given array
 * 
 * @author pavithraraghavan
 *
 */
public class Span {
	public int[] findSpan(int[] inputArray) {
		int[] spans = new int[inputArray.length];
		for (int i = 0; i < inputArray.length; i++) {
			int span = 1;
			int j = i - 1;
			while (j >= 0 && inputArray[j] <= inputArray[j + 1]) {
				span++;
				j--;
			}
			spans[i] = span;
		}
		return spans;
	}

	public int[] improvedFindSpan(int[] inputArray) {
		Stack_LL stk = new Stack_LL();
		int[] spans = new int[inputArray.length];
		int p = -1;
		try {
			for (int i = 0; i < inputArray.length; i++) {
				if (p != -1 && inputArray[i] > inputArray[p])
					stk.pop();
				if (stk.isEmpty())
					p = -1;
				else
					p = stk.top();
				spans[i] = i - p;
				stk.push(i);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		for (int i = 0; i < inputArray.length; i++)
			System.out.println(spans[i] + " ");
		return spans;
	}

	public static void main(String[] args) {
		int[] inputArray = { 6, 3, 4, 5, 2 };
		Stack_LL stk = new Stack_LL();
		int[] spans = new int[inputArray.length];
		int p = 0;
		try {
			for (int i = 0; i < inputArray.length; i++) {
				if (!stk.isEmpty()) {
					if (inputArray[i] > inputArray[stk.top()])
						stk.pop();
				}
				if (stk.isEmpty())
					p = -1;
				else
					p = stk.top();
				spans[i] = i - p;
				stk.push(i);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		for (int i = 0; i < inputArray.length; i++)
			System.out.println(spans[i] + " ");
	}
}
