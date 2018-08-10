import java.util.*;

class NumUnique {
	public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (B <= A.size()) {
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			int low = 0, high = 0;
			while (high < B) {
				int x = A.get(high);
				if (map.containsKey(x))
					map.put(x, map.get(x) + 1);
				else
					map.put(x, 1);
				high++;
			}
			while (high < A.size()) {
				result.add(map.size());
				// remove low
				int x = A.get(low);
				map.put(x, map.get(x) - 1);
				if (map.get(x) == 0)
					map.remove(x);
				// add high
				x = A.get(high);
				if (map.containsKey(x))
					map.put(x, map.get(x) + 1);
				else
					map.put(x, 1);
				high++;
				low++;
			}
			result.add(map.size());
		}
		return result;
	}
}
