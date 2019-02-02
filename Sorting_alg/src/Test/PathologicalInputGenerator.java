package Test;

import java.util.Arrays;

public class PathologicalInputGenerator {
	public int[] QuickSortNightmare(int length) {
		int[] horrorArray = new int[length];
		for (int i = 0; i < length; i++) {
			horrorArray[i] = 0;
		}
		return horrorArray;
	}
	public int[] MedianQuickSortNightmare(int length) {
		int[] horrorArray = new int[length];
		for (int i = 0; i < length; i++) {
			horrorArray[i] = 0;
		}
		return horrorArray;
	}
	public static void main(String[] args) {
		PathologicalInputGenerator a = new PathologicalInputGenerator();
		int[] horror = a.MedianQuickSortNightmare(10000);
		System.out.println(Arrays.toString(horror));
	}
}
