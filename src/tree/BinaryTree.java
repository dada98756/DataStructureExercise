package tree;

import java.util.Stack;

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
	
	public static void inOrderTraverseIterative(Node n){
		Node curr = n;
		Stack<Node> stack = new Stack<Node>();
		while (curr != null || !stack.isEmpty()){
			if (curr != null){
				stack.push(curr);
				curr = curr.left;
			}else{
				curr = stack.pop();
				curr = curr.right;
			}
		}
	}
	
	public static void preOrderTraverse(Node n){
		if (n == null){
			return;
		}
		System.out.println(n.val);
		preOrderTraverse(n.left);
		preOrderTraverse(n.right);
	}
	
	public static void preOrderTraverseIterative(Node n){
		Stack<Node> stack = new Stack<Node>();
		stack.push(n);
		Node curr;
		while (!stack.isEmpty()){
			curr = stack.pop();
			if (curr.right != null){
				stack.push(curr.right);
			}
			if (curr.left != null){
				stack.push(curr.left);
			}
		}
	}
	
	public static void postOrderTraverse(Node n){
		if (n == null){
			return;
		}
		postOrderTraverse(n.left);
		postOrderTraverse(n.right);
		System.out.println(n.val);
	}
	
	public static void postOrderTraverseIterative(Node n){
		Stack<Node> stack = new Stack<Node>();
		Node prev= null;
		Node curr= null;
		stack.push(n);
		while(!stack.isEmpty()){
			curr = stack.peek();
			if ( prev == null || prev.left == curr || prev.right == curr){
				if (curr.right != null){
					stack.push(curr.right);
				}
				if (curr.left != null){
					stack.push(curr.left);
				}
			}else if (curr.left == prev){
				if (curr.right != null){
					stack.push(curr.right);
				}
			}else{
				stack.pop();
			}
			prev = curr;
		}
	}
	
	class Node{
		int val;
		Node left;
		Node right;
	}
}
