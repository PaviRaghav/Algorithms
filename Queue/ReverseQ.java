package Algorithms;

import Implementation.*;

public class ReverseQ {
	public static void reverse(Q_LL q, int data) {
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
}
