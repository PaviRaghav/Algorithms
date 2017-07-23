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
		E NewArray[] = (E[])new Object[a.length*2];
		for(int i=0;i<a.length;i++)
			NewArray[i]=a[i];
		return NewArray;
	}
	public E top() throws Exception {}
	public E pop() throws Exception {}
	public void push(E item) throws Exception {}
	public int size() {}
	public boolean isFull() {}
	public boolean isEmpty() {}
}
