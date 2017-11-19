package Algorithms;

import Implementation.*;

public class ReverseQ {
	public void reverse(Q_LL q, int data) {
		Stack_LL stk = new Stack_LL();
		try {
			while (!q.isEmpty())
				stk.push(q.dequeue());
			while (!stk.isEmpty())
				q.enqueue(stk.pop());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void reversePart(Q_LL q, int k) {
		try {
			Stack_LL stk = new Stack_LL();
			for (int i = 0; i < k; i++)
				stk.push(q.dequeue());
			while (!stk.isEmpty())
				q.enqueue(stk.pop());
			for (int i = 0; i < q.size() - k; i++)
				q.enqueue(q.dequeue());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
