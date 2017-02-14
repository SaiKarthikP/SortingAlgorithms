package cs240_lab2;

public class InsertionSortR {
	public static <T extends Comparable<? super T>> void insertionSort(T[] a, int first, int last){
		if (first < last){
			insertionSort (a, first, last - 1);
			insertInOrder(a[last], a, first, last - 1);
		}
	}

	private static <T extends Comparable<? super T>> void insertInOrder(T t, T[] a, int first, int last) {
		if(t.compareTo(a[last]) >= 0)
			a[last + 1] = t;
		else if (first < last){
			a[last + 1] = a[last];
			insertInOrder(t, a, first, last - 1);
		}
		else {
			a[last + 1] = a[last];
			a[last] = t;
		}
	}
}
