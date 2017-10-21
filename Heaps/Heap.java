package Implementation;

//Implementation of heap using arrays
public class Heap {
	private int[] heap;
	private int maxCapacity, size;

	public Heap(int capacity) {
		this.maxCapacity = capacity;
		this.size = 0;
		this.heap = new int[this.maxCapacity];
	}

	public Heap(int[] A) {
		this.maxCapacity = A.length;
		this.heap = A;
		this.size = A.length;
		heapify();
	}

	public void heapify() {
		// given an array, construct a heap
		for (int i = (this.size - 1) / 2; i >= 0; i--)
			percolateDown(i);
	}

	private void percolateDown(int i) {
		// given an index i, maintain the heap property by moving that element
		int max;
		int l = this.getLeftChild(i), r = this.getRightChild(i);
		if (l != -1 && this.heap[i] < this.heap[l])
			max = l;
		else
			max = i;
		if (r != -1 && this.heap[r] > max)
			max = r;
		if (max != i) {
			int temp = this.heap[max];
			this.heap[max] = this.heap[i];
			this.heap[i] = temp;
			percolateDown(max);
		}
	}

	private int getLeftChild(int i) {
		int left = 2 * i + 1;
		if (left >= this.size)
			return -1;
		else
			return left;
	}

	private int getRightChild(int i) {
		int left = 2 * i + 2;
		if (left >= this.size)
			return -1;
		else
			return left;
	}

	public void insert(int data) {
		if (this.size == this.maxCapacity)
			this.doubleSize();
		int i = this.size;
		this.size++;
		while (i > 0 && data > this.heap[(i - 1) / 2]) {
			this.heap[i] = this.heap[(i - 1) / 2];
			i = (i - 1) / 2;
		}
		this.heap[i] = data;
	}

	private void doubleSize() {
		int[] A = new int[this.maxCapacity * 2];
		for (int i = 0; i < this.maxCapacity; i++)
			A[i] = this.heap[i];
		this.maxCapacity *= 2;
		this.heap = A;
		A = null;
	}
}
