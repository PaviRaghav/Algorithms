package Implementation;

/**
 * fast union quick find (by size)
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

	public void union(int a, int b) {
		int A = find(a);
		int B = find(b);
		if (A == B)
			return;
		if (a < 0 || b < 0 || a >= this.size || b >= this.size)
			return;
		// check for larger n point the smaller one to the larger one
		if (A > B) {
			S[B] = S[A] + S[B];
			S[A] = B;
		} else {
			S[A] = S[A] + S[B];
			S[B] = A;
		}
	}
}
