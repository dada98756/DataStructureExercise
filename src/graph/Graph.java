package graph;

import graph.Graph.Node.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {

	public static Set<Node> nodeSet = new HashSet<Node>();
	public static HashMap<Node,Node> cycleMap = new HashMap<Node,Node>();
	public static boolean DFS(Node n){
		if (n == null){
			return false;
		}
		System.out.println(n.val);
		n.color=Color.grey;
		for (Node c : n.neighbors){
			if (c.color == Color.grey){
				cycleMap.put(c, n);
				return true;
			}
			if (!nodeSet.contains(c)){
				boolean result = DFS(c);
				if (result){
					cycleMap.put(c, n);
					if (cycleMap.containsKey(n)){
						//get cycle
					}
					return result;
				}
			}
		}
		n.color=Color.black;
		return false;
	}

	public static void DFSStack(Node n){
		if (n == null){
			return;
		}
		Stack<Node> nodeStack = new Stack<Node>();
		nodeStack.push(n);
		while(!nodeStack.isEmpty()){
			Node node = nodeStack.pop();
			System.out.println(node.val);
			for (Node c: node.neighbors){
				if (!nodeSet.contains(node)){
					nodeStack.push(c);
					nodeSet.add(node);
				}
			}
		}
	}

	public static void BFSSimple(Node n){
		if (n == null){
			return;
		}
		Queue<Node> nodeQueue = new LinkedList<Node>();
		nodeQueue.offer(n);
		while(!nodeQueue.isEmpty()){
			Node node = nodeQueue.poll();
			for (Node c: node.neighbors){
				if (!nodeSet.contains(node)){
					System.out.println(node.val);
					nodeSet.add(node);
					nodeQueue.offer(c);
				}
			}
		}
	}

	public static void BFS(Node n){
		if (n == null){
			return;
		}
		ArrayList<ArrayList<Node>> levels = new ArrayList<ArrayList<Node>>();
		ArrayList<Node> currLevel = new ArrayList<Node>();
		currLevel.add(n);
		nodeSet.add(n);
		while(!currLevel.isEmpty()){
			levels.add(currLevel);
			ArrayList<Node> nextLevel = new ArrayList<Node>();
			System.out.print("level "+ levels.size()+":");
			for(Node node: currLevel){
				System.out.print(node.val+"\t");
				for (Node c : node.neighbors){
					if (!nodeSet.contains(c)){
						nodeSet.add(c);
						nextLevel.add(c);
					}
				}
			}
			System.out.println();
			currLevel = nextLevel;
		}
	}

	static class Node{
		int val;
		ArrayList<Node> neighbors;
		Color color = Color.white;
		enum Color{
			white,grey,black
		};
	}
}
