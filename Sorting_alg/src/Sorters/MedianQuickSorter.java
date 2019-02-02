package Sorters;

import java.util.Arrays;

public class MedianQuickSorter extends QuickSorter {

	@Override
	public void SortSubArray(int[] A, int p, int r) {
		
		if(r-p <= 2) {
			if(p>r) {
				return;
			}
			if(r-p <2) {
				if(A[r]< A[p]) {
					Swap(A,r,p);
				}
				return;
			}
			if(A[p]>A[p+1]) {
				Swap(A,p,p+1);
			}
			if(A[p+1]>A[r]) {
				Swap(A,p+1,r);
			}
			if(A[p]>A[p+1]) {
				Swap(A,p,p+1);
			}
			return;
		}
		int q = Partition(A, p,r);
		SortSubArray(A,p,q-1);
		SortSubArray(A,q+1,r);
		
	}
	
	@Override
	public int Partition(int[] A,int p, int r) {
		int medianPos = median(A[r-2],A[r-1],A[r]);
		Swap(A,r+medianPos,r);
		int pivot = A[r];
		int i = p-1;
		for(int j = p; j < r; j++) {
			if(A[j]<=pivot) {
				i++;
				Swap(A,i,j);
			}
		}
		i++;
		Swap(A,r,i);
		return i;
	}
	
	private int median(int a, int b, int c) {
	    if ( (a - b) * (c - a) >= 0 ) // a >= b and a <= c OR a <= b and a >= c
	        return -2;
	    else if ( (b - a) * (c - b) >= 0 ) // b >= a and b <= c OR b <= a and b >= c
	        return -1;
	    else
	        return 0;
	}
	
	public static void main(String[] Args) {
		int[] a = new int[]{8,23,8,32,90,3,6,1,0,45,2,67,2,42};
		QuickSorter sorter = new MedianQuickSorter();
		sorter.SortIntArray(a);
		System.out.println(Arrays.toString(a));
	}

}
