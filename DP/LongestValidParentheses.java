import java.util.*;

/*
Given a string containing just the characters '(' and ')', 
find the length of the longest valid (well-formed) parentheses substring.
 */
class LongestValidParentheses.java {
	public int longestValidParentheses(String A) {
		Stack<Integer> stk = new Stack<Integer>();
		int[] arr = new int[A.length()];
		for (int i = 0; i < A.length(); i++) {
			char x = A.charAt(i);
			if (x == '(') {
				stk.push(i);
			} else {
				if (!stk.isEmpty()) {
					int y = stk.pop();
					arr[y] = i;
				}
			}
		}
		int k = 0;
		int currlen = 0;
		int maxLen = 0;
		while (k < arr.length) {
			if (arr[k] == 0) {
				currlen = 0;
				k++;
			} else {
				currlen += arr[k] - k + 1;
				k = arr[k] + 1;
			}
			maxLen = Math.max(maxLen, currlen);
		}
		return maxLen;
	}
}
