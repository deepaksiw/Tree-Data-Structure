package com.pandey.binarytree;

/**
 * This class represent node of binary tree
 * 
 * @author Deepak Pandey
 *
 */
public class Node {
	public int data;
	public Node left;
	public Node right;

	/**
	 * Public constructor for creating a node
	 * 
	 * @param data
	 *            : data for given node
	 */
	public Node(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "" + data;
	}
}
