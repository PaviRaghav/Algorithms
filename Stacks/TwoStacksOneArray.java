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

	public boolean stk1_isEmpty() {
		if (top1 == -1)
			return true;
		else
			return false;
	}

	public boolean stk2_isEmpty() {
		if (top1 == this.len)
			return true;
		else
			return false;
	}
}
