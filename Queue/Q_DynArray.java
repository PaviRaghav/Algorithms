package Implementation;

/**
 * implementation of queue using dynamic array without using size variable
 * 
 * @author pavithraraghavan
 *
 */
public class Q_DynArray<E> {
	private int front, rear;
	private int capacity;
	private E[] Q;

	public Q_DynArray() {
		capacity = 2;
		Q = (E[]) new Object[capacity];
		front = 0;
		rear = 0;
	}

	private E[] double_size() {
		capacity = capacity * 2;
		E[] new_Q = (E[]) new Object[capacity];
		for (int i = (front) % capacity; i <= rear; i++)
			new_Q[i] = Q[i];
		return new_Q;
	}

	private E[] half_size() {
		capacity = capacity / 2;
		E[] new_Q = (E[]) new Object[capacity];
		for (int i = (front) % capacity; i < rear; i++)
			new_Q[i] = Q[i];
		return new_Q;
	}

	public boolean isFull() {
		return ((rear + 1) % capacity == front);
	}

	public boolean isEmpty() {
		return (front == rear);
	}

	public void Enqueue(E data) {
		if (isFull())
			Q = double_size();
		Q[rear] = data;
		rear = (rear + 1) % capacity;

	}

	public E Dequeue() {
		if (!isEmpty()) {
			E i = Q[front % capacity];
			Q[front % capacity] = null;

			if (rear + 1 == capacity / 2)
				Q = half_size();
			front = (front + 1) % capacity;
			return i;
		} else
			throw new IllegalStateException("Queue is empty: underflow");
	}

	public E peek() {
		if (!isEmpty())
			return Q[front % capacity];
		else
			throw new IllegalStateException("Queue is empty: underflow");
	}

	public String toString() {
		String s = "";
		for (int i = (front) % capacity; i < rear; i++)
			s = s + Q[i] + " ";
		return s;
	}
}