package sorting2014;

public class OpBubbleSort implements Sorter {
	public void sort(Comparable[] items, int cutoff) {
		
		Comparable temp;
		
		boolean swap = false;
		for (int i = 0; i < items.length - 1; i++) {
			swap = false;
			for (int j = 0; j < items.length - 1 - i; j++) {
				if (items[j].compareTo(items[j + 1]) > 0) {
					temp = items[j + 1];
					items[j + 1] = items[j];
					items[j] = temp;
					swap = true;
				}
			}
			if (!swap) {  // will return the search 
				return;
			}
		}
	}
}