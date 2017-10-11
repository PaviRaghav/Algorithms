package Implementation;

/**
 * directed graph adjacency matrix
 * 
 * @author pavithraraghavan
 *
 */

public class Graph_AdjMatrix {
	private boolean[][] adj;
	private int size;

	public Graph_AdjMatrix(int i) {
		this.size = i;
		this.adj = new boolean[this.size][this.size];
	}

	public void add(int a, int b) {
		this.adj[a][b] = true;
	}

	public boolean isEdge(int a, int b) {
		return this.adj[a][b];
	}
}
