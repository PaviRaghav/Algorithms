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

}
