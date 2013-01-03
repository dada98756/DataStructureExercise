package stack;

public class LinkedStack {
	Node sp;
	
	public LinkedStack(){}
	public void push(int d){
		Node newNode = new Node();
		newNode.val = d;
		if (sp == null){
			sp = newNode;
		}else{
			newNode.prev = sp;
			sp.next = newNode;
			sp = newNode;
		}
	}
	
	public int pop(){
		if (sp == null){
			return -1;
		}else{
			int temp = sp.val;
			sp = sp.prev;
			return temp;
		}
		
	}
	
	class Node{
		int val;
		Node next;
		Node prev;
	}
}
