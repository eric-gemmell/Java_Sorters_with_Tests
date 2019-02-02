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
		int j = p-1;
		for(int x = p; x <= r; x++) {
			if(A[x]<pivot) {
				i++;
				j++;
				Swap(A,i,j);
				Swap(A,i,x);
			}
			else if(A[x]==pivot) {
				j++;
				Swap(A,j,x);
			}
		}
		j++;
		System.out.println(Arrays.toString(A));
		return new int[] {i,j};
	}
	public void Swap(int[] A, int p, int r) {
		int temp = A[r];
		A[r] = A[p];
		A[p] = temp;
	}
	public static void main(String[] Args) {
		int[] a = new int[]{38, 2, 55, 98, 14, 37, 63, 70, 91, 55};
		ThreeWayQuickSort sorter = new ThreeWayQuickSort();
		System.out.println(Arrays.toString(sorter.Partition(a,0,a.length-1)));
		System.out.println(Arrays.toString(sorter.Partition(a,0,3)));
		System.out.println(Arrays.toString(sorter.Partition(a,6,a.length-1)));
		System.out.println(Arrays.toString(sorter.Partition(a,6,8)));
		System.out.println(Arrays.toString(a));
		
	}

}
