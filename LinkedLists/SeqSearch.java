package Algorithms;

public class SeqSearch {
	public int seq_search(int[] a, int x) {
		for(int i=0; i<a.length;i++) {
			if(a[i]==x)
				return i;
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] a = { 3, 5, 1, 6, 2, 7, 4 };
		SeqSearch obj = new SeqSearch(); 
		System.out.println("i = " + obj.seq_search(a,3));
	}
}
