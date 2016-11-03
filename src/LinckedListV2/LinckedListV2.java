package LinckedListV2;

import java.util.Collection;
import java.util.Iterator;

public class LinckedListV2 <E> implements Collection<E> {
	private int size;
	private Node <E> firstEl;
	private Node <E> lastEl;
	private final static int DEFAULTSIZE = 0;

	public LinckedListV2() {
		this.size = DEFAULTSIZE;
		this.firstEl = null;
		this.lastEl = null;
	}

	public boolean add(E value) {
		Node<E> newNode = null;
		if (this.isEmpty()) {
			newNode = new Node<E>(null, null, value);
			firstEl = newNode;
			lastEl = firstEl;
		} else {

			newNode = new Node<E>(null, lastEl, value);
			lastEl.setNext(newNode);
			lastEl = newNode;
		}

		size++;
		return true;
	}

	public  LinckedListV2<E> removeElement(E value) {
		Node<E> currentNode = firstEl;
		if (!this.isEmpty()) {
			if (firstEl.getValue().equals(value)) {
				if (firstEl.getNext() == null) {
					firstEl = null;
					lastEl = null;
					size--;
					return this;
				}
				else {
					currentNode.getNext().setPrev(currentNode.getPrev());
					firstEl = currentNode.getNext();
					size--;
				return this;
			}
			}

			else if (lastEl.getValue().equals(value)) {
				lastEl = lastEl.getPrev();
				lastEl.setNext(null);
				size--;
				return this;
			} else {
				while (currentNode.getNext() != null) {
					if (currentNode.getValue().equals(value)) {
							currentNode.getNext().setPrev(currentNode.getPrev());
							currentNode.getPrev().setNext(currentNode.getNext());
						
						size--;
						return this;
					}
				
					currentNode = currentNode.getNext();
				}
			}

		}

		return this;
	}

	public Node<E> getFirst() {
		return firstEl;
	}

	public Node<E> getFLast() {
		return lastEl;
	}

	@Override
	public boolean isEmpty() {
		if (firstEl == null)
			return true;
		else
			return false;
	}

	@Override
	public int size() {

		return size;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
