package sorting2014;


public class MergeSort implements Sorter {

	Comparable[] items;
	Comparable[] temp;
	int k;

	@Override
	public void sort(Comparable[] items, int cutoff) 
	{
		k = items.length;
		this.items = items;
		temp = new Comparable[k];
		mergeSort(0, k - 1);

	}
	private void mergeSort(int left, int right) 
	{
		if (left < right) {   // check for the base case 

			int partition = left + (right - left) / 2; // splits the array, or divide 
			
			mergeSort(left, partition);
			//Conquer, merge
			mergeSort(partition + 1, right);
			//Conquer, merge
			merge(left, partition, right);
			//Conquer, merge
		}
	}

	private void merge(int left, int partition, int right) 
	{

		for (int i = left; i <= right; i++) 
		{
			temp[i] = items[i];
		}

		int Index = left;
		int lookRight = partition + 1; //move fowared and look left 
		int Holding = left;
//comparison method used to check the conflicting items 
		while (Index <= partition && lookRight <= right)  //boolean if true for unsorted on left and right 
		{
			
			if (temp[Index].compareTo(temp[lookRight]) <= 0) //merge two together and check 
			{ 
				// compareTo used to compare the current state of thier index and the 'lookRight' 
				
				items[Holding] = temp[Index]; //when items in Holding are equal to the index
				Index++;
			} 
			else 
			{
				items[Holding] = temp[lookRight];//check again to see the state 
				lookRight++;
			}
			Holding++;
		}
		if (Index <= partition) { 
			// when the index is smaller/equal to the partition 
			while (Index <= partition) 
			{
				items[Holding] = temp[Index];
				Holding++;
				Index++;
			}
		} else if (lookRight <= right) 
		{ // if the two are equal.... ....
			while (lookRight <= partition) 
			{
				items[Holding] = temp[lookRight];
				Holding++; //incriment both / return 
				lookRight++;
			}
		}//sub arrays merged into single array 
	}

}
