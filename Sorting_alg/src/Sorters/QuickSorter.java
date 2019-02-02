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
		int[] a = new int[]{8,23,8,32,90,3,6,1,0,45,2,67,2,42};
		QuickSorter sorter = new QuickSorter();
		sorter.SortIntArray(a);
		System.out.println(Arrays.toString(a));
	}
}
