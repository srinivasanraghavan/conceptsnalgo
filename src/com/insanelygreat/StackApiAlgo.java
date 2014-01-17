package com.insanelygreat;

public class StackApiAlgo {

	public void reverseStack(Stack<Integer> stack) {

		int m = (int) stack.pop();
		if (!stack.isEmpty())
			reverseStack(stack);
		insertAtBottom(stack, m);
	}

	private void insertAtBottom(Stack<Integer> stack, int item) {
		int temp;
		if (stack.isEmpty()) {
			stack.push(item);
		} else {
			temp = stack.pop();
			insertAtBottom(stack, item);	
			stack.push(temp);
		}
	}
}
