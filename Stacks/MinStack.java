package Algorithms;

import Implementation.*;

/**
 * This class is to find the minimum element in the stack with O(1) time
 * 
 * @author pavithraraghavan
 *
 */
public class MinStack {
	private Stack_LL stk_main = new Stack_LL();
	private Stack_LL stk_aux = new Stack_LL();

	public int getMin() {
		int x = 0;
		try {
			x = stk_aux.top();
		} catch (Exception e) {
			System.out.println(e);
		}
		return x;
	}

	public void push(int item) {
		try {
			stk_main.push(item);
			if (stk_aux.size() != 0) {
				if (stk_aux.top() > item)
					stk_aux.push(item);
				else
					stk_aux.push(stk_aux.top());
			} else
				stk_aux.push(item);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public int pop() {
		int x = 0;
		try {
			x = stk_main.pop();
			stk_aux.pop();
		} catch (Exception e) {
			System.out.println(e);
		}
		return x;
	}
}
