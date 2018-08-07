import java.util.*;

class ColorfulNum {
	public int colorful(int A) {
		if (A == 0)
			return 1;
		String x = Integer.toString(A);
		// split into subsequences
		// store the product in hash table
		// return false if products repeat
		HashSet<Integer> product = new HashSet<Integer>();
		HashSet<String> subseq = new HashSet<String>();
		boolean flag = generate(x, subseq);
		if (!flag)
			return 0;
		for (String a : subseq) {
			int prod = 1;
			for (int i = 0; i < a.length(); i++) {
				prod = prod * ((int) a.charAt(i) - 48);
			}
			if (product.contains(prod))
				return 0;
			else
				product.add(prod);
		}
		return 1;
	}

	private boolean generate(String x, HashSet<String> subseq) {
		for (int i = 0; i < x.length(); i++) {
			for (int j = 0; j < x.length() - i; j++) {
				String a = x.substring(j, j + i + 1);
				if (subseq.contains(a))
					return false;
				subseq.add(a);
			}
		}
		return true;
	}
}
