package Algorithms;

/**
 * This class is to remove adjacent duplicates from an array
 * 1,5,6,8,8,8,0,1,1,0,6,5
 * 
 * @author pavithraraghavan
 *
 */
public class Dedup {
	public static int remAdjDup(int[] A) {
		int ptr = -1;
		int i = 0;
		while(i<A.length){
			if(ptr==-1 || A[ptr]!=A[i]){
				ptr++;
				A[ptr]=A[i];
				i++;
			}
			else {
				while(i<A.length && A[ptr]==A[i])
					i++;
				ptr--;
			}
		}
		return ptr;
	}

	public static void main(String[] args) {
		int[] A = { 1, 5, 0, 8, 8, 8, 0, 1, 1, 0, 6, 5,2 };
		int a= remAdjDup(A);
		for (int i = 0; i <= a; i++)
			System.out.print(A[i] + " ");
	}
}
