package list;

public class MyLinkedList {
	Node head;
	
	public void addToFront(int v){}
	public void removefromFront(){}
	public int indexOf(Node n){return 0;}
	public Node nodeAt(int i){return new Node();}
	public boolean contains(int v){return true;}
	
	class Node{
		int val;
		Node next;
		public Node(){}
		public Node(int v,Node n){
			val = v;
			next = n;
		}
	}
}
