package Implementation;

/**
 * fast union, slow find
 * 
 * @author pavithraraghavan
 *
 */
public class DisjointSet {
	private int size;
	public int[] S;

	public DisjointSet(int a) {
		this.size = a;
		S = new int[this.size];
		for (int i = 0; i < this.size; i++) {
			S[i] = i;
		}
	}

	public int find(int a) {
		if (a < 0 || a >= this.size)
			return -1;
		if (S[a] == a)
			return S[a];
		else
			return find(S[a]);
	}

	public void union(int a, int b) {
		if (find(a) == find(b))
			return;
		if (a < 0 || b < 0 || a >= this.size || b >= this.size)
			return;
		S[a] = b;
	}
}
