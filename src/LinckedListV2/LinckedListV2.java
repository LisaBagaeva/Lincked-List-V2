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
		if (this.isEmpty()) {
			newNode = new Node(null, null, value);
			firstEl = newNode;
			lastEl = firstEl;
		} else {

			newNode = new Node(null, lastEl, value);
			lastEl.setNext(newNode);
			lastEl = newNode;
		}

		size++;
		return true;
	}

	@Override
	public boolean remove(Object value) {
		Node currentNode = firstEl;
		if (!this.isEmpty()) {
			if (firstEl.getValue().equals(value)) {
				if (firstEl.getNext() == null) {
					firstEl = null;
					lastEl = null;
					System.out.println("dfd");
					size--;
					return true;
				}
			}

			else if (lastEl.getValue().equals(value)) {
				lastEl = lastEl.getPrev();
				lastEl.setNext(null);
				size--;
				return true;
			} else {
				while (currentNode.getNext() != null) {
					if (currentNode.getValue().equals(value)) {
						if (currentNode.getPrev() == null) {
							currentNode.getNext().setPrev(null);
							System.out.println("dfd");
						}

						else {
							currentNode.getNext().setPrev(currentNode.getPrev());
							currentNode.getPrev().setNext(currentNode.getNext());
						}
						size--;
						return true;
					}
					currentNode = currentNode.getNext();
				}
			}

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
