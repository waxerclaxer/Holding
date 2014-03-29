package sorting2014; 
  
public class QuickSort implements Sorter { 
	
	
    private  long comparisons = 0; 
    private  long exchanges = 0; 
    
  
    public void sort(Comparable[] items, int cutoff) { 
        shuffle(items); 
        quickSort(items, 0, items.length - 1); 
    } 
  
    public  void quickSort(Comparable[] items, int left, int right) { 
        if (right <= left) 
            return; 
        int i = partition(items, left, right); 
        
        quickSort(items, left, i - 1); 
        quickSort(items, i + 1, right); 
        quickSort(items, i + 1, left);   // Tri method, three way partition. 
    } 
  
    private  int partition(Comparable[] items, int left, int right) { 
        int i = left - 1; 
        int j = right; 
        while (true) { 
            while (less(items[++i], items[right])) 
                ; 
            while (less(items[right], items[--j])) 
                if (j == left) 
                    break; //if sorted list is equal to the list of that on the left break, start again
            if (i >= j) 
                break; 
            exch(items, i, j); 
        } 
        exch(items, i, right); 
        return i; 
    } 
  //compares the items 1 and items 2  and to balance the sorting to central point.
    private  boolean less(Comparable items, Comparable items2) 
    { 
        comparisons++; 
        return (items.compareTo(items2) < 0); 
    } 
  //Exchanges  the values t
    private  void exch(Comparable[] items, int i, int j) 
    { 
        exchanges++; 
        Comparable swap = items[i]; 
        items[i] = items[j]; 
        items[j] = swap; 
    } 
  
    //Shuffles the array list around and makes the data unsorted in not allready.
    private  void shuffle(Comparable[] items) 
    {  
        int N = items.length; 
        for (int i = 0; i < N; i++) 
        { 
            int r = i + (int) (Math.random() * (N - i)); 
            exch(items, i, r); 
        } 
    } 
  

}