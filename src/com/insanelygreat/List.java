package com.insanelygreat;

public interface List<T> {

	public void addFirst(T data);

	public void addLast(T data);

	public void addAfter(T data, int pos);
	
	public T removeFirst();
	
	public T removeLast();
	
	public T peekFirst();
	
	public int size();
}
