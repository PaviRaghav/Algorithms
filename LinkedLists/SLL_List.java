package Implementation;

public class SLL_List {
	private int length;
	SLL_LinkNode headNode;

	// Constructor
	public SLL_List() {
		this.length = 0;
		this.headNode = new SLL_LinkNode();
	}

	// get length
	public int getLength() {
		return this.length;
	}

	// display list
	public void display() {
		SLL_LinkNode temp_node = this.headNode;
		for (int i = 0; i < this.length; i++) {
			System.out.print(temp_node.getData() + " ");
			temp_node = temp_node.getNext();
		}
	}

	// add a node in the end
	public void add(int item) {
		// pre: a head node is created; length doesn't matter
		// post: node added in the end; length increased
		SLL_LinkNode new_node = new SLL_LinkNode(item);
		if (this.length == 0)
			this.headNode = new_node;
		else {
			SLL_LinkNode temp_node = this.headNode;
			while (temp_node.getNext() != null)
				temp_node = temp_node.getNext();
			temp_node.setNext(new_node);
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
			SLL_LinkNode new_node = new SLL_LinkNode(item);
			if (position <= 1) {
				new_node.setNext(this.headNode);
				this.headNode = new_node;
			} else {
				SLL_LinkNode temp_node = this.headNode;
				for (int i = 1; i < position - 1; i++)
					temp_node = temp_node.getNext();
				new_node.setNext(temp_node.getNext());
				temp_node.setNext(new_node);
			}
			this.length++;
		}
	}

	// deleting a node at the end
	public void delete() {
		// pre: length>0
		// post: delete one node from the end; reduce length
		if (this.length > 0) {
			SLL_LinkNode temp_node = this.headNode;
			for (int i = 1; i < this.length; i++)
				temp_node = temp_node.getNext();
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
			SLL_LinkNode temp_node = new SLL_LinkNode();
			if (position <= 1) {
				temp_node = this.headNode;
				this.headNode = temp_node.getNext();
				temp_node.setNext(null);
			} else {
				for (int i = 1; i < position - 1; i++)
					temp_node = temp_node.getNext();
				SLL_LinkNode del_node = temp_node.getNext();
				temp_node.setNext(del_node.getNext());
				del_node.setNext(null);
			}
			this.length --;
		}
	}
}
