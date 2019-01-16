package com.pandey.binarytree;

/**
 * This class is used as a utility class for binary class
 * 
 * COPYRIGHTS : Used as per your convenience
 * 
 * @author Deepak Pandey
 *
 */
public class BinaryTreeUtils {
	/**
	 * This method use to create a binary tree
	 * 
	 * @return: a static binary tree that can be used for testing
	 */
	public static Node getStaticBST() {
		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(2);
		root.left.left = new Node(10);
		root.left.right = new Node(0);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.right.right = new Node(4);
		return root;
	}
}
