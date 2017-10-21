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
		heapify(A);
	}

	public void heapify(int[] A) {
		//given an array, construct a heap
		int i = A.length-1;
		while (i > 0 && i > (A.length - 1) / 2) {
			percolateDown(i);
			i--;
		}
	}

	private void percolateDown(int i) {
		// given an index i, maintain the heap property by moving that element
		int max = (this.heap[i] > this.heap[i - 1]) ? i : i - 1;
		if (this.heap[max] > this.heap[(i - 1) / 2]) {
			int temp = this.heap[max];
			this.heap[max] = this.heap[(i - 1) / 2];
			this.heap[(i - 1) / 2] = temp;
			percolateDown((i - 1) / 2);
		}
	}
}
