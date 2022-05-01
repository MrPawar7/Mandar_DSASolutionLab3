package com.Great_Learning_Lab3.BST;

import java.util.ArrayList;

public class FindLongestPath {

	static class Node {

		Node left;
		Node right;
		int data;

	};

	static Node newNode(int d) {
		Node node = new Node();

		node.left = null;
		node.right = null;
		node.data = d;

		return node;

	}

	public static void main(String[] args) {
		Node root = newNode(100);
		root.left = newNode(20);
		root.right = newNode(130);
		root.left.left = newNode(10);
		root.left.right = newNode(50);
		root.right.left = newNode(110);
		root.right.right = newNode(140);
		root.left.left.left = newNode(5);

		ArrayList<Integer> resultList = longestPathUtility(root);
		int length = resultList.size();
		
		System.out.print(resultList.get(length-1));
		for(int i = length-2; i >=0; i--)
			System.out.print("->" + resultList.get(i));
		
	}

	private static ArrayList<Integer> longestPathUtility(Node root) {

		if (root == null) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			return list;
		}

		ArrayList<Integer> listLeft = longestPathUtility(root.left);
		ArrayList<Integer> listRight = longestPathUtility(root.right);

		if (listLeft.size() < listRight.size())
			listRight.add(root.data);
		else
			listLeft.add(root.data);

		return listLeft.size() > listRight.size() ? listLeft : listRight;

	}

}