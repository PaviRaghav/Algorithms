import java.util.*;

class validSudoku {
	public int isValidSudoku(final List<String> A) {
		int[][] arr = new int[9][9];
		for (int row = 0; row < A.size(); row++) {
			for (int col = 0; col < A.get(0).length(); col++) {
				if (A.get(row).charAt(col) == '.')
					arr[row][col] = -1;
				else
					arr[row][col] = (int) A.get(row).charAt(col) - 48;
			}
		}
		HashSet<Integer> set;
		// row
		for (int row = 0; row < arr.length; row++) {
			set = new HashSet<Integer>();
			for (int col = 0; col < arr[0].length; col++) {
				if (arr[row][col] > 0) {
					if (set.contains(arr[row][col]))
						return 0;
					else
						set.add(arr[row][col]);
				}
			}
		}
		// col
		for (int col = 0; col < arr[0].length; col++) {
			set = new HashSet<Integer>();
			for (int row = 0; row < arr.length; row++) {
				if (arr[row][col] > 0) {
					if (set.contains(arr[row][col]))
						return 0;
					else
						set.add(arr[row][col]);
				}
			}
		}
		// squares
		int b_ct = 0, c_ct = 0, row = 0, col = 0;
		while (b_ct < 3) {
			row = 0;
			col = b_ct * 3;
			while (row < 9) {
				set = new HashSet<Integer>();
				c_ct = 0;
				while (c_ct < 3) {
					if (arr[row][col] > 0) {
						if (set.contains(arr[row][col]))
							return 0;
						else
							set.add(arr[row][col]);
					}
					col++;
					if (col % 3 == 0) {
						c_ct++;
						row++;
						col = b_ct * 3;
					}
				}
			}
			b_ct++;
		}
		return 1;
	}
}
