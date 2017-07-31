package Algorithms;

import Implementation.*;

/**
 * This class is to reverse a stack by just using push and pop
 * 
 * @author pavithraraghavan
 *
 */
public class ReverseStack {
	public static void reverse(Stack_LL stk) {
		try {
			if (stk.isEmpty())
				return;
			int temp = stk.pop();
			reverse(stk);
			insertAtBottom(stk, temp);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void insertAtBottom(Stack_LL stk, int data) {
		try {
			if (stk.isEmpty()) {
				stk.push(data);
				return;
			}
			int temp = stk.pop();
			insertAtBottom(stk, data);
			stk.push(temp);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
