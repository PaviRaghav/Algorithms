package Implementation;

public class Stack_LL  {
	private SLL_List StackLL;
	private int top;
	public Stack_LL() {
		this.StackLL = new SLL_List();
		this.top=-1;
	}
	public int top() throws Exception {
		if (this.top != -1)
			return StackLL.getHead().getData();
		else
			throw new Exception("Stack is empty");
	}
	public int pop() throws Exception {}
	public void push(int item) throws Exception {}
	public int size() {}
	public boolean isEmpty() {
		if (this.top == -1)
			return true;
		else
			return false;
		}
}
