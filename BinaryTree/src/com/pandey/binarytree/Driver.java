package com.pandey.binarytree;

/**
 * This class is a driver class which is use to run any operation in binary tree
 * 
 * COPYRIGHTS : Use as per your convenience
 * 
 * @author Deepak Pandey
 *
 */
public class Driver {
	public static void main(String[] args) {
		BinaryTreeOperations service = BinaryTreeOperations.getInstance();
		service.printVerticalOrderTraversal(BinaryTreeUtils.getStaticBST());
	}
}
