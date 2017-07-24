package Implementation;

public class Stack_LL<E> implements Stacks<E> {
	private int top, maxSize;
	public E top() throws Exception {}
	public E pop() throws Exception {}
	public void push(E item) throws Exception {}
	public int size() {}
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
