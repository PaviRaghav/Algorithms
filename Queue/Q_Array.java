package Implementation;

/**
 * implementation of queue without using size variable
 * 
 * @author pavithraraghavan
 *
 */

public class Q_Array {
	private int front, rear;
	private int capacity = 16;
	private int[] Q;

	public Q_Array() {
		Q = new int[capacity];
		front = 0;
		rear = 0;
	}

	public Q_Array(int size) {
		capacity = size + 1;
		Q = new int[capacity];
		front = 0;
		rear = 0;
	}

	public boolean isFull() {
		return ((rear + 1) % capacity == front);
	}

	public boolean isEmpty() {
		return (front == rear);
	}

	public void Enqueue(int data) {
		if (!isFull()) {
			rear = (rear + 1) % capacity;
			Q[rear] = data;
		} else
			throw new IllegalStateException("Stack is alredy full: overflow");
	}

	public int Dequeue() {
		if (!isEmpty()) {
			int i = Q[front];
			Q[front] = Integer.MIN_VALUE;
			front = (front + 1) % capacity;
			return i;
		} else
			throw new IllegalStateException("Stack is empty: underflow");
	}

	public int peek() {
		if (!isEmpty())
			return Q[front];
		else
			throw new IllegalStateException("Stack is empty: underflow");
	}

	public String toString() {
		String s = "";
		for (int i = (front + 1) % capacity; i <= rear; i++)
			s = s + Q[(front + i) % capacity] + " ";
		return s;
	}
}
