package LinckedListV2;

public class Node {
	private Node next;
	private Node prev;
	private Object value;
	
	public Node(Node next, Node prev, Object value)
	{
		this.next= next;
		this.prev = prev;
		this.value = value;
	}
	
	public Node getNext()
	{
         return next;		
	}
	
	public Node getPrev()
	{
		return prev;
	}
	
	public Object getValue()
	{
		return value;
	}
	
	public void setNext(Node next)
	{
		this.next = next;
	}
	
	public void setPrev(Node prev)
	{
		this.prev = prev;
	}
	
	public void setValue(Object value)
	{
		this.value = value;
	}
}
