package DataLabs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lab05 {

	public static void main(String[] args) {
		Node n1 = new Node(10);
		Node n2 = new Node(7);
		Node n3 = new Node(11);
		Node n4 = new Node(8);
		Node n5 = new Node(12);
		Node n6 = new Node(9);
		Node n7 = new Node(20);
		Node n8 = new Node(6);
		
		n1.children.add(n2);
		n1.children.add(n3);
		n2.children.add(n4);
		n2.children.add(n5);
		n5.children.add(n8);
		n3.children.add(n6);
		n3.children.add(n7);

		Tree tree = new Tree(0);
		tree.root = n1;
		
		System.out.println("BFS:");
		tree.bfs();
		System.out.println("\nDFS:");
		tree.dfs(n1);


	}

}

class Node {
	int value;
	List<Node> children;

	public Node(int value) {
		this.value = value;
		this.children = new ArrayList<>();
	}
}

class Tree {
	Node root;

	public Tree(int value) {
		Node newNode = new Node(value);
		root = newNode;
	}

	public void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			Node n = q.poll();
			System.out.println(n.value);
			for (Node child : n.children) {
				q.add(child);
			}
		}

	}
	//we can use stack for dfs.
	public void dfs(Node n) {
		if(n==null) {
			return;
		}
		System.out.println(n.value);
		for(Node child:n.children) {
			dfs(child);
		}
	}
}

