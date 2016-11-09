package LinckedListV2;

public class LinkedListV2<E> {
	private int size;
	private Node<E> firstEl;
	private Node<E> lastEl;
	private final static int DEFAULTSIZE = 0;

	public LinkedListV2() {
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

	public boolean remove(E value) {
		Node<E> currentNode = firstEl;
		if (!this.isEmpty()) {
			if (firstEl.getValue().equals(value)) {
				if (firstEl.getNext() == null) {
					firstEl = null;
					lastEl = null;
					size--;
					return true;
				} else {
					firstEl.getNext().setPrev(null);
					firstEl = firstEl.getNext();
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
						currentNode.getNext().setPrev(currentNode.getPrev());
						currentNode.getPrev().setNext(currentNode.getNext());
						size--;
						return true;
					}

					currentNode = currentNode.getNext();
				}
			}

		}

		return false;
	}

	/**
	 * 
	 * @param value
	 *            - E value
	 * @return index of element. If element not found return -1
	 */

	public int getIndex(E value) {
		Node<E> currentNode = firstEl;
		int index = 0;
		if (!this.isEmpty()) {
			if (firstEl.getNext() == null) {
				if (firstEl.getValue().equals(value))
					return 0;
			} else if (lastEl.getValue().equals(value))
				return size - 1;
			else {
				while (currentNode.getNext() != null) {
					if (currentNode.getValue().equals(value)) {
						return index;
					} else {
						currentNode = currentNode.getNext();
						index++;
					}
				}
			}
		}
		return -1;
	}

	public Node<E> getFirst() {
		return firstEl;
	}

	public Node<E> getLast() {
		return lastEl;
	}

	public boolean isEmpty() {
		if (firstEl == null)
			return true;
		else
			return false;
	}

	public int size() {
		return size;
	}
}
