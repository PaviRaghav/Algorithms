/*
Partition string int to sub-strings such that each sub-string is a palindrome.
*/

class PartitionString {
	public ArrayList<ArrayList<String>> partition(String a) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		generate(result, a, new ArrayList<String>());
		return result;
	}

	private void generate(ArrayList<ArrayList<String>> result, String A, ArrayList<String> temp) {
		//System.out.println(A);
		if (A == "" || A.isEmpty()) {
			//System.out.println("hi");
			result.add(new ArrayList<String>(temp));
			return;
		}
		for (int len = 1; len <= A.length(); len++) {
			String a = A.substring(0, len);
			if (checkPalindrome(a)) {
				temp.add(a);
				generate(result, A.substring(len, A.length()), temp);
				temp.remove(temp.size() - 1);
			}
		}
	}

	private boolean checkPalindrome(String a) {
		if (a.length() == 1)
			return true;
		int n = a.length();
		for (int i = 0; i < n / 2; i++) {
			if (a.charAt(i) != a.charAt(n - i - 1))
				return false;
		}
		return true;
	}
}
