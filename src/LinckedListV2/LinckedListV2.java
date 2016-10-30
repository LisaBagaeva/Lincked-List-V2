package LinckedListV2;

import java.util.Collection;
import java.util.Iterator;

public class LinckedListV2 implements Collection<Object> {
	private int size;
	private Node firstEl;
	private Node lastEl;
	private final static int DEFAULTSIZE = 0;

	public LinckedListV2() {
		this.size = DEFAULTSIZE;
		this.firstEl = null;
		this.lastEl = null;
	}

	@Override
	public boolean add(Object value) {
		Node newNode = null;
		if (firstEl == null) {
			newNode = new Node(null, null, value);
			lastEl = newNode;
			firstEl = lastEl;
		} else {
			newNode = new Node(null, lastEl, value);
			lastEl = newNode;
		}
		size++;
		return true;
	}

	@Override
	public boolean remove(Object value) {
		if (!this.isEmpty()) {
			if (firstEl == lastEl) {
				if (firstEl.getValue().equals(value)) {
					firstEl = null;
					lastEl = null;
				}
			} else {
				Node currentNode = firstEl;
				while (currentNode.getNext() != null) {
					if (currentNode.getValue().equals(value)) {
						currentNode.getNext().setPrev(currentNode.getPrev());
						currentNode.getPrev().setNext(currentNode.getNext());
						System.out.println("dfd");
					}
				}
			}
			size--;
			return true;
		}
		return false;
	}

	public Node getFirst() {
		return firstEl;
	}

	public Node getFLast() {
		return lastEl;
	}

	@Override
	public boolean addAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		if (firstEl == null)
			return true;
		else
			return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {

		return size;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
