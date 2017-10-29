package Algorithms;

import java.util.*;

public class Bipartite {
	private HashMap<Integer, LinkedList<Integer>> adjList = null;

	enum BIPARTITECOLOR {
		Unvisited, Red, Blue
	}

	public HashMap<Integer, BIPARTITECOLOR> bipartiteColor = null;

	public Bipartite(int[] nodes) {
		adjList = new HashMap<Integer, LinkedList<Integer>>();
		for (int i : nodes)
			adjList.put(i, new LinkedList<Integer>());
	}

	public void addEdge(int node, int newNode) {
		adjList.get(node).add(newNode);
	}

	public void initializeBipartite() {
		bipartiteColor = new HashMap<Integer, BIPARTITECOLOR>();
		for (int node : adjList.keySet()) {
			bipartiteColor.put(node, BIPARTITECOLOR.Unvisited);
		}
	}

	public boolean isBipartite(int source) {
		initializeBipartite();
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(source);
		bipartiteColor.put(source, BIPARTITECOLOR.Red);
		return checkIfBipartite(q);
	}

	public boolean isBipartite() {
		initializeBipartite();
		Queue<Integer> q = new LinkedList<Integer>();
		bipartiteColor.put(0, BIPARTITECOLOR.Red);
		for (int i : adjList.keySet()) {
			q.add(i);
			if (!checkIfGraphBipartite(q))
				return false;
		}
		return true;
	}

	public boolean checkIfGraphBipartite(Queue<Integer> q) {
		if (!q.isEmpty()) {
			int temp = q.remove();
			LinkedList<Integer> neighbors = adjList.get(temp);
			BIPARTITECOLOR color = bipartiteColor.get(temp);
			for (int neighbor : neighbors) {
				if (bipartiteColor.get(neighbor) == BIPARTITECOLOR.Unvisited) {
					if (color == BIPARTITECOLOR.Red)
						bipartiteColor.put(neighbor, BIPARTITECOLOR.Blue);
					else
						bipartiteColor.put(neighbor, BIPARTITECOLOR.Red);
				} else {
					if (bipartiteColor.get(neighbor) == color)
						return false;
				}
			}
			checkIfGraphBipartite(q);
		}
		return true;
	}

	public boolean checkIfBipartite(Queue<Integer> q) {
		if (!q.isEmpty()) {
			int temp = q.remove();
			LinkedList<Integer> neighbors = adjList.get(temp);
			BIPARTITECOLOR color = bipartiteColor.get(temp);
			for (int neighbor : neighbors) {
				if (bipartiteColor.get(neighbor) == BIPARTITECOLOR.Unvisited) {
					if (color == BIPARTITECOLOR.Red)
						bipartiteColor.put(neighbor, BIPARTITECOLOR.Blue);
					else
						bipartiteColor.put(neighbor, BIPARTITECOLOR.Red);
				} else {
					if (bipartiteColor.get(neighbor) == color)
						return false;
				}
			}
			checkIfBipartite(q);
		}
		return true;
	}

	public static void main(String[] args) {
		int node[] = { 0, 1, 2, 3, 4, 5 };
		Bipartite grp = new Bipartite(node);

		grp.addEdge(0, 1);
		grp.addEdge(0, 5);

		grp.addEdge(1, 0);
		grp.addEdge(1, 2);

		grp.addEdge(2, 1);
		grp.addEdge(2, 3);

		grp.addEdge(3, 2);
		grp.addEdge(3, 4);

		grp.addEdge(4, 5);
		grp.addEdge(4, 3);
		
		grp.addEdge(5, 0);
		grp.addEdge(5, 4);
		
		System.out.println(grp.isBipartite());
	}
}
