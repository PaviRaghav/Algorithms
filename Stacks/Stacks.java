package Implementation;

public interface Stacks<E> {
	public E top();
	public E pop();
	public boolean push(E item);
	public int size();
	public boolean isFull();
	public boolean isEmpty();
}
