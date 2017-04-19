package Implementation;

public class CLL_LinkNode {
//Declaring elements for Singly-LL Link node	
	private int data;
	private CLL_LinkNode next;

//Constructors
	public CLL_LinkNode(int item){
		this.setData(item);
		this.setNext(this);
	}
	public CLL_LinkNode(){
		this.setNext(this);
	}
	
//Methods to set data and next pointer
	public void setData(int item){
		this.data = item;
	}
	public void setNext(CLL_LinkNode ptr){
		this.next = ptr;
	}
	
//Methods to return data and next pointer for this object
	public int getData(){
		return this.data;
	}
	public CLL_LinkNode getNext(){
		return this.next;
	}
}
