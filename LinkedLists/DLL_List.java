package Implementation;

public class DLL_List {
	private int length;
	DLL_LinkNode headNode;

	// Constructor
	public DLL_List() {
		this.length = 0;
		this.headNode = new DLL_LinkNode();
	}

	// get length
	public int getLength() {
		return this.length;
	}

	// display list
	public void display() {
		DLL_LinkNode temp_node = this.headNode;
		System.out.println("From the start:");
		for (int i = 0; i < this.length; i++) {
			System.out.print(temp_node.getData() + " ");
			if(temp_node.getNext()!=null) 
			temp_node = temp_node.getNext();
		}
		System.out.println("\nFrom the end:");
		for (int i = 0; i < this.length; i++) {
			System.out.print(temp_node.getData() + " ");
			temp_node = temp_node.getPrev();
		}
	}

	// add a node in the end
	public void add(int item) {
		// pre: a head node is created; length doesn't matter
		// post: node added in the end; length increased
		DLL_LinkNode new_node = new DLL_LinkNode(item);
		if (this.length == 0)
			this.headNode = new_node;
		else {
			DLL_LinkNode temp_node = this.headNode;
			while (temp_node.getNext() != null)
				temp_node = temp_node.getNext();
			temp_node.setNext(new_node);
			new_node.setPrev(temp_node);
		}
		this.length++;
	}

	// 1 2 3 4 5 null
	// add a node in a given position
	public void add(int item, int position) {
		// pre: position to be in the range
		// post: 'item' to be present in the 'position'th place
		if (position >= this.length)
			this.add(item);
		else {
			DLL_LinkNode new_node = new DLL_LinkNode(item);
			if (position <= 1) {
				new_node.setNext(this.headNode);
				headNode.setPrev(new_node);
				this.headNode = new_node;
			} else {
				DLL_LinkNode temp_node = this.headNode;
				for (int i = 1; i < position - 1; i++)
					temp_node = temp_node.getNext();
				new_node.setNext(temp_node.getNext());
				temp_node.setNext(new_node);
				new_node.setPrev(temp_node);
				new_node.getNext().setPrev(new_node);
			}
			this.length++;
		}
	}

	// deleting a node at the end
	public void delete() {
		// pre: length>0
		// post: delete one node from the end; reduce length
		if (this.length > 0) {
			DLL_LinkNode temp_node = this.headNode;
			for (int i = 1; i < this.length; i++)
				temp_node = temp_node.getNext();
			temp_node.getPrev().setNext(null);
			temp_node.setPrev(null);
			temp_node.setNext(null);
			this.length--;
		}
	}

	// deleting at a given position
	public void delete(int position) {
		// pre: position to be in the range
		// post: list[position] should be deleted; 'list[position+1]'+1 to be
		// present in the 'position'th place
		if (position >= this.length)
			this.delete();
		else {
			DLL_LinkNode temp_node = this.headNode;
			if (position <= 1) {
				this.headNode = temp_node.getNext();
				temp_node.setNext(null);
				this.headNode.setPrev(null);
			} else {
				for (int i = 1; i < position - 1; i++)
					temp_node = temp_node.getNext();
				DLL_LinkNode del_node = temp_node.getNext();
				temp_node.setNext(del_node.getNext());
				del_node.setNext(null);
				del_node.setPrev(null);
				temp_node.getNext().setPrev(temp_node);
			}
			this.length --;
		}
	}
}
