package cs240_lab2;

public class MergeSort {
	static int countMove = 0;
	static int countCompare = 0;
	
	public static <T extends Comparable<? super T>> void mergeSort(T[] a, int n){
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Comparable[a.length];
		int startingLeftovers = n;
		for (int segmentLen = 1; segmentLen <= n/2; segmentLen = 2*segmentLen){
			startingLeftovers = segmentPairs(a,temp,n,segmentLen);
			int endingSegment = startingLeftovers + segmentLen -1;
			if(endingSegment < n-1)
				merge (a, temp, startingLeftovers, endingSegment, n-1);
			
		}
		if (startingLeftovers < n)
			merge( a, temp, 0, startingLeftovers -1, n-1);
	}
	public static <T extends Comparable<? super T>> int segmentPairs(T[] a, T[] temp, int n, int segmentLen){
		int mergedPairLen = 2*segmentLen;
		int numPairs = n/mergedPairLen;
		int startingSegment1 = 0;
		for(int count = 1; count <= numPairs; count++){
			int endingSegment1 = startingSegment1 + segmentLen -1;
			int startingSegment2 = endingSegment1 +1;
			int endingSegment2 = startingSegment2 + segmentLen -1;
			merge(a,temp,startingSegment1,endingSegment1, endingSegment2);
			startingSegment1 = endingSegment2 +1;
			
		}
		return startingSegment1;
	}
	public static <T extends Comparable<? super T>> void merge(T[] a, T[] temp, int first, int mid, int last){
		int startingHalf1 = first;
		int endHalf1 = mid;
		int startingHalf2 = mid + 1;
		int endHalf2 = last;
		int index = startingHalf1;
		for (; (startingHalf1 <= endHalf1) && (startingHalf2 <= endHalf2); index++){
			if(a[startingHalf1].compareTo(a[startingHalf2])< 0){
				temp[index] = a[startingHalf1];
				startingHalf1++;
				
			}
			else{
				temp[index] = a[startingHalf2];
				startingHalf2++;
				
			}
			
		}
		for (; startingHalf1 <= endHalf1; startingHalf1++,index++)
			temp[index] = a[startingHalf1];
		for (; startingHalf1 <= endHalf2; startingHalf2++,index++)
			temp[index] = a[startingHalf2]; 
		for (index = first; index <= last; index++)
			a[index] = temp[index];
	}
}
