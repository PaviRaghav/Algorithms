/*
Write a method to multiply two positive integers.
*/
import java.util.*;

class Multiply {

	public int multiply(int A, int B) {
		int x, y, sum;
		if (A < B) {
			x = B;
			y = A;
		} else {
			x = A;
			y = B;
		}
		if (y == 1)
			return x;
		sum = 0;
		while (y > 1) {
			if ((y & 1) == 1) {
				y--;
				sum += x;
			} else {
				y = y >> 1;
				sum += x << 1;
			}
			// System.out.println(sum);
		}
		return sum;
	}
}
