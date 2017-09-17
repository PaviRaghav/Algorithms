package Algorithms;

public class PowerOfn {
	public int powern_algo1(int base, int pow) {
		// Algorithm 1
		if (pow == 0)
			return 1;
		return base * powern_algo1(base, pow - 1);
	}

	public int powern_algo2(int base, int pow) {
		// Algorithm 2
		if (pow == 0)
			return 1;
		while (pow != 1) {
			base *= base;
			pow /= 2;
		}
		return base;
	}
}
