package Test;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.TemporaryFolder;

import Sorters.InsertSorter;
import Sorters.SelectionSorter;
import Sorters.Sorter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import java.util.concurrent.TimeUnit;
public class Sorter_Test {
	Sorter insertSorter;
	Sorter selectionSorter;
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
		this.file1 = LoadFile("./src/Test/10.txt");
		this.file2 = LoadFile("./src/Test/50.txt");
		this.file3 = LoadFile("./src/Test/100.txt");
		this.file4 = LoadFile("./src/Test/1000.txt");
	}
	@AfterEach
	void tearDown() {
		this.insertSorter = null;
		this.selectionSorter = null;
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
		Assert.assertTrue("Insert Sorter needs to have SortIntArray function...",hasMethod);
	}
	@Test
	public void insertSorterHasFunctionalTestMethod() {
		Assert.assertNotEquals("",this.insertSorter.Test());
	}
	@Test
	public void selectionSorterHasFunctionalTestMethod() {
		Assert.assertNotEquals("",this.insertSorter.Test());
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
	public void TimeSorters() {
		System.out.println("Insert Sorter Sort Speeds (picoseconds):\n");
		System.out.println("[10]: "+(TimeToSort(file1,insertSorter)));
		System.out.println("[50]: "+(TimeToSort(file2,insertSorter)));
		System.out.println("[100]: "+(TimeToSort(file3,insertSorter)));
		System.out.println("[1000]: "+(TimeToSort(file4,insertSorter)) +"\n");
		System.out.println("Selection Sorter Sort Speeds (picoseconds):\n");
		System.out.println("[10]: "+(TimeToSort(file1,selectionSorter)));
		System.out.println("[50]: "+(TimeToSort(file2,selectionSorter)));
		System.out.println("[100]: "+(TimeToSort(file3,selectionSorter)));
		System.out.println("[1000]: "+(TimeToSort(file4,selectionSorter)));
	}
	private long TimeToSort(int[] toSort,Sorter sorter) {
		long startTime = System.nanoTime();
		sorter.SortIntArray(toSort);
		long endTime = System.nanoTime();
		return (endTime-startTime);
	}
}
