import java.util.*;

class LongestSubstring {
	public int lengthOfLongestSubstring(String A) {
		if (A.length() <= 1)
			return A.length();
		int max = 0, low = 0, up = 1;
		HashSet<Character> map = new HashSet<Character>();
		map.add(A.charAt(0));
		max = 1;
		while (up < A.length()) {
			char x = A.charAt(up);
			// System.out.println(x);
			if (map.contains(x)) {
				while (A.charAt(low) != x) {
					map.remove(A.charAt(low));
					low++;
				}
				low++;
			}
			map.add(x);
			max = Math.max(max, up - low + 1);
			up++;
		}
		return max;
	}
}
