package Sorters;

import java.util.Arrays;

public class InsertSorter extends Sorter {

	@Override
	public void SortIntArray(int[] Sorted) {
		for (int j = 1; j < Sorted.length;j++) {
			int valueAtJ = Sorted[j];
			
			int i = j-1;
			while (i >= 0 && Sorted[i] > valueAtJ) {
				Sorted[i+1] = Sorted[i];
				i--;
			}
			Sorted[i+1] = valueAtJ;
		}
	}
	public void SortSubArray(int[] A,int p, int r) {
		for (int j = p+1; j < r+1;j++) {
			int valueAtJ = A[j];
			
			int i = j-1;
			while (i >= 0 && A[i] > valueAtJ) {
				A[i+1] = A[i];
				i--;
			}
			A[i+1] = valueAtJ;
		}
	}
	public static void main(String[] Args) {
		int[] a = new int[]{8,23,8,32,90,3,6,1,0,45,2,67,2,42};
		Sorter sorter = new InsertSorter();
		sorter.SortIntArray(a);
		System.out.println(Arrays.toString(a));
	}
}
