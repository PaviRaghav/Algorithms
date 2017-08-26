package Implementation;

/**
 * implementation of queue using dynamic array
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
		E[] new_Q = (E[]) new Object[capacity * 2];
		int i = front;
		while (i % capacity != rear) {
			new_Q[i - front] = Q[i % capacity];
			i++;
		}
		front = 0;
		rear = capacity-1;
		capacity = capacity * 2;
		return new_Q;
	}

	private E[] half_size() {
		capacity = capacity / 2;
		E[] new_Q = (E[]) new Object[capacity];
		for (int i = 0; i < capacity; i++)
			new_Q[i] = Q[i];
		return new_Q;
	}

	public boolean isFull() {
		return ((rear + 1) % capacity == front);
	}

	public boolean isEmpty() {
		return (rear == front);
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

			/*
			 * if (size -1 == capacity / 2 && size>2) Q = half_size();
			 */
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
		int i = front;
		while (i % capacity != rear) {
			s = s + Q[i] + " ";
			i++;
		}
		return s;
	}
	
	public static void main(String[] args) {
		Q_DynArray<Integer> q = new Q_DynArray<Integer>();
		q.Enqueue(1);
		q.Dequeue();
		q.Enqueue(2);
		q.Enqueue(3);
		q.Enqueue(4);
		System.out.println(q.toString());
		q.Dequeue();
		System.out.println(q.toString());
	}
}