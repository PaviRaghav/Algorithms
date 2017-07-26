package Implementation;

/**
 * Stack implementation with Arrays
 * 
 * @author pavithraraghavan
 *
 * @param <E>
 */
public class Stack_Array<E> implements Stacks<E> {
	private int top, maxSize;
	private E StackArray[];

	public Stack_Array(int size) {
		StackArray = (E[]) new Object[size];
		this.top = -1;
		this.maxSize = size;
	}

	public E top() throws Exception {
		if (this.top != -1)
			return StackArray[this.top];
		else
			throw new Exception("Stack is empty");
	}

	public E pop() throws Exception {
		if (!isEmpty())
			return StackArray[this.top--];
		else
			throw new Exception("Stack is empty");
	}

	public void push(E item) throws Exception {
		if (isFull())
			throw new Exception("Stack is already full");
		else
			StackArray[++this.top] = item;
	}

	public int size() {
		return this.top + 1;
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
