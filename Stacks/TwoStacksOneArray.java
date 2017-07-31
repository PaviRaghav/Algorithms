package Algorithms;

/**
 * This class is to implement 2 stacks using a single array
 * 
 * @author pavithraraghavan
 *
 */
public class TwoStacksOneArray {
	private int[] stk;
	int top1, top2, len;

	public TwoStacksOneArray(int size) {
		len = size * 2;
		this.stk = new int[len];
		this.top1 = -1;
		this.top2 = len;
	}

	public boolean isEmpty(int StackID) {
		if (StackID == 1) {
			if (this.top1 == -1)
				return true;
			else
				return false;
		} else if (StackID == 2) {
			if (this.top1 == this.len)
				return true;
			else
				return false;
		} else
			return true;
	}

	public boolean isFull() {
		if (this.top1 == this.top2)
			return true;
		else
			return false;
	}

	public void push(int StackID, int data) {
		if (StackID == 1) {
			if (!isFull())
				stk[++this.top1] = data;
			else
				System.out.println("Stack is full");
		} else if (StackID == 2) {
			if (!isFull())
				stk[--this.top2] = data;
			else
				System.out.println("Stack is full");
		}
	}
}
