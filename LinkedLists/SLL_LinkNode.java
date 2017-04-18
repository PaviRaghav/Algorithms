package Implementation;

public class SLL_LinkNode {
//Declaring elements for Singly-LL Link node	
	private int data;
	private SLL_LinkNode next;

//Constructors
	public SLL_LinkNode(int item){
		this.setData(item);
		this.setNext(null);
	}
	public SLL_LinkNode(){
		this.setNext(null);
	}
	
//Methods to set data and next pointer
	public void setData(int item){
		this.data = item;
	}
	public void setNext(SLL_LinkNode ptr){
		this.next = ptr;
	}
	
//Methods to return data and next pointer for this object
	public int getData(){
		return this.data;
	}
	public SLL_LinkNode getNext(){
		return this.next;
	}
}
