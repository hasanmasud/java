package com.betterprogrammer;
import java.util.List;


public class BetterProgrammerTask3 {

    // Please do not change this interface
    public static interface Node {
        int getValue();
        List<Node> getChildren();
    }


	public static double getAverage(Node root) {
		/*
		  Please implement this method to
		  return the average of all node values (Node.getValue()) in the tree.
		 */
		double sum = root.getValue() + sum(root.getChildren());
		int count = 1 + countNodes(root.getChildren());
		return sum / count;
	}

	private static int sum(List<Node> nodes) {
		if (nodes == null || nodes.isEmpty()) {
			return 0;
		}
		int sum = 0;
		for (Node n : nodes) {
			sum += n.getValue() + sum(n.getChildren());
		}
		return sum;
	}

	private static int countNodes(List<Node> nodes) {
		if (nodes == null || nodes.isEmpty()) {
			return 0;
		}
		int sum = 0;
		for (Node n : nodes) {
			sum += 1 + countNodes(n.getChildren());
		}
		return sum;
	}
}




