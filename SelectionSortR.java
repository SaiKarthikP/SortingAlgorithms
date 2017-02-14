package cs240_lab2;

public class SelectionSortR {
	public static <T extends Comparable<? super T>> void selectionSort(T[] a, int n){
		selectionSort (a, 0, n-1);
	}
	public static <T extends Comparable<? super T>> void selectionSort (T[] a, int first, int last){
		if (first < last){
			swap (a, first, getiSmallest(a, first, last));
			selectionSort(a, first + 1, last);
		}
	}
	
	public static <T extends Comparable<? super T>> int getiSmallest(T[] a, int first, int last) {
		T min = a[first];
		int iMin = first;
		for (int i = first + 1; i <= last; i++){
			if (a[i].compareTo(min) < 0){
				min = a[i];
				iMin = i;
			}
		}
		return iMin;
	}
		
	public static void swap(Object[] a, int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
