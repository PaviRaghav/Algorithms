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

	}

	public void push(int item) {
		try {
			stk_main.push(item);
			if (stk_aux.size() != 0) {
				if (stk_aux.top() > item)
					stk_aux.push(item);
				else
					stk_aux.push(stk_aux.top());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
