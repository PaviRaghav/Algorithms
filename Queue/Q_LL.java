package Implementation;

/**
 * enqueue at rear and dequeue at front
 * 
 * @author pavithraraghavan
 *
 */
public class Q_LL {
	private SLL_LinkNode front, rear;

	public Q_LL() {
		front = null;
		rear = null;
	}

	public boolean isEmpty() {
		return (front == null);
	}

	public void enqueue(int data) {
		SLL_LinkNode node = new SLL_LinkNode(data);
		if (isEmpty()) {
			front = node;
			rear = node;
		} else {
			rear.setNext(node);
			rear = node;
		}
	}

	public int dequeue() {
		if (!isEmpty()) {
			SLL_LinkNode temp = front;
			front = front.getNext();
			temp.setNext(null);
			return temp.getData();
		} else
			throw new IllegalStateException("Queue is empty");
	}

	public String toString() {
		String s = "";
		SLL_LinkNode temp = front;
		while (temp != null) {
			s = s + temp.getData() + " ";
			temp = temp.getNext();
		}
		return s;
	}
}
