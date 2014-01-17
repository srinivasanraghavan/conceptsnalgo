package com.insanelygreat;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackTest {

	@Test
	public void test() {
		Stack<Integer> stack = new StackImpl<>();
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);

		StackApiAlgo apiAlgo = new StackApiAlgo();
		System.out.println(stack.toString());
		apiAlgo.reverseStack(stack);

		System.out.println("After Reverse ");
		System.out.println(stack.toString());

	}

}
