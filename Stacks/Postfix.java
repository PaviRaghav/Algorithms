package Algorithms;

import Implementation.Stack_DynArray;

/**
 * This class is to evaluate a postfix expression
 * 
 * @author pavithraraghavan
 *
 */

public class Postfix {
	public int eval(String input) {
		Stack_DynArray<Integer> stk = new Stack_DynArray<Integer>();
		int x = 0;
		try {
			for (int i = 0; i < input.length(); i++) {
				char temp = input.charAt(i);
				if (Character.isDigit(temp))
					stk.push((int) temp - 48);
				else {
					int b = stk.pop();
					int a = stk.pop();
					int c = operator(a, b, temp);
					stk.push(c);
				}
			}
			x = stk.pop();
		} catch (Exception e) {
			System.out.println(e);
		}
		return x;
	}

	public int operator(int a, int b, char op) {
		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			return a / b;
		default:
			return a;
		}
	}
}
