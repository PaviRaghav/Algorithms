package Algorithms;

import Implementation.*;

/**
 * this class is to use a stack to check if the input pattern balances symbols
 * 
 * @author pavithraraghavan
 *
 */
public class IsValidSymbolPattern {
	public boolean isValid(String input) throws Exception {
		if (input.length() == 0)
			throw new Exception("The input string is empty");
		Stack_DynArray<Character> obj = new Stack_DynArray<Character>();
		char[] a = new char[input.length()];
		input.getChars(0, input.length(), a, 0);
		for (char i : a) {
			if (i == '{' || i == '[' || i == '(')
				obj.push(i);
			if (i == '}' || i == ']' || i == ')') {
				if (obj.isEmpty())
					throw new Exception("Mismatched Pattern");
				else {
					char x = obj.pop();
					if ((i == '}' && x != '{') || (i == ')' && x != '(') || (i == ']' && x != '['))
						throw new Exception("Mismatched Pattern");
				}
			}
		}
		return true;
	}
}
