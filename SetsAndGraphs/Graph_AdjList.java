package Implementation;

import java.util.*;

/**
 * directed graph adjacency list
 * 
 * @author pavithraraghavan
 *
 */

public class Graph_AdjList {
	private LinkedList<Integer>[] adj;
	private int size;

	public Graph_AdjList(int i) {
		this.size = i;
		this.adj = new LinkedList[this.size];
	}

	public void add(int a, int b) {
		this.adj[a].add(b);
	}

	public boolean isEdge(int a, int b) {
		for (int x : this.adj[a]) {
			if (x == b)
				return true;
		}
		return false;
	}
}
