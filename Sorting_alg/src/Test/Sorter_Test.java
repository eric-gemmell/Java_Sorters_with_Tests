package Test;
import org.junit.Assert;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Sorters.InsertSorter;
import Sorters.MergeSorter;
import Sorters.SelectionSorter;
import Sorters.Sorter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public class Sorter_Test {
	Sorter insertSorter;
	Sorter selectionSorter;
	Sorter mergeSorter;
	int[] file1,file2,file3,file4;
	
	private int[] LoadFile(String filePath) {		
		String currentLine = null;
		BufferedReader br = null;
		ArrayList<Integer> ints = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(filePath));
			while ((currentLine=br.readLine()) != null) {
				ints.add(Integer.parseInt(currentLine));
			}
		}
		catch (IOException e) {
			System.out.println("HEYO");
			e.printStackTrace();
		}
		int[] a = new int[ints.size()];
		for(int i = 0; i <ints.size(); i++) {
			a[i] = ints.get(i);
		}
		return a;
	}
	@BeforeEach
	void setUp() throws Exception {
		this.insertSorter = new InsertSorter();
		this.selectionSorter = new SelectionSorter();
		this.mergeSorter = new MergeSorter();
		this.file1 = LoadFile("./src/Test/10.txt");
		this.file2 = LoadFile("./src/Test/50.txt");
		this.file3 = LoadFile("./src/Test/100.txt");
		this.file4 = LoadFile("./src/Test/1000.txt");
	}
	@AfterEach
	void tearDown() {
		this.insertSorter = null;
		this.selectionSorter = null;
		this.mergeSorter = null;
	}
	@Test
	public void insertSorterHasSortMethod() {
		boolean hasMethod = false;
		Method[] methods = this.insertSorter.getClass().getMethods();
		for (Method m : methods) {
			if (m.getName().equals("SortIntArray")) {
				hasMethod = true;
				break;
			}
		}
		Assert.assertTrue("Insert Sorter needs to have SortIntArray function...",hasMethod);
	}
	@Test
	public void selectionSorterHasSortMethod() {
		boolean hasMethod = false;
		Method[] methods = this.selectionSorter.getClass().getMethods();
		for (Method m : methods) {
			if (m.getName().equals("SortIntArray")) {
				hasMethod = true;
				break;
			}
		}
		Assert.assertTrue("Selection Sorter needs to have SortIntArray function...",hasMethod);
	}
	@Test
	public void mergeSorterHasSortMethod() {
		boolean hasMethod = false;
		Method[] methods = this.mergeSorter.getClass().getMethods();
		for (Method m : methods) {
			if (m.getName().equals("SortIntArray")) {
				hasMethod = true;
				break;
			}
		}
		Assert.assertTrue("Merge Sorter needs to have SortIntArray function...",hasMethod);
	}
	@Test
	public void insertSorterHasFunctionalTestMethod() {
		Assert.assertNotEquals("",this.insertSorter.Test());
	}
	@Test
	public void selectionSorterHasFunctionalTestMethod() {
		Assert.assertNotEquals("",this.selectionSorter.Test());
	}
	@Test
	public void mergeSorterHasFunctionalTestMethod() {
		Assert.assertNotEquals("",this.mergeSorter.Test());
	}
	@Test
	public void insertSorterSortIntArrayWorksCorrectly() {
		Assert.assertArrayEquals(new int[]{1,2,3,5,58,68,78,98,219}, this.insertSorter.SortIntArray(new int[]{68,219,5,2,78,1,58,3,98}));
	}
	@Test
	public void selectionSorterSortIntArrayWorksCorrectly() {
		Assert.assertArrayEquals(new int[]{1,2,3,5,58,68,78,98,219}, this.selectionSorter.SortIntArray(new int[]{68,219,5,2,78,1,58,3,98}));
	}
	@Test
	public void mergeSorterSortIntArrayWorksCorrectly() {
		Assert.assertArrayEquals(new int[]{1,2,3,5,58,68,78,98,219}, this.mergeSorter.SortIntArray(new int[]{68,219,5,2,78,1,58,3,98}));
	}
	@Test
	public void mergeSorterMergeFunctionWorksCorrectly() {
		MergeSorter mergeSorter = new MergeSorter();
		int[] a = {1,2,4,6,3,6,8,9};
		mergeSorter.Merge(a,0,3,7);
		Assert.assertArrayEquals(a,new int[] {1,2,3,4,6,6,8,9});
	}
	@Test
	public void PrintSorterTimes() {
		getSortTimesForGivenSorter(this.selectionSorter);
		getSortTimesForGivenSorter(this.insertSorter);
		getSortTimesForGivenSorter(this.mergeSorter);
	}
	private void getSortTimesForGivenSorter(Sorter sorter) {
		System.out.println(sorter.getClass().getSimpleName()+" Sorter Sort Speeds (picoseconds):\n");
		//System.out.println("Everything good so far... " + Arrays.toString(file1));
		System.out.println("[10]: "+(TimeToSort(file1,sorter)));
		System.out.println("[50]: "+(TimeToSort(file2,sorter)));
		System.out.println("[100]: "+(TimeToSort(file3,sorter)));
		System.out.println("[1000]: "+(TimeToSort(file4,sorter)) + "\n");
	}
	private long TimeToSort(int[] toSort,Sorter sorter) {
		long startTime = System.nanoTime();
		sorter.SortIntArray(toSort);
		long endTime = System.nanoTime();
		return (endTime-startTime);
	}
}
