package com.insanelygreat;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class RecursiveAlgoTest {

	@Test
	public void testconvertNumberToString() {
		RescuriveAlgos.convertNumberToString(100);
	}

	@Test
	public void testFibo() {
		RescuriveAlgos.F(7);
	}

	@Test
	public void testRover() {
		RescuriveAlgos.getPaths(5, 5);
	}

	@Test
	public void testSubSets() {
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		arrayList.add(5);
		arrayList.add(6);
		arrayList.add(7);

	System.out.println(	RescuriveAlgos.getSubsets2(arrayList));
	}

}
