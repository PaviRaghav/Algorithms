package Algorithms;

import Implementation.Stack_DynArray;

/**
 * This class is to evaluate a postfix expression
 * 
 * @author pavithraraghavan
 *
 */

public class Postfix {
	public void eval(String input) {
		try {
			Stack_DynArray<Integer> stk = new Stack_DynArray<Integer>();
			for (int i = 0; i < input.length(); i++) {
				char temp = input.charAt(i);
				if(Character.isDigit(temp))
					stk.push((int)temp);
				else {
					int b=stk.pop();
					int a=stk.pop();
					stk.push(operator(a,b,temp));
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
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
