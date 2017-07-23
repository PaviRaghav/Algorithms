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
		this.maxSize=a.length*2;
		return NewArray;
	}
	private E[] halfArray(E[] a) {
		int len=a.length/2;
		E NewArray[] = (E[])new Object[len];
		for(int i=0;i<len;i++)
			NewArray[i]=a[i];
		this.maxSize=len;
		return NewArray;
	}
	public E top() throws Exception {}
	public E pop() throws Exception {}
	public void push(E item) throws Exception {}
	public int size() {return this.top+1;}
	public boolean isFull() {if(top+1==this.maxSize) return true; else return false;}
	public boolean isEmpty() {if(this.top==-1) return true; else return false; }
}
