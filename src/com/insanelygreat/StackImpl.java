package com.insanelygreat;

public class StackImpl<T> implements Stack<T> {
	List<T> list;

	public StackImpl(List<T> list) {

		this.list = list;
	}

	public StackImpl() {

		this.list = new SinglyLinkedList<>();
	}

	@Override
	public T pop() {
		if(!isEmpty())
		return list.removeFirst();
		return null;
	}

	@Override
	public T peek() {

		return list.peekFirst();
	}

	@Override
	public void push(T data) {
		
		list.addFirst(data);

	}
 
	@Override
	public boolean isEmpty() {

		if (list.size() <= 0)
			return true;
		else {
			return false;
		}
	}

	@Override
	public String toString() {
		return list.toString();
	}
	
	

}
