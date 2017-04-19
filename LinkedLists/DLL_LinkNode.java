package Implementation;

public class DLL_LinkNode {
//Declaring elements for Singly-LL Link node	
	private int data;
	private DLL_LinkNode next;
	private DLL_LinkNode prev;
//Constructors
	public DLL_LinkNode(int item){
		this.setData(item);
		this.setNext(null);
		this.setPrev(null);
	}
	public DLL_LinkNode(){
		this.setNext(null);
		this.setPrev(null);
	}
	
//Methods to set data and next,prev pointers
	public void setData(int item){
		this.data = item;
	}
	public void setNext(DLL_LinkNode ptr){
		this.next = ptr;
	}
	public void setPrev(DLL_LinkNode ptr){
		this.prev = ptr;
	}
	
//Methods to return data and next,prev pointers for this object
	public int getData(){
		return this.data;
	}
	public DLL_LinkNode getNext(){
		return this.next;
	}
	public DLL_LinkNode getPrev(){
		return this.prev;
	}
}
