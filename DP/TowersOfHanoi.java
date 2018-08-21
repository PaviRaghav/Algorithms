import java.util.*;

class TowersOfHanoi {

	public void towerOfHanoi(Stack<Integer> from, Stack<Integer> to, Stack<Integer> use, int n) {
		if (n == 0)
			return;
		towerOfHanoi(from, use, to, n - 1);
		to.push(from.pop());
		towerOfHanoi(use, to, from, n - 1);
	}
}
