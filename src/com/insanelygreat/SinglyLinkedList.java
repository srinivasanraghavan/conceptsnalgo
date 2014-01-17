package com.insanelygreat;

public class SinglyLinkedList<T> implements List<T> {
	static public class SingleNode<T> {

		T data;

		SingleNode<T> nextNode;

		public SingleNode(T data, SingleNode<T> nextNode) {
			super();
			this.data = data;
			this.nextNode = nextNode;
		}

		@Override
		public String toString() {
			return "SingleNode [data=" + data + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((data == null) ? 0 : data.hashCode());
			result = prime * result
					+ ((nextNode == null) ? 0 : nextNode.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			SingleNode other = (SingleNode) obj;
			if (data == null) {
				if (other.data != null)
					return false;
			} else if (!data.equals(other.data))
				return false;
			if (nextNode == null) {
				if (other.nextNode != null)
					return false;
			} else if (!nextNode.equals(other.nextNode))
				return false;
			return true;
		}

	}

	SingleNode<T> head;

	int size;

	public void addFirst(T data) {

		linkFirst(data);
	}

	public void addLast(T data) {
		linkLast(data);

	}

	public void addAfter(T data, int pos) {
		linkAfter(data, node(pos));

	}

	private void linkAfter(T data, SingleNode<T> node) {

		SingleNode<T> nextNode = node.nextNode;

		SingleNode<T> newNode = new SingleNode<>(data, nextNode);

		newNode.nextNode = newNode;

	}

	public void reverse() {
		SingleNode<T> prev = null;
		SingleNode<T> current = head;
		SingleNode<T> next = null;

		while (head != null) {

			next = current.nextNode;
			current.nextNode = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}

	public void reverseRecusively() {
		reverseRecursively(head);
	}

	public void reverseRecursively(SingleNode<T> head) {

		SingleNode<T> first;

		SingleNode<T> rest;

		if (head == null) {
			return;
		}
		first = head;
		rest = first.nextNode;

		if (rest == null) {
			return;
		}
		reverseRecursively(rest);

		first.nextNode.nextNode = first;

		first.nextNode = null;
		head = rest;

	}

	private void linkFirst(T data) {

		SingleNode<T> f = head;

		SingleNode<T> node = new SingleNode<>(data, f);

		head = node;
		size++;

	}

	public void removeDuplicates() {

		if (head == null) {
			return;
		}

		SingleNode<T> prev = head;
		SingleNode<T> current = head.nextNode;

		while (current != null) {
			SingleNode<T> runner = head;
			while (runner != current) {
				if (runner.data == current.data) {
					SingleNode<T> tmp = current.nextNode;
					prev.nextNode = tmp;
					current = tmp;
					break;
				}
				runner = runner.nextNode;

			}
			if (runner == current) {
				prev = current;
				current = current.nextNode;

			}

		}

	}

	public SingleNode<T> detectLoop() {

		SingleNode<T> node1 = head;
		SingleNode<T> node2 = head;
		while (node2.nextNode != null) {

			node1 = node1.nextNode;
			node2 = node2.nextNode.nextNode;
			if (node1 == node2) {
				break;
			}
		}
		if (node2.nextNode == null) {
			return null;
		}
		node1 = head;

		while (node1 != node2) {
			node1 = node1.nextNode;
			node2 = node2.nextNode;
		}
		return node2;

	}

	public SingleNode<T> nthToLast(int n) {

		if (head == null && n < 1) {
			return null;
		}

		SingleNode<T> p1 = head;
		SingleNode<T> p2 = head;

		for (int i = 0; i < n - 1; i++) {

			if (p1 == null) {
				return null;
			}
			p1 = p1.nextNode;

		}


		while (p1.nextNode != null) {
			p1 = p1.nextNode;
			p2 = p2.nextNode;
		}
		return p2;

	}

	private SingleNode<T> node(int pos) {

		SingleNode<T> x = head;
		for (int i = 0; i < pos; i++)
			x = x.nextNode;
		return x;

	}

	private void linkLast(T data) {

		SingleNode<T> node = head;

		while (node.nextNode != null) {

			node = node.nextNode;

			System.out.println(node);
		}

		SingleNode<T> newnode = new SingleNode<>(data, null);

		node.nextNode = newnode;
		size++;

	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		for (SingleNode<T> node = head; node != null; node = node.nextNode) {

			builder.append(node.toString());
		}
		return builder.toString();
	}

	@Override
	public T removeFirst() {
		if (head != null) {
			T data = head.data;
			head = head.nextNode;
			size--;
			return data;
		}
		return null;

	}

	@Override
	public T peekFirst() {
		return head.data;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public T removeLast() {
		if (head != null) {
			SingleNode<T> runner = head;
			while (runner.nextNode.nextNode != null) {
				runner = runner.nextNode;
			}
			T data = runner.nextNode.data;

			runner.nextNode = null;
			size--;
			return data;
		}
		return null;

	}
}
