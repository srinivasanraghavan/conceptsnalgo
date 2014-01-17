package com.insanelygreat;

import java.util.Deque;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

public class TreeAlgo {

	static public class TreeNode<T> {

		T data;
		TreeNode<T> left;
		TreeNode<T> right;

		public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}

	}

	static public class BinarySearchTree<T> {

		TreeNode<T> root;

		public void insert(T data) {

			root = insertRescurisve(root, data);
		}

		private TreeNode<T> insertRescurisve(TreeNode<T> node, T data) {
			if (node == null) {
				node = new TreeNode<>(data, null, null);
				return node;
			}

			Comparable<T> comparator = (Comparable<T>) data;

			int cmp = comparator.compareTo(node.data);
			if (cmp < 0) {

				node.left = insertRescurisve(node.left, data);
			}

			else if (cmp > 0) {

				node.right = insertRescurisve(node.right, data);
			}

			return node;
		}

		public void printTree() {
			printInorder(root);
		}

		public int size() {
			return calculateSize(root);
		}

		/**
		 * Read the post oreder array
		 * 
		 * Seach for the inorder item in the array and attach the left the and
		 * right to the node
		 */
		public TreeNode<T> reconstructTree(T[] inorderArray, T[] preorderArray,
				int startIndex, int endindex, int preorderIndex) {

			if (startIndex > endindex)
				return null;

			TreeNode<T> node = new TreeNode<T>(preorderArray[preorderIndex],
					null, null);
			preorderIndex++;
			if (startIndex == endindex)
				return node;

			int inIndex = search(inorderArray, startIndex, endindex, node.data);

			node.left = reconstructTree(inorderArray, preorderArray,
					startIndex, inIndex - 1, preorderIndex);
			node.right = reconstructTree(inorderArray, preorderArray,
					inIndex + 1, endindex, preorderIndex);
			return node;

		}

		private int search(T[] inorderArray, int startIndex, int index, T value) {
			for (int i = startIndex; i <= index; i++) {
				if (inorderArray[i].equals(value)) {
					return i;
				}
			}
			return index;

		}

		public void inorderIterative() {

			iterativeInorder(root);
		}

		public T findCeilingValue(TreeNode<T> node, T input) {

			if (node == null) {
				return null;
			}

			if (node.data.equals(input)) {
				return node.data;
			}
			Comparable<T> comparator = (Comparable<T>) input;
			int cmp = comparator.compareTo(node.data);
			if (cmp < 1) {
				return findCeilingValue(node.right, input);

			}
			T ceil = findCeilingValue(node.left, input);
			int ceilCmp = comparator.compareTo(ceil);
			if (ceilCmp >= 0) {
				return ceil;
			} else {
				return root.data;
			}

		}

		private void iterativeInorder(TreeNode<T> node) {
			com.insanelygreat.Stack<TreeNode<T>> stack = new StackImpl<>();
			while (!stack.isEmpty() || node != null) {
				if (node != null) {
					stack.push(node);
					node = node.left;
				} else {
					node = stack.pop();
					System.out.println(node.data);
					node = node.right;
				}

			}

		}

		private void iterativePreOrder(TreeNode<T> node) {
			com.insanelygreat.Stack<TreeNode<T>> stack = new StackImpl<>();
			while (!stack.isEmpty() || node != null) {
				if (node != null) {
					System.out.println(node.data);
					stack.push(node);
					node = node.left;
				} else {
					node = stack.pop();
					node = node.right;
				}

			}

		}

		/**
		 * 
		 * @param node
		 */

		private void calculateFrequency(TreeNode<T> node) {

			/**
			 * Punch in the digits .. Use an Preorder Traveresal
			 */

			int digitsArr[] = new int[10];

			int val = (Integer) node.data;

			do {
				digitsArr[val % 10]++;
				val /= 10;
			} while (val != 0);

			calculateFrequency(node.left);
			calculateFrequency(node.right);
		}

		private int calculateSize(TreeNode<T> treeNode) {

			if (treeNode == null) {
				return 0;
			} else {
				return calculateSize(treeNode.left) + 1
						+ calculateSize(treeNode.right);
			}

		}

		// private void interativeInsert(TreeNode<T> treeNode) {
		//
		// if(root == null) {
		//
		// }
		// }

		private void iterativeInsert(TreeNode<T> treeNode) {

		}

		public void mirrorTree() {

			mirrorTree(root);
		}

		private void mirrorTree(TreeNode<T> node) {
			if (node == null) {
				return;
			}

			TreeNode<T> tmpNode;

			mirrorTree(node.left);
			mirrorTree(node.right);

			tmpNode = node.left;
			node.left = node.right;
			node.right = tmpNode;
		}

		private void printInorder(TreeNode<T> node) {

			if (node != null) {
				printInorder(node.left);
				System.out.print("  " + node.data);
				printInorder(node.right);
			}

		}

		public List<T> inorderArray() {
			List<T> list = new ArrayList<>();
			inorderArray(root, list);
			return list;
		}

		private void inorderArray(TreeNode<T> node, List<T> list) {

			if (node != null) {
				inorderArray(node.left, list);
				list.add(node.data);
				inorderArray(node.right, list);
			}

		}

		public List<T> postorderArray() {
			List<T> list = new ArrayList<>();
			postorderArray(root, list);
			return list;
		}

		private void postorderArray(TreeNode<T> node, List<T> list) {

			if (node != null) {
				postorderArray(node.left, list);
				postorderArray(node.right, list);
				System.out.println(node.data);
				list.add(node.data);
			}

		}

		private void preorderArray(TreeNode<T> node, List<T> list) {

			if (node != null) {
				list.add(node.data);
				preorderArray(node.left, list);
				System.out.print("  " + node.data);
				preorderArray(node.right, list);
			}

		}

	}

}
