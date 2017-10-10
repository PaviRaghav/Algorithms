package Implementation;

/**
 * fast union quick find (by size, by height)
 * 
 * @author pavithraraghavan
 *
 */
public class Sets_quickFind {
	private int size;
	public int[] S;

	public Sets_quickFind(int a) {
		this.size = a;
		S = new int[this.size];
		for (int i = 0; i < this.size; i++) {
			S[i] = -1;
		}
	}

	public int find(int a) {
		if (a < 0 || a >= this.size)
			return -1;
		if (S[a] < 0)
			return a;
		else
			return find(S[a]);
	}

	public void unionBySize(int a, int b) {
		if (find(a) == find(b))
			return;
		if (a < 0 || b < 0 || a >= this.size || b >= this.size || find(a) != -1)
			return;
		// check for larger n point the smaller one to the larger one
		if (S[a] > S[b]) {
			S[b] = S[a] + S[b];
			S[a] = b;
		} else {
			S[a] = S[a] + S[b];
			S[b] = a;
		}
	}

	public void unionByHeight(int a, int b) {
		if (find(a) == find(b))
			return;
		if (a < 0 || b < 0 || a >= this.size || b >= this.size || find(a) != -1)
			return;
		if (S[a] > S[b]) {
			S[a] = b;
		} else {
			if (S[a] == S[b])
				S[b]--;
			S[b] = a;
		}
	}
}
