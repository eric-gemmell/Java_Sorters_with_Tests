package Test;

import java.util.Arrays;
import java.util.Random;
public class PathologicalInputGenerator {
	public int[] QuickSortNightmare(int length) {
		int[] horrorArray = new int[length];
		for (int i = 0; i < length; i++) {
			horrorArray[i] = i;
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
	public int[] NormalArray(int arrayLength) {
		int[] randomArray = new int[arrayLength];
		Random random = new Random();
		for (int i = 0;i<arrayLength;i++) {
			randomArray[i] = random.nextInt(arrayLength);
		}
		return randomArray;
	}
	public static void main(String[] args) {
		PathologicalInputGenerator a = new PathologicalInputGenerator();
		int[] horror = a.MedianQuickSortNightmare(10000);
		System.out.println(Arrays.toString(horror));
	}
}
