package com.insanelygreat.arrays;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArrayListAlgoTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIsHavingDuplicates() {

		System.out.println(ArrayListAlgo.isHavingDuplicates("srinn"));
		;
	}

	@Test
	public void testremoveDuplictatesWithBuffer() {

		System.out.println(ArrayListAlgo.removeDuplictatesWithBuffer("sriiiiiiinini"));
	}

	@Test
	public void checkPailndrome(){
//		System.out.println(ArrayListAlgo.checkPalindrome("malayanam"));
//		System.out.println(ArrayListAlgo.checkPalindrome("gumtha"));
		ArrayListAlgo.palindromes("malayalam is funny".toCharArray());
	}
}
