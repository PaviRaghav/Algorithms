import java.util.*;

class Anagrams {
	public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
		HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < A.size(); i++) {
			char[] x = A.get(i).toCharArray();
			Arrays.sort(x);
			String y = String.valueOf(x);
			if (map.containsKey(y))
				map.get(y).add(i + 1);
			else {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(i + 1);
				map.put(y, temp);
			}
		}
		for (String x : map.keySet()) {
			result.add(map.get(x));
		}
		return result;
	}
}
