package Implementation;

public class CLL_List {
	private int length;
	CLL_LinkNode headNode;

	// Constructor
	public CLL_List() {
		this.length = 0;
		this.headNode = new CLL_LinkNode();
	}

	// get length
	public int getLength() {
		return this.length;
	}

	// display list
	public void display() {
		CLL_LinkNode temp_node = this.headNode;
		do {
			System.out.print(temp_node.getData() + " ");
			temp_node = temp_node.getNext();
		} while (temp_node != this.headNode);
	}

	// add a node in the end
	public void addAtEnd(int item) {
		// pre: a head node is created; length doesn't matter
		// post: node added in the end; length increased
		CLL_LinkNode new_node = new CLL_LinkNode(item);
		if (this.length == 0) {
			this.headNode = new_node;
			this.headNode.setNext(this.headNode);
		} else {
			CLL_LinkNode temp_node = this.headNode;
			while (temp_node.getNext() != this.headNode)
				temp_node = temp_node.getNext();
			temp_node.setNext(new_node);
			new_node.setNext(headNode);
		}
		this.length++;
	}

	public void addAtStart(int item) {
		// pre: a head node is created; length doesn't matter
		// post: node added in the start; length increased
		CLL_LinkNode new_node = new CLL_LinkNode(item);
		if (this.length == 0) {
			this.headNode = new_node;
			this.headNode.setNext(this.headNode);
		} else {
			CLL_LinkNode temp_node = this.headNode;
			while (temp_node.getNext() != this.headNode)
				temp_node = temp_node.getNext();
			temp_node.setNext(new_node);
			new_node.setNext(headNode);
			this.headNode = new_node;
		}
		this.length++;
	}

	// 1 2 3 4 5 null
	// add a node in a given position
	public void add(int item, int position) {
		// pre: position to be in the range
		// post: 'item' to be present in the 'position'th place
		if (position >= this.length)
			this.addAtEnd(item);
		else {
			CLL_LinkNode new_node = new CLL_LinkNode(item);
			if (position <= 1) {
				this.addAtStart(item);
			} else {
				CLL_LinkNode temp_node = this.headNode;
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
			CLL_LinkNode temp_node = this.headNode ;
			for (int i = 1; i < this.length-1; i++) {
				temp_node = temp_node.getNext();
			}
			temp_node.getNext().setNext(null);
			temp_node.setNext(this.headNode);
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
			CLL_LinkNode temp_node = this.headNode;
			if (position <= 1) {
				for (int i = 1; i < this.length; i++)
					temp_node = temp_node.getNext();
				temp_node.setNext(this.headNode.getNext());
				this.headNode.setNext(null);
				this.headNode = temp_node.getNext();
			} else {
				for (int i = 1; i < position - 1; i++)
					temp_node = temp_node.getNext();
				CLL_LinkNode del_node = temp_node.getNext();
				temp_node.setNext(del_node.getNext());
				del_node.setNext(null);
			}
			this.length--;
		}
	}
}
