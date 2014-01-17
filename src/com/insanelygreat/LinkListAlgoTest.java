package com.insanelygreat;

import org.junit.Before;
import org.junit.Test;

public class LinkListAlgoTest {
	
	transient int hashSeed = 0;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {

		 SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
		
		 linkedList.addFirst(4);
		 linkedList.addFirst(3);
		 linkedList.addFirst(2);
		 linkedList.addFirst(1);
		
		
		 System.out.println(linkedList.toString());
		 linkedList.reverseRecusively();
		 
		 System.out.println(linkedList.toString());
		// // linkedList.removeDuplicates();
		// System.out.println(linkedList.toString());
//		int val = 1 << 16;
//		System.out.println(Integer.toBinaryString(val));
//		System.out.println(val);
//
//		int sshift = 0;
//
//		int ssize = 1;
//		while (ssize < val) {
//			++sshift;
//			ssize <<= 1;
//		}
//
//		int segmentShift = 32 - sshift;
//		int segmentMask = ssize - 1;
//		System.out.println(segmentShift);
//
//		int hash = "srini".hashCode();
//		
//		int realHash = hash(hash);
//		System.out.println("realHash"+realHash);
//		int hash1 = "srinii".hashCode();
//		int j = (hash >>> segmentShift) & segmentMask;
//		int k= (hash1 >>> segmentShift) & segmentMask;
//		System.out.println("Index is" +(realHash & 10));
//		System.out.println(Integer.toBinaryString(j));
//		 int MAXIMUM_CAPACITY = 1 << 30;
//		 
//		 System.out.println("MAXIMUM_CAPACITY"+ MAXIMUM_CAPACITY);
//	
//		 System.out.println(hash);
//		System.out.println(segmentMask);

	}
	
	 static int indexFor(int h, int length) {
	        // assert Integer.bitCount(length) == 1 : "length must be a non-zero power of 2";
	        return h & (length-1);
	    }
	
	 private int hash(Object k) {
	        int h = hashSeed;

	       
	        h ^= k.hashCode();

	        // Spread bits to regularize both segment and index locations,
	        // using variant of single-word Wang/Jenkins hash.
	        h += (h <<  15) ^ 0xffffcd7d;
	        h ^= (h >>> 10);
	        h += (h <<   3);
	        h ^= (h >>>  6);
	        h += (h <<   2) + (h << 14);
	        return h ^ (h >>> 16);
	    }

}
