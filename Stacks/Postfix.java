package Algorithms;

import Implementation.Stack_DynArray;

/**
 * This class is to evaluate a postfix expression
 * 
 * @author pavithraraghavan
 *
 */

public class Postfix {
	public int eval(String[] input) {
		Stack_DynArray<Integer> stk = new Stack_DynArray<Integer>();
		int x = 0;
		try {
			for (String temp : input) {
				if (temp == "+" || temp == "*" || temp == "/" || temp == "-") {
					int b = stk.pop();
					int a = stk.pop();
					int c = operator(a, b, temp);
					stk.push(c);
				} else
					stk.push(Integer.parseInt(temp));
			}
			x = stk.pop();
		} catch (Exception e) {
			System.out.println(e);
		}
		return x;
	}

	public int operator(int a, int b, String op) {
		if (op == "+")
			return a + b;
		else if (op == "-")
			return a - b;
		else if (op == "*")
			return a * b;
		else if (op == "/")
			return a / b;
		else
			return a;
	}
}
