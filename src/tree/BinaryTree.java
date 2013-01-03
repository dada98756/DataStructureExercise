package tree;

public class BinaryTree {
	Node root;
	
	public BinaryTree(){}
	
	public static void inOrderTraverse(Node n){
		if (n == null){
			return;
		}
		inOrderTraverse(n.left);
		System.out.println(n.val);
		inOrderTraverse(n.right);
	}
	public static void preOrderTraverse(Node n){
		if (n == null){
			return;
		}
		System.out.println(n.val);
		preOrderTraverse(n.left);
		preOrderTraverse(n.right);
	}
	public static void postOrderTraverse(Node n){
		if (n == null){
			return;
		}
		postOrderTraverse(n.left);
		postOrderTraverse(n.right);
		System.out.println(n.val);
	}
	
	class Node{
		int val;
		Node left;
		Node right;
	}
}
