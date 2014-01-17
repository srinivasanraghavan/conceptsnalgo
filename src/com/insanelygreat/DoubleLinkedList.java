package com.insanelygreat;

public class DoubleLinkedList<T> implements List<T> {

	static public class DoubleNode<T> {

		T data;

		DoubleNode<T> nextNode;

		DoubleNode<T> prevNode;

		public DoubleNode(T data, DoubleNode<T> nextNode, DoubleNode<T> prevNode) {
			super();
			this.data = data;
			this.nextNode = nextNode;
			this.prevNode = prevNode;
		}

		@Override
		public String toString() {
			return " [data=" + data + "]";
		}

	}

	DoubleNode<T> first;

	DoubleNode<T> last;

	transient int size = 0;

	@Override
	public void addFirst(T data) {

		linkFirst(data);
	}

	private void linkFirst(T data) {

		DoubleNode<T> f = first;

		DoubleNode<T> node = new DoubleNode<>(data, f, null);
		first = node;
		if (f == null)
			last = node;
		else
			f.prevNode = first;
		size++;
	}

	@Override
	public void addLast(T data) {
		DoubleNode<T> l = last;

		DoubleNode<T> node = new DoubleNode<>(data, null, l);

		last = node;

		if (l == null)
			first = node;
		else
			l.nextNode = last;

		size++;
	}

	@Override
	public void addAfter(T data, int pos) {
		// To be implemented .

	}

	@Override
	public T removeFirst() {
		if (first != null) {

			DoubleNode<T> doubleNode = first;

			first = first.nextNode;
			if (first != null)
				first.prevNode = null;
			else
				last = null;

			size--;
			return doubleNode.data;
		}
		return null;
	}

	@Override
	public T peekFirst() {
		if(first!= null)
			return first.data;

		return null;
	}

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public T removeLast() {
		if (last != null) {

			DoubleNode<T> doubleNode = last;

			last = last.prevNode;
			if (last != null)
				last.nextNode = null;
			else
				first = null;

			size--;
			return doubleNode.data;
		}
		return null;
	}

}
