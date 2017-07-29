package Implementation;

public class Stack_DynArray<E> implements Stacks<E> {
	private int top, maxSize;
	private E StackArray[];

	public Stack_DynArray() {
		StackArray = (E[]) new Object[1];
		this.top = -1;
		this.maxSize = 1;
	}

	private E[] doubleArray(E[] a) {
		int len;
		if (a.length == 0)
			len = 1;
		else
			len = a.length * 2;
		E NewArray[] = (E[]) new Object[len];
		for (int i = 0; i < a.length; i++)
			NewArray[i] = a[i];
		this.maxSize = len;
		return NewArray;
	}

	private E[] halfArray() {
		int len = this.maxSize / 2;
		E NewArray[] = (E[]) new Object[len];
		for (int i = 0; i < len; i++)
			NewArray[i] = this.StackArray[i];
		this.maxSize = len;
		this.top = len - 1;
		return NewArray;
	}

	public E top() throws Exception {
		if (this.top != -1)
			return StackArray[this.top];
		else
			throw new Exception("Stack is empty");
	}

	public E pop() throws Exception {
		if (!isEmpty()) {
			E x = StackArray[this.top];
			if (this.top == this.maxSize / 2)
				this.StackArray = halfArray();
			else
				this.top--;
			return x;
		} else
			throw new Exception("Stack is empty");
	}

	public void push(E item) throws Exception {
		if (this.top + 1 == this.maxSize) {
			this.StackArray = doubleArray(this.StackArray);
		}
		StackArray[++this.top] = item;
	}

	public int size() {
		return this.top + 1;
	}

	public boolean isFull() {
		if (top + 1 == this.maxSize)
			return true;
		else
			return false;
	}

	public boolean isEmpty() {
		if (this.top == -1)
			return true;
		else
			return false;
	}

	public String toString() {
		String s = "{ ";
		if (!isEmpty()) {
			s = s + StackArray[0];
			for (int i = 1; i < this.maxSize; i++) {
				s = s + ", " + StackArray[i];
			}
		}
		return s + "}";
	}
}
