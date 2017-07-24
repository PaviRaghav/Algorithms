package Implementation;

public class Stack_LL {
	private SLL_List StackLL;
	private int top;

	public Stack_LL() {
		this.StackLL = new SLL_List();
		this.top = 0;
	}

	public int top() throws Exception {
		if (!isEmpty())
			return StackLL.getHead().getData();
		else
			throw new Exception("Stack is empty");
	}

	public int pop() throws Exception {
		if (!isEmpty()) {
			SLL_LinkNode temp = StackLL.getHead();
			StackLL.delete(0);
			temp.setNext(null);
			this.top--;
			return temp.getData();
		} else
			throw new Exception("Stack is empty");
	}

	public void push(int item) throws Exception {
		this.StackLL.add(item,0);
		this.top++;
	}

	public int size() {
		return this.top;
	}

	public boolean isEmpty() {
		if (this.top == 0)
			return true;
		else
			return false;
	}
	
	public void display() {
		System.out.println("");
		this.StackLL.display();
		System.out.println("");
	}
}
