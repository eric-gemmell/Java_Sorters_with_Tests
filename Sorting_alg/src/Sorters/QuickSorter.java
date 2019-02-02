package Sorters;

import java.util.Arrays;

public class QuickSorter extends Sorter {

	@Override
	public void SortIntArray(int[] toSort) {
		SortSubArray(toSort,0,toSort.length-1);
	}
	@Override
	public void SortSubArray(int[] A, int p, int r) {
		if(p<r) {
			int q = Partition(A, p,r);
			SortSubArray(A,p,q-1);
			SortSubArray(A,q+1,r);
		}		
	}

	public int Partition(int[] A,int p, int r) {
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
	
	public void Swap(int[] A, int p, int r) {
		int temp = A[r];
		A[r] = A[p];
		A[p] = temp;
	}
	
	public static void main(String[] Args) {
		int[] a = new int[]{1,2,3,4,5,2,2,3,1,3,5,2,1,4,3,4,1,2,2,1,3,5,4,2,3,4,1,2,5,5,4,3,2,1,4,1,2,3,4,5,5,5,4,4,3,2,3,3,1,2,1,1,4};
		QuickSorter sorter = new QuickSorter();
		sorter.SortIntArray(a);
		System.out.println(Arrays.toString(a));
	}
}
