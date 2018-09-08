import java.util.*;

/*
 
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

 */
class BreakWords {
	public ArrayList<String> wordBreak(String A, ArrayList<String> B) {
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<Integer>[] arr = new ArrayList[A.length()];
		for (int i = 0; i < arr.length; i++)
			arr[i] = new ArrayList<Integer>();
		if (A.length() == 0)
			return result;

		for (int i = 0; i < A.length(); i++) {
			for (int j = i + 1; j <= A.length(); j++) {
				String x = A.substring(i, j);
				if (B.contains(x))
					arr[i].add(j);
			}
		}
		if (arr[0].isEmpty())
			return result;
		wordBreak(A, B, arr, result, new String(), 0);
		return result;

	}

	private void wordBreak(String A, ArrayList<String> dict, ArrayList<Integer>[] arr, ArrayList<String> result,
			String temp, int start) {
		if (start == A.length()) {
			result.add(new String(temp));
			return;
		}
		if (arr[start].isEmpty())
			return;
		for (int i = 0; i < arr[start].size(); i++) {
			if (start != 0)
				temp += " ";
			int end = arr[start].get(i);
			String x = A.substring(start, end);
			;
			temp += x;
			wordBreak(A, dict, arr, result, temp, end);
			temp = temp.substring(0, temp.length() - x.length() - ((start == 0) ? 0 : 1));
		}
	}
}
