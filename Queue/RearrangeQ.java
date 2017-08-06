package Algorithms;

import Implementation.*;

public class RearrangeQ {
	public void mixHalves(Q_LL q) {
		// 1,2,3,4,5, 6,7,8,9,10 ==> 1,6,2,7,3,8,4,9,5,10
		if (q.size() % 2 != 0)
			throw new IllegalStateException();
		Stack_LL stk = new Stack_LL();
		int half = q.size() / 2;
		for (int i = 0; i < half; i++)
			insertAtBottom(stk, q.dequeue());
		while (!stk.isEmpty()) {
			try {
				q.enqueue(stk.pop());
				q.enqueue(q.dequeue());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public void insertAtBottom(Stack_LL stk, int item) {
		try {
			if (stk.isEmpty())
				stk.push(item);
			else {
				int temp = stk.pop();
				insertAtBottom(stk, item);
				stk.push(temp);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
