import java.util.*;

class VerticalOrder {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

	public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (A == null)
			return result;
		TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
		Deque<TreeNode> q = new LinkedList<TreeNode>();
		Deque<Integer> num = new LinkedList<Integer>();
		q.addFirst(A);
		num.addFirst(10);
		TreeNode curr = A;
		int number = 10;
		while (!q.isEmpty()) {
			curr = q.removeLast();
			number = num.removeLast();
			if (map.containsKey(number)) {
				ArrayList<Integer> temp = map.get(number);
				temp.add(curr.val);
				map.put(number, temp);
			} else {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(curr.val);
				map.put(number, temp);
			}
			if (curr.left != null) {
				q.addFirst(curr.left);
				num.addFirst(number - 1);
			}
			if (curr.right != null) {
				q.addFirst(curr.right);
				num.addFirst(number + 1);
			}
		}
		// generate(A, map, 10);
		for (int i : map.keySet()) {
			result.add(map.get(i));
		}
		return result;
	}

	private void generate(TreeNode A, TreeMap<Integer, ArrayList<Integer>> map, int n) {
		// recursive
		if (map.containsKey(n)) {
			ArrayList<Integer> temp = map.get(n);
			temp.add(A.val);
			map.put(n, temp);
		} else {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(A.val);
			map.put(n, temp);
		}
		if (A.left != null)
			generate(A.left, map, n - 1);
		if (A.right != null)
			generate(A.right, map, n + 1);
	}
}
