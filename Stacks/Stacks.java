package Implementation;

public interface Stacks<E> {
	public E top() throws Exception;
	public E pop() throws Exception;
	public void push(E item) throws Exception;
	public int size();
	public boolean isFull();
	public boolean isEmpty();
}
