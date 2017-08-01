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
}
