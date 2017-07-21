package Implementation;

public interface Stacks {
	public Object top();
	public Object pop();
	public boolean push(Object item);
	public int size();
	public boolean isFull();
	public boolean isEmpty();
}
