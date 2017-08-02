package Algorithms;

import Implementation.*;

/**
 * This class is to sort a stack
 * 
 * @author pavithraraghavan
 *
 */

public class SortStack {
	public Stack_LL seqSort(Stack_LL stk) {
		Stack_LL rstk = new Stack_LL();
		try {
			while (!stk.isEmpty()) {
				int tmp = stk.pop();
				while (!rstk.isEmpty() && rstk.top() > tmp)
					stk.push(rstk.pop());
				rstk.push(tmp);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return rstk;
	}
}
