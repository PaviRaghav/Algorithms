package Algorithms;

import java.util.LinkedList;

import Implementation.*;

/**
 * breadth-first search
 * 
 * @author pavithraraghavan
 *
 */
public class BFS {
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

	public void bfs(int a) {
		Q_DynArray<Integer> q = new Q_DynArray<Integer>();
		visited = new boolean[this.size];
		q.Enqueue(a);
		visited[a] = true;
		while (!q.isEmpty()) {
			int temp = q.Dequeue();
			System.out.println(temp);
			for (int x : this.adj[temp]) {
				if (!visited[x]) {
					q.Enqueue(x);
					visited[x] = true;
				}
			}
		}
	}
}
