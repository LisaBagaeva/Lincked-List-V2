package LinckedListV2;

public class LinckedListV2<E> {
	private int size;
	private Node<E> firstEl;
	private Node<E> lastEl;
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
					currentNode.getNext().setPrev(currentNode.getPrev());
					firstEl = currentNode.getNext();
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

		return true;
	}

	public Node<E> getFirst() {
		return firstEl;
	}

	public Node<E> getFLast() {
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
