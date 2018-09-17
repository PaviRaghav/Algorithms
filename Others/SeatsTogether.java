import java.util.*;

/*
There is a row of seats. Assume that it contains N seats adjacent to each other. 
There is a group of people who are already seated in that row randomly. 
i.e. some are sitting together & some are scattered.

An occupied seat is marked with a character 'x' and an unoccupied seat is marked with a dot ('.')

Now your target is to make the whole group sit together 
i.e. next to each other, without having any vacant seat between them 
in such a way that the total number of hops or jumps to move them should be minimum.

Return minimum value % MOD where MOD = 10000003
 */
class SeatsTogether {
	public int seats(String A) {
		// find median
		ArrayList<Integer> med = new ArrayList<Integer>();
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) == 'x')
				med.add(i);
		}
		int n = med.size(), median;
		if (n > 0) {
			if (n % 2 == 0)
				median = (med.get(n / 2) + med.get((n / 2) - 1)) / 2;
			else
				median = med.get((n / 2));
		} else
			return 0;
		// left of median
		int left = median;
		int ptr = 0;
		int count = 0;
		while (ptr < left) {
			while (ptr < A.length() && A.charAt(ptr) == '.')
				ptr++;
			while (left >= 0 && A.charAt(left) == 'x')
				left--;
			if (ptr < left) {
				count = (count + Math.abs(left - ptr)) % 10000003;
				ptr++;
				left--;
			}
		}
		int right = median;
		if (A.charAt(right) == '.')
			right++;
		ptr = A.length() - 1;
		while (ptr > right) {
			while (ptr >= 0 && A.charAt(ptr) == '.')
				ptr--;
			while (right < A.length() && A.charAt(right) == 'x')
				right++;
			if (ptr > right) {
				count = (count + Math.abs(right - ptr)) % 10000003;
				ptr--;
				right++;
			}
		}
		return count;
	}
}
