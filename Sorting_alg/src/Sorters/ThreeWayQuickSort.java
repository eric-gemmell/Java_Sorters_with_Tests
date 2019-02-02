package Sorters;

import java.util.Arrays;

public class ThreeWayQuickSort extends Sorter {

	@Override
	public void SortIntArray(int[] toSort) {
		SortSubArray(toSort,0,toSort.length-1);
	}
	@Override
	public void SortSubArray(int[] A, int p, int r) {
		int[] i_j = Partition(A, p,r);
		if(i_j[0]>p) {
			SortSubArray(A,p,i_j[0]);
		}
		if(i_j[1]<r) {
			SortSubArray(A,i_j[1],r);
		}
	}

	public int[] Partition(int[] A,int p, int r) {
		int pivot = A[r];
		int i = p-1;
		int j = r+1;
		for(int x = p; x < j; x++) {
			if(A[x]<pivot) {
				i++;
				Swap(A,i,x);
			}
			else if(A[x]>pivot) {
				j--;
				Swap(A,j,x);
				x--;
			}
		}
		return new int[] {i,j-1};
	}
	public void Swap(int[] A, int p, int r) {
		int temp = A[r];
		A[r] = A[p];
		A[p] = temp;
	}
	public static void main(String[] Args) {
		int[] a = new int[]{1,2,3,4,5,2,2,3,1,3,5,2,1,4,3,4,1,2,2,1,3,5,4,2,3,4,1,2,5,5,4,3,2,1,4,1,2,3,4,5,5,5,4,4,3,2,3,3,1,2,1,1,4};
		ThreeWayQuickSort sorter = new ThreeWayQuickSort();
		sorter.SortIntArray(a);
		System.out.println(Arrays.toString(a));
		
	}

}
