package com.smartcompute.testdome;

/**
 * 
 * validate whether a binary tree is a binarry search tree.
 * 
 *
 */


class Node {
    public int value;
    public Node left, right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

public class BinarySearchTree {
    public static boolean isValidBST(Node root) {
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    	if(root == null){
    		return true;
    	}
    	return validLTR (root.left,Integer.MIN_VALUE,root.value) && validLTR(root.right, root.value,Integer.MAX_VALUE);
    }
   private static boolean validLTR(Node root,Integer min , Integer max){
    	if(root == null){
    		return true;
    	}
    	return root.value < max && root.value > min  &&  validLTR(root.left,min , root.value ) && validLTR(root.right, root.value , max );
    }
    public static void main(String[] args) {
        Node n1 = new Node(1, null, null);
        Node n3 = new Node(3, null, null);
        Node n2 = new Node(2, n1, n3);

        System.out.println(isValidBST(n2));
    }
}