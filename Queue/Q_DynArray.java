package Implementation;

/**
 * implementation of queue using dynamic array without using size variable
 * 
 * @author pavithraraghavan
 *
 */
public class Q_DynArray {
	private int front, rear;
	private int capacity;
	private int[] Q;

	public Q_DynArray() {
		capacity = 2;
		Q = new int[capacity];
		front = 0;
		rear = 0;
	}

	private int[] double_size() {
		capacity = capacity * 2;
		int[] new_Q = new int[capacity];
		for (int i = (front + 1) % capacity; i <= rear; i++)
			new_Q[i] = Q[i];
		return new_Q;
	}

	private int[] half_size() {
		capacity = capacity / 2;
		int[] new_Q = new int[capacity];
		for (int i = (front + 1) % capacity; i <= rear - 1; i++)
			new_Q[i] = Q[i];
		return new_Q;
	}

	public boolean isFull() {
		return ((rear + 1) % capacity == front);
	}

	public boolean isEmpty() {
		return (front == rear);
	}

	public void Enqueue(int data) {
		if (isFull())
			Q = double_size();
		rear = (rear + 1) % capacity;
		Q[rear] = data;

	}

	public int Dequeue() {
		if (!isEmpty()) {
			int i = Q[front];
			Q[front] = Integer.MIN_VALUE;
			front = (front + 1) % capacity;
			if (rear + 1 == capacity / 2)
				Q = half_size();
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