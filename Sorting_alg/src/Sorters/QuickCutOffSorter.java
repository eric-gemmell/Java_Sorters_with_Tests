package Sorters;

import java.util.Arrays;

public class QuickCutOffSorter extends QuickSorter {
	InsertSorter cutOffSorter;
	
	public QuickCutOffSorter() {
		this.cutOffSorter = new InsertSorter();
	}
	
	@Override
	public void SortIntArray(int[] toSort) {
		SortSubArray(toSort,0,toSort.length-1);
	}
	
	@Override
	public void SortSubArray(int[] A, int p, int r) {
		if(p<r) {
			if(r-p<10) {
				cutOffSorter.SortSubArray(A,p,r);
			}
			int q = Partition(A, p,r);
			SortSubArray(A,p,q-1);
			SortSubArray(A,q+1,r);
		}
	}
	
	public static void main(String[] Args) {
		int[] a = new int[]{8,23,8,32,90,3,6,1,0,45,2,67,2,42};
		Sorter sorter = new QuickCutOffSorter();
		sorter.SortIntArray(a);
		System.out.println(Arrays.toString(a));
	}

}
