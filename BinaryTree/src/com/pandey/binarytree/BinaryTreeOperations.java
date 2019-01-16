package com.pandey.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * This java class has defines different operations on that can be performed on
 * binary tree (Description for all the operations has given in their respective
 * method)
 * 
 * COPYRIGHTS : Use as per your convenience
 * 
 * @author Deepak Pandey
 *
 */
public class BinaryTreeOperations {

	public static int left = 0;
	public static final Map<Integer, List<Node>> map = new TreeMap<>();

	/**
	 * Private constructor
	 */
	private BinaryTreeOperations() {
	}

	/**
	 * Inner class for creating a singleton
	 *
	 */
	private static class SingletonHolder {
		private static final BinaryTreeOperations INSTANCE = new BinaryTreeOperations();
	}

	/**
	 * Public method that will return singleton instance of this class
	 * 
	 * @return {@link BinaryTreeOperations}
	 */
	public static BinaryTreeOperations getInstance() {
		return SingletonHolder.INSTANCE;
	}

	/**
	 * Method for in-order traversal using recursion
	 * 
	 * @param root
	 *            : Root of binary tree
	 */
	public void inorderTraversal(Node root) {
		if (root != null) {
			inorderTraversal(root.left);
			System.out.print(root.data + " ");
			inorderTraversal(root.right);
		}
	}

	/**
	 * Method for pre-traversal using recursion
	 * 
	 * @param root
	 *            : root of binary tree
	 */
	public void preorderTraversal(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorderTraversal(root.left);
			preorderTraversal(root.right);
		}
	}

	/**
	 * Method for post-order traversal
	 * 
	 * @param root
	 *            : root of binary traversal
	 */
	public void postorderTraversal(Node root) {
		if (root != null) {
			postorderTraversal(root.left);
			postorderTraversal(root.right);
			System.out.print(root.data + " ");
		}
	}

	/**
	 * Method to print level order traversal starting from left to right
	 * 
	 * @param root
	 *            : root of binary tree
	 */
	public void levelOrderTraversalL2R(Node root) {
		Node node = root;
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			node = queue.poll();
			System.out.print(node.data + " ");
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
	}

	/**
	 * Method to print the level order traversal starting from right to left
	 * 
	 * @param root
	 *            : root of binary tree
	 */
	public void levelOrderTraversalR2L(Node root) {
		Node node = root;
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			node = queue.poll();
			System.out.print(node.data + " ");
			if (node.right != null) {
				queue.add(node.right);
			}
			if (node.left != null) {
				queue.add(node.left);
			}
		}
	}

	/**
	 * Method to print all the element present on given level
	 * 
	 * @param root
	 *            : root of binary tree
	 * @param level
	 *            : level at which all element has to be printed
	 */
	public void levelOrderTraversalForGivenLavel(Node root, int level) {
		if (root != null) {
			if (level == 1) {
				System.out.print(root.data + " ");
			}
			levelOrderTraversalForGivenLavel(root.left, level - 1);
			levelOrderTraversalForGivenLavel(root.right, level - 1);
		}
	}

	/**
	 * Method to print the first element at a given level from left
	 * 
	 * @param root
	 *            : root of binary tree
	 * @param level
	 *            : level at which first element has to be printed
	 */
	public void firstNodeForGivenLevelFormLeft(Node root, int level) {

		if (root != null) {
			if (level > left) {
				System.out.println(root.data + " ");
				left++;
			}
			firstNodeForGivenLevelFormLeft(root.left, level + 1);
			firstNodeForGivenLevelFormLeft(root.right, level + 1);
		}
	}

	/**
	 * Method to print the first element at given level from right
	 * 
	 * @param root
	 *            :root of binary tree
	 * @param level
	 *            :level at which first element has to be printed
	 */
	public void firstNodeForGivenLevelFormRight(Node root, int level) {
		if (root != null) {
			if (level > left) {
				System.out.println(root.data + " ");
				left++;
			}
			firstNodeForGivenLevelFormRight(root.right, level + 1);
			firstNodeForGivenLevelFormRight(root.left, level + 1);
		}
	}

	/**
	 * This method will update the map in parameter which will contain
	 * horizontal distance from root node as key and list of node at particular
	 * vertical distance as values
	 * 
	 * @param root
	 *            : root {@link Node} of tree
	 * @param dist
	 *            : distance of root node from root node
	 * @param map
	 *            : map which contains horizontal distance form node as a key
	 *            and list of {@link Node} at particular distance as value
	 * 
	 */
	public void verticalOrderTraversal(Node root, int dist, Map<Integer, List<Node>> map) {
		if (root != null) {
			if (map.containsKey(dist)) {
				map.get(dist).add(root);
			} else {
				List<Node> list = new ArrayList<>();
				list.add(root);
				map.put(dist, list);
			}
			verticalOrderTraversal(root.left, dist - 1, map);
			verticalOrderTraversal(root.right, dist + 1, map);
		}
	}

	/**
	 * This method use to print the top view of a given binary tree
	 * 
	 * @param root
	 *            : root {@link Node} of a binary tree
	 */
	public void printTopViewOfBt(Node root) {
		Map<Integer, List<Node>> map = new TreeMap<>();
		verticalOrderTraversal(root, 0, map);
		for (List<Node> list : map.values()) {
			System.out.print(list.get(0) + " ");
		}
	}

	/**
	 * This method is use to print vertical order traversal
	 * 
	 * @param root
	 *            : root of the binary tree
	 */
	public void printVerticalOrderTraversal(Node root) {
		Map<Integer, List<Node>> map = new TreeMap<>();
		verticalOrderTraversal(root, 0, map);
		for (List<Node> list : map.values()) {
			list.stream().forEach(entry -> System.out.print(entry + " "));
			System.out.println();
		}
	}
}
