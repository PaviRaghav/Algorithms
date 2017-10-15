package Algorithms;

import java.util.LinkedList;

import Implementation.Q_DynArray;

/**
 * depth-first search
 * 
 * @author pavithraraghavan
 *
 */
public class DFS {
	private LinkedList<Integer>[] adj;
	private int size;
	boolean[] visited;

	public void Graph_AdjList(int i) {
		this.size = i;
		this.adj = new LinkedList[this.size];
	}

	public void add(int a, int b) {
		this.adj[a].add(b);
	}

	public void dfs(int a) {
		System.out.println(a);
		visited[a] = true;
		for (int x : adj[a]) {
			if (!visited[x])
				dfs(x);
		}
	}
}
