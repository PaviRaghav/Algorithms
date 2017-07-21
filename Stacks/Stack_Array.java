package Implementation;

public class Stack_Array<E> implements Stacks<E> {
	private int size, top, maxSize;
	private E StackArray[];

	public Stack_Array(int size) {
		StackArray = (E[]) new Object[size];
		this.size = 0;
		this.top = -1;
		this.maxSize = size;
	}

	public E top() {
		if (this.top != -1)
			return StackArray[this.top];
		else
			return null;
	}

	public E pop() {
		if (!isEmpty()) {
			this.top--;
			this.size--;
			return StackArray[this.top+1];
		} else
			return null;
	}

	public boolean push(E item) {
		if (isFull())
			return false;
		else {
			StackArray[++this.top] = item;
			this.size++;
			return true;
		}
	}

	public int size() {
		return this.size;
	}

	public boolean isFull() {
		if (this.top == this.maxSize - 1)
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
}
