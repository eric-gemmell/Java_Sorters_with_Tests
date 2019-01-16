package Sorters;

public class InsertSorter extends Sorter {

	@Override
	public int[] SortIntArray(int[] toSort) {
		for (int j = 1; j < toSort.length;j++) {
			int valueAtJ = toSort[j];
			
			int i = j-1;
			while (i >= 0 && toSort[i] > valueAtJ) {
				toSort[i+1] = toSort[i];
				i--;
			}
			toSort[i+1] = valueAtJ;
		}
		return toSort;
	}
	public  static void main(String[] Args) {
		Sorter sorter = new InsertSorter();
		sorter.SortIntArray(new int[]{56,21,6,1,8,4,2});
	}
}
