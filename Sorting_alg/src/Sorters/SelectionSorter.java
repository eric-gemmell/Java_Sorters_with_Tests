package Sorters;

import java.util.Arrays;

public class SelectionSorter extends Sorter {

	@Override
	public int[] SortIntArray(int[] toSort) {
		int[] Sorted = new int[toSort.length];
		for (int i = 0; i < toSort.length;i++) {
			int minPos = 0;
			for(int j = 0; j<toSort.length;j++) {
				if(toSort[j] < toSort[minPos]) {
					minPos = j;
				}
			}
			Sorted[i] = toSort[minPos];
			toSort[minPos] = Integer.MAX_VALUE;
		}
		return Sorted;
	}
	public  static void main(String[] Args) {
		Sorter sorter = new SelectionSorter();
		System.out.println(Arrays.toString(sorter.SortIntArray(new int[]{7,7,6,1,8,4,2})));
	}
}
