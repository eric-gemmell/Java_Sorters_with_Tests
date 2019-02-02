package Sorters;

public abstract class Sorter {
	
	public abstract void SortIntArray(int[] toSort);
	
	public abstract void SortSubArray(int[] toSort,int p, int r);
	
	public String Test() {
		return "You have successfully created a Sorter Object!";
	}
}
