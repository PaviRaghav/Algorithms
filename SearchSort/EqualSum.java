/*
Return the (4) indices of the arrayList, so that the sum of elements at first 2 indices = the sum of elements at last 2 indices
Return A,B,C,d such that arr[A]+arr[B] = arr[C]+arr[D]
*/

import java.math.BigInteger;
import java.util.*;

class EqualSum {
	public ArrayList<Integer> equal(ArrayList<Integer> A) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		HashMap<Integer, TreeMap<Integer, Integer>> map = new HashMap<Integer, TreeMap<Integer, Integer>>();
		TreeMap<Integer, Integer> temp;
		for (int i = 0; i < A.size() - 1; i++) {
			for (int j = i + 1; j < A.size(); j++) {
				int sum = A.get(i) + A.get(j);
				if (map.containsKey(sum)) {
					temp = map.get(sum);
					if (!temp.containsKey(i) && !temp.containsKey(j) && !temp.containsValue(i)
							&& !temp.containsValue(j)) {
						temp.put(i, j);
						map.put(sum, temp);
					}
				} else {
					temp = new TreeMap<Integer, Integer>();
					temp.put(i, j);
					map.put(sum, temp);
				}
			}
		}
		ArrayList<Integer> temp1 = new ArrayList<Integer>();
		for (int i : map.keySet()) {
			temp = map.get(i);
			if (temp.size() > 1) {
				temp1 = new ArrayList<Integer>();
				temp1.add(temp.ceilingEntry(0).getKey());
				temp1.add(temp.ceilingEntry(0).getValue());
				int x = temp1.get(0);
				int key = temp.higherKey(x);
				temp1.add(key);
				temp1.add(temp.get(key));
			}
			//System.out.println(temp1);
			if (resultNotSmaller(result, temp1)) {
				result = new ArrayList<Integer>(temp1);
			}
		}
		return result;
	}

	private boolean resultNotSmaller(ArrayList<Integer> result, ArrayList<Integer> temp1) {
		if (result.size() < 4)
			return true;
		if (result.get(0) > temp1.get(0))
			return true;
		else if (result.get(0) == temp1.get(0) && result.get(1) > temp1.get(1))
			return true;
		else if (result.get(0) == temp1.get(0) && result.get(1) == temp1.get(1) && result.get(2) > temp1.get(2))
			return true;
		else if (result.get(0) == temp1.get(0) && result.get(1) == temp1.get(1) && result.get(2) == temp1.get(2)
				&& result.get(3) > temp1.get(3))
			return true;
		return false;
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		int[] a = { 3, 4, 7, 1, 2, 9, 8 };
		ArrayList<Integer> A = new ArrayList<Integer>();
		for (int i = 0; i < a.length; i++)
			A.add(a[i]);
		// ArrayList<Integer> b = obj.grayCode(4);
		// System.out.println(b);
		ArrayList<Integer> b = obj.equal(A);
		System.out.println(b);
	}
}
