package Algorithms;

import Implementation.*;

/**
 * this class is to find out if every pair of elements in a stack is consecutive
 * 
 * @author pavithraraghavan
 *
 */
public class Consecutive {
	public static boolean isConsecutive(Stack_LL stk) {
		boolean x = false;
		try {
			while (stk.size() > 1) {
				int temp = stk.pop();
				if (temp == stk.top() + 1 || temp + 1 == stk.top()) {
					stk.pop();
					x = true;
				} else {
					x = false;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return x;
	}
}
