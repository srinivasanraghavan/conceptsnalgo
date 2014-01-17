package com.insanelygreat;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.insanelygreat.TreeAlgo.BinarySearchTree;

public class TreeAlgoTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void insertIntoTree() {

		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
		binarySearchTree.insert(10);
		binarySearchTree.insert(30);
		binarySearchTree.insert(20);
		binarySearchTree.insert(50);
		binarySearchTree.insert(60);
		binarySearchTree.insert(15);
		binarySearchTree.insert(12);

		// binarySearchTree.mirrorTree();
		// binarySearchTree.printTree();
		List<Integer> preOrderList= binarySearchTree.postorderArray();
		List<Integer> inOrderList= binarySearchTree.inorderArray();
		Integer[] preOrderarray =new Integer[preOrderList.size()];
		Integer[] inOrderarray=new Integer[preOrderList.size()];
		
		preOrderarray =preOrderList.toArray(preOrderarray);
		inOrderarray =inOrderList.toArray(inOrderarray);

		
		System.out.println("Inorder"  + inOrderarray);
		System.out.println("PreOrder"  + preOrderarray);
		
		binarySearchTree.reconstructTree(inOrderarray,preOrderarray,0,(inOrderarray.length-1),0);
		binarySearchTree.printTree();
		binarySearchTree.inorderIterative();

	}
};
