package cs240_lab2;

public class InsertionSort {
	static int countMove = 0;
	static int countCompare = 0;
	public static <T extends Comparable<? super T>> void insertionSort(T[] a, int first, int last){
		for (int i = first + 1; i < last; i++){
			countCompare++;
			if (a[i].compareTo(a[i-1]) < 0){
				T toInsert = a[i];
				int j = i;
				do {
					a[j] = a[j-1];
					j = j -1;
					countMove++;
				} while (j > 0 && toInsert.compareTo(a[j - 1]) < 0);
				
				a[j] = toInsert;
			}
		}
	}
}
	
	
