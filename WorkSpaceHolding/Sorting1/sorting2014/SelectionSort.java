package sorting2014;

public class SelectionSort implements Sorter {

	@SuppressWarnings("unchecked")
	public void sort(Comparable[] items, int cutoff) {
		Comparable temp;
		for (int i = 0; i < items.length; i++) {
			int low = i;
			int j;


			for (j = low + 1; j < items.length; j++) {//find the smallest/lowest 

				if (items[j].compareTo(items[low]) < 0) {
					low = j;
				}
			}

	
			temp = items[low];
			items[low] = items[i];// here the swap happens 
			items[i] = temp;

		}
	}

}
