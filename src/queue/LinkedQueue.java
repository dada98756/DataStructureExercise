package queue;

public class LinkedQueue {
	Node head;
	Node tail;
	
	public LinkedQueue(){}
	
	public void offer(int v){
		Node newNode = new Node();
		newNode.val = v;
		if (head == null){//use head instead of tail to avoid pointing tail to null when the last remaining node is polled out.
			head = newNode;
			tail = newNode;
			newNode.prev = null;
			newNode.next = null;
		}else{
			newNode.prev = tail;
			newNode.next = null;
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	public int poll(){//head is null? head is the only one?
		if (head == null){
			return -1;
		}
		int temp = head.val;
		head = head.next;
		return temp;
	}
	
	class Node{
		int val;
		Node next;
		Node prev;
		
		public Node(){}
		public Node(int v, Node n, Node p){
			val = v;
			next = n;
			prev = p;
		}
	}
}
