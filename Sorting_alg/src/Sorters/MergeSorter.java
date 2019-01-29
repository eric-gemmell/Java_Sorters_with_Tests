package Sorters;

import java.util.Arrays;

public class MergeSorter extends Sorter {

	@Override
	public int[] SortIntArray(int[] toSort) {
		int[] Sorted = Arrays.copyOf(toSort,toSort.length);
		MergeSort(Sorted,0,Sorted.length-1);
		return Sorted;
	}
	public void MergeSort(int[] toSort, int p, int r) {
		if(p<r) {
			int q = (p+r)/2;
			MergeSort(toSort,p,q);
			MergeSort(toSort,q+1,r);
			Merge(toSort,p,q,r);
		}
		
	}
	public void Merge(int[] toMerge, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		int[] a1 = new int[n1+1];
		int[] a2 = new int[n2+1];
		a1[n1] = Integer.MAX_VALUE;
		a2[n2] = Integer.MAX_VALUE;
		for (int i = p; i <= q; i ++) {
			a1[i-p] = toMerge[i];
		}
		for (int i = q+1; i <= r; i ++) {
			a2[i-(q+1)] = toMerge[i];
		}
		int a1i = 0;
		int a2i = 0;
		for (int i = p; i <= r; i ++) {
			if (a1[a1i] < a2[a2i]) {
				toMerge[i] = a1[a1i];
				a1i ++;
			}
			else {
				toMerge[i] = a2[a2i];
				a2i ++;
			}
		}
	}
	public static void main(String[] args) {
		MergeSorter mergeSorter = new MergeSorter();
		int[] a = {1,2,4,6,3,6,8,9};
		mergeSorter.Merge(a,0,3,7);
		System.out.println(Arrays.toString(a));
		
		a = new int[]{8,23,8,32,90,3,6,1,0,45,2,67,2,42};
		mergeSorter.MergeSort(a,0,a.length-1);
		System.out.println(Arrays.toString(a));
	}
}
