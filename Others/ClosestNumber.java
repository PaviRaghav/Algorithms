/**
 * Closest number with same weight. weight = number of 1's in the binary
 * representation of the number
 * 
 * @author pavithraraghavan
 *
 */
public class ClosestNumber {
	public long closestIntSameWeight(long x) {
		// assume: input x does not contain all 1's or all 0's
		for (int i = 0; i < 63; i++) {
			if (((x >>> i) & 1) != ((x >>> i + 1) & 1)) {
				x ^= (1L << i) | (1L << (i + 1));
			}
		}
		return x;
	}
}
