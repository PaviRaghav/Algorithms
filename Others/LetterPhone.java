/*
Given a digit string, return all possible letter combinations that the number could represent.

*/

class Solution {
	public ArrayList<String> letterCombinations(String A) {
		ArrayList<ArrayList<Character>> dict = new ArrayList<ArrayList<Character>>();
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<Character> temp;
		for (int i = 0; i < 10; i++) {
			temp = new ArrayList<Character>();
			switch (i) {
			case 0:
				temp.add('0');
				break;
			case 1:
				temp.add('1');
				break;
			case 2:
				temp.add('a');
				temp.add('b');
				temp.add('c');
				break;
			case 3:
				temp.add('d');
				temp.add('e');
				temp.add('f');
				break;
			case 4:
				temp.add('g');
				temp.add('h');
				temp.add('i');
				break;
			case 5:
				temp.add('j');
				temp.add('k');
				temp.add('l');
				break;
			case 6:
				temp.add('m');
				temp.add('n');
				temp.add('o');
				break;
			case 7:
				temp.add('p');
				temp.add('q');
				temp.add('r');
				temp.add('s');
				break;
			case 8:
				temp.add('t');
				temp.add('u');
				temp.add('v');
				break;
			case 9:
				temp.add('w');
				temp.add('x');
				temp.add('y');
				temp.add('z');
				break;
			default:
				break;
			}
			dict.add(temp);
		}
		generate(dict, A, 0, result, "");
		// System.out.println(dict);
		return result;
	}

	private void generate(ArrayList<ArrayList<Character>> dict, String A, int i, ArrayList<String> result,
			String temp) {
		if (i == A.length()) {
			result.add(temp);
			return;
		}
		int index = (int) (A.charAt(i)) - 48;
		int n = dict.get(index).size();
		for (int j = 0; j < n; j++) {
			temp += dict.get(index).get(j);
			generate(dict, A, i + 1, result, temp);
			temp = temp.substring(0, temp.length() - 1);
		}
	}
}
