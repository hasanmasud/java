package com.smartcompute.datastructurealgorithms.code;


/**
 * 
 * One of the most popular question from data structures and algorithm, 
 * mostly asked on telephonic interview. Since many programmer know that, 
 * in order to find length of linked list we need to first traverse through linked list till we find last node, 
 * which is pointing to null, and then in second pass we can find middle element by traversing only half of length. 
 * They get confused when interviewer ask him to do same job in one pass. 
 * In order to find middle element of linked list in one pass you need to maintain two pointer, 
 * one increment at each node while other increments after two nodes at a time, by having this arrangement, 
 * when first pointer reaches end, second pointer will point to middle element of linked list.
 *
 */
public class MiddleElementInSinglePass {
	
	public static void main(String ...args){

		LinkedList linkedList = new LinkedList();
		linkedList.add(new LinkedList.Node("node1"));
		linkedList.add(new LinkedList.Node("node2"));
		linkedList.add(new LinkedList.Node("node3"));
		linkedList.add(new LinkedList.Node("node4"));
		linkedList.add(new LinkedList.Node("node5"));
		
		
		
		
		
		
	}
	

	
	
}
