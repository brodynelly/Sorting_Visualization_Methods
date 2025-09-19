package bsn3g9_cs4050_assignment1; /**
 *
 * @author Ouda
 */

//importing the libraries that will be needed in this program

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Random;

//The class that has all the sorts in it
public class SortShow extends JPanel {


		// An array to hold the lines_lengths to be sorted
		public int[] lines_lengths;
		//The amount of lines needed
		public final int total_number_of_lines = 256;
		 // An array to holds the scrambled lines_lengths
		public int[] scramble_lines;
		//A temp Array that is used later for sorts
		public int[] tempArray;

		//the default constructor for the SortShow class
		public SortShow(){
			//assigning the size for the lines_lengths below
			lines_lengths = new int[total_number_of_lines];
			for(int i = 0; i < total_number_of_lines; i++)
				lines_lengths[i] =  i+5;

		}


		//A method that scrambles the lines
		public void scramble_the_lines(){
			//A random generator
			Random num = new Random();
			//Randomly switching the lines
			for(int i = 0; i < total_number_of_lines; i++){
				//getting a random number using the nextInt method (a number between 0 to i + 1)
				int j = num.nextInt(i + 1);
				//swapping The element at i and j
				swap(i, j);
			}
			//assigning the size for the scramble_lines below
			scramble_lines = new int[total_number_of_lines];
			//copying the now scrambled lines_lengths array into the scramble_lines array
			//to store for reuse for other sort methods
			//so that all sort methods will use the same scrambled lines for fair comparison
			for (int i = 0; i < total_number_of_lines; i++)
			{
				scramble_lines[i] = lines_lengths[i];
			}
			//Drawing the now scrambled lines_lengths
			paintComponent(this.getGraphics());
		}

		//Swapping method that swaps two elements in the lines_lengths array
		public void swap(int i, int j){
			//storing the i element in lines_lengths in temp
			int temp = lines_lengths[i];
			//giving i element in lines_lengths the value of j element in lines_lengths
			lines_lengths[i] = lines_lengths[j];
			//giving j element in lines_lengths the value of temp
			lines_lengths[j] = temp;
		}

		//The selectionSort method
		public void SelectionSort(){
			//getting the date and time when the selection sort starts
			Calendar start = Calendar.getInstance();
			//Using the selection sort to lines_lengths sort the array

			for(int i = 0; i < total_number_of_lines - 1; i++){
				int indexOfSmallest = getIndexOfSmallest(i, total_number_of_lines - 1);
				swap(i, indexOfSmallest);
				paintComponent(this.getGraphics());
				delay(10);
			}

			//getting the date and time when the selection sort ends
			Calendar end = Calendar.getInstance();
			//getting the time it took for the selection sort to execute
			//subtracting the end time with the start time
	        SortGUI.selectionTime = end.getTime().getTime() - start.getTime().getTime();
		}

		//this method gets the smallest element in the array of lines_lengths
		public int getIndexOfSmallest(int first, int last){

			int min = lines_lengths[first];
			int indexOfMin = first;
			for(int index = first + 1; index <= last; index++){
				if(lines_lengths[index] < min){
					min = lines_lengths[index];
					indexOfMin = index;
				}
			}

			return indexOfMin;
		}

	///////////////////////////////////////////////////////////////////////////////////

		//recursive merge sort method
		public void R_MergeSort(){
			//getting the date and time when the recursive merge sort starts
			Calendar start = Calendar.getInstance();
			//assigning the size for the tempArray below

			tempArray = new int[total_number_of_lines];
			R_MergeSort(0, total_number_of_lines - 1);

			Calendar end = Calendar.getInstance();
			//getting the time it took for the iterative merge sort to execute
			//subtracting the end time with the start time
	        SortGUI.rmergeTime = end.getTime().getTime() - start.getTime().getTime();

		}

		//recursive merge sort method
		public void R_MergeSort(int first, int last){
			if(first < last){

				int mid = (first + last) / 2;
				R_MergeSort(first, mid);
				R_MergeSort(mid + 1, last);
				R_Merge(first, mid, last);
				paintComponent(this.getGraphics());

				//Causing a delay for 10ms
				delay(10);
			}
		}


		//recursive merge sort method
		public void R_Merge(int first, int mid, int last){

			int beginHalf1 = first;
			int endHalf1 = mid;
			int beginHalf2 = mid + 1;
			int endHalf2 = last;

			int index = beginHalf1;
			for (; (beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2); index++){
				if (lines_lengths[beginHalf1] < lines_lengths[beginHalf2]){
					tempArray[index] = lines_lengths[beginHalf1];
					beginHalf1++;
				}
				else{
					tempArray[index] = lines_lengths[beginHalf2];
					beginHalf2++;
				}
			}

			for (; beginHalf1 <= endHalf1; beginHalf1++, index++)
				tempArray[index] = lines_lengths[beginHalf1];

			for (; beginHalf2 <= endHalf2; beginHalf2++, index++)
				tempArray[index] = lines_lengths[beginHalf2];

			for (index = first; index <= last; index++)
				lines_lengths[index] = tempArray[index];

		}

		//

	//////////////////////////////////////////////////////////////////////////////////////////

		//iterative merge sort method
		public void I_MergeSort()
		{
		//getting the date and time when the iterative merge sort starts
		Calendar start = Calendar.getInstance();
		//assigning the size for the tempArray below
		tempArray = new int[total_number_of_lines];
		//saving the value of total_number_of_lines
		int beginLeftovers = total_number_of_lines;


		for (int segmentLength = 1; segmentLength <= total_number_of_lines/2; segmentLength = 2*segmentLength)
		{
			beginLeftovers = I_MergeSegmentPairs(total_number_of_lines, segmentLength);
			int endSegment = beginLeftovers + segmentLength - 1;
			if (endSegment < total_number_of_lines - 1)
			{
			I_Merge(beginLeftovers, endSegment, total_number_of_lines - 1);
			}
		}

		// merge the sorted leftovers with the rest of the sorted array
		if (beginLeftovers < total_number_of_lines) {
			I_Merge(0, beginLeftovers-1, total_number_of_lines - 1);
		}
		//getting the date and time when the iterative merge sort ends
		Calendar end = Calendar.getInstance();
		//getting the time it took for the iterative merge sort to execute
		//subtracting the end time with the start time
	    SortGUI.imergeTime = end.getTime().getTime() - start.getTime().getTime();
	}

	// Merges segments pairs (certain length) within an array
	public int I_MergeSegmentPairs(int l, int segmentLength)
	{
		//The length of the two merged segments

		//You suppose  to complete this part (Given).
		int mergedPairLength = 2 * segmentLength;
		int numberOfPairs = l / mergedPairLength;

		int beginSegment1 = 0;
		for (int count = 1; count <= numberOfPairs; count++)
		{
			int endSegment1 = beginSegment1 + segmentLength - 1;

			int beginSegment2 = endSegment1 + 1;
			int endSegment2 = beginSegment2 + segmentLength - 1;
			I_Merge(beginSegment1, endSegment1, endSegment2);

			beginSegment1 = endSegment2 + 1;
			//redrawing the lines_lengths
			paintComponent(this.getGraphics());
			//Causing a delay for 10ms
			delay(10);
		}
		// Returns index of last merged pair
		return beginSegment1;
		//return 1;//modify this line
	}

	public void I_Merge(int first, int mid, int last)
	{
		//You suppose  to complete this part (Given).
		// Two adjacent sub-arrays
		int beginHalf1 = first;
		int endHalf1 = mid;
		int beginHalf2 = mid + 1;
		int endHalf2 = last;

		// While both sub-arrays are not empty, copy the
		// smaller item into the temporary array
		int index = beginHalf1; // Next available location in tempArray
		for (; (beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2); index++)
		{
			// Invariant: tempArray[beginHalf1..index-1] is in order
			if (lines_lengths[beginHalf1] < lines_lengths[beginHalf2])
			{
				tempArray[index] = lines_lengths[beginHalf1];
				beginHalf1++;
			}
			else
			{
				tempArray[index] = lines_lengths[beginHalf2];
				beginHalf2++;
			}
		}
		//redrawing the lines_lengths
		//paintComponent(this.getGraphics());

		// Finish off the nonempty sub-array

		// Finish off the first sub-array, if necessary
		for (; beginHalf1 <= endHalf1; beginHalf1++, index++)
			// Invariant: tempArray[beginHalf1..index-1] is in order
			tempArray[index] = lines_lengths[beginHalf1];

		// Finish off the second sub-array, if necessary
		for (; beginHalf2 <= endHalf2; beginHalf2++, index++)
			// Invariant: tempa[beginHalf1..index-1] is in order
			tempArray[index] = lines_lengths[beginHalf2];

		// Copy the result back into the original array
		for (index = first; index <= last; index++)
			lines_lengths[index] = tempArray[index];
	}

	//////////////////////////////////////////////////////////////////////

		/**
		 * Bubble sort method that sorts the array by repeatedly comparing adjacent elements
		 */
		public void BubbleSort(){
			Calendar start = Calendar.getInstance();

			for(int pass = 1; pass < total_number_of_lines; pass++){
				for(int index = 0; index < total_number_of_lines - pass; index++){
					if(lines_lengths[index] > lines_lengths[index + 1]){
						swap(index, index + 1);
						paintComponent(this.getGraphics());
					}
					// delay 10 ms after each pass
					delay(10);
				}
			}

			Calendar end = Calendar.getInstance();
			SortGUI.bubbleTime = end.getTime().getTime() - start.getTime().getTime();
		}

		/**
		 * Insertion sort method that builds the final sorted array one item at a time
		 */
		public void InsertionSort(){
			Calendar start = Calendar.getInstance();

			for(int unsorted = 1; unsorted < total_number_of_lines; unsorted++){
				int firstUnsorted = lines_lengths[unsorted];
				int index = unsorted;

				while((index > 0) && (lines_lengths[index - 1] > firstUnsorted)){
					lines_lengths[index] = lines_lengths[index - 1];
					index--;
				}
				lines_lengths[index] = firstUnsorted;
				paintComponent(this.getGraphics());
				delay(10);
			}

			Calendar end = Calendar.getInstance();
			SortGUI.insertionTime = end.getTime().getTime() - start.getTime().getTime();
		}

		/**
		 * Shell sort method that uses gap sequences to sort elements
		 */
		public void ShellSort(){
			Calendar start = Calendar.getInstance();

			for(int gap = total_number_of_lines / 2; gap > 0; gap = gap / 2){
				for(int i = gap; i < total_number_of_lines; i++){
					int temp = lines_lengths[i];
					int j;
					for(j = i; j >= gap && lines_lengths[j - gap] > temp; j = j - gap){
						lines_lengths[j] = lines_lengths[j - gap];
					}
					lines_lengths[j] = temp;
				}
				paintComponent(this.getGraphics());
				delay(10);
			}

			Calendar end = Calendar.getInstance();
			SortGUI.shellTime = end.getTime().getTime() - start.getTime().getTime();
		}

		/**
		 * Quick sort method that uses divide and conquer approach
		 */
		public void QuickSort(){
			Calendar start = Calendar.getInstance();

			QuickSort(0, total_number_of_lines - 1);

			Calendar end = Calendar.getInstance();
			SortGUI.quickTime = end.getTime().getTime() - start.getTime().getTime();
		}

		/**
		 * Recursive quick sort helper method
		 */
		public void QuickSort(int first, int last){
			if(first < last){
				int pivotIndex = partition(first, last);
				QuickSort(first, pivotIndex - 1);
				QuickSort(pivotIndex + 1, last);
			}
		}

		/**
		 * Partition method for quick sort that places pivot in correct position
		 */
		public int partition(int first, int last){
			int pivot = lines_lengths[last];
			int i = first - 1;

			for(int j = first; j < last; j++){
				if(lines_lengths[j] <= pivot){
					i++;
					swap(i, j);
				}
			}
			swap(i + 1, last);
			paintComponent(this.getGraphics());
			delay(10);
			return i + 1;
		}

		/**
		 * Radix sort method that sorts numbers by processing individual digits
		 */
		public void RadixSort(){
			Calendar start = Calendar.getInstance();

			int max = getMax();

			for(int exp = 1; max / exp > 0; exp = exp * 10){
				countSort(exp);
				paintComponent(this.getGraphics());
				delay(10);
			}

			Calendar end = Calendar.getInstance();
			SortGUI.radixTime = end.getTime().getTime() - start.getTime().getTime();
		}

		/**
		 * Helper method to get maximum value in array
		 */
		public int getMax(){
			int max = lines_lengths[0];
			for(int i = 1; i < total_number_of_lines; i++){
				if(lines_lengths[i] > max){
					max = lines_lengths[i];
				}
			}
			return max;
		}

		/**
		 * Counting sort method used by radix sort for each digit
		 */
		public void countSort(int exp){
			int[] output = new int[total_number_of_lines];
			int[] count = new int[10];

			for(int i = 0; i < total_number_of_lines; i++){
				count[(lines_lengths[i] / exp) % 10]++;
			}

			for(int i = 1; i < 10; i++){
				count[i] = count[i] + count[i - 1];
			}

			for(int i = total_number_of_lines - 1; i >= 0; i--){
				output[count[(lines_lengths[i] / exp) % 10] - 1] = lines_lengths[i];
				count[(lines_lengths[i] / exp) % 10]--;
			}

			for(int i = 0; i < total_number_of_lines; i++){
				lines_lengths[i] = output[i];
			}
		}

	//////////////////////////////////////////////////////////////////////

		//This method resets the window to the scrambled lines display
		public void reset(){
			if(scramble_lines != null)
			{
				//copying the old scrambled lines into lines_lengths
				for (int i = 0; i < total_number_of_lines; i++)
				{
					lines_lengths[i] = scramble_lines[i] ;
				}
			//Drawing the now scrambled lines_lengths
			paintComponent(this.getGraphics());
		}
			}


		//This method colours the lines and prints the lines
		public void paintComponent(Graphics g){
 			super.paintComponent(g);
			//A loop to assign a colour to each line
			for(int i = 0; i < total_number_of_lines; i++){
				//using eight colours for the lines
				if(i % 8 == 0){
					g.setColor(Color.green);
				} else if(i % 8 == 1){
					g.setColor(Color.blue);
				} else if(i % 8 == 2){
					g.setColor(Color.yellow);
				} else if(i%8 == 3){
					g.setColor(Color.red);
				} else if(i%8 == 4){
					g.setColor(Color.black);
				} else if(i%8 == 5){
					g.setColor(Color.orange);
				} else if(i%8 == 6){
					g.setColor(Color.magenta);
				} else
					g.setColor(Color.gray);

				//Drawing the lines using the x and y-components
				g.drawLine(4*i + 25, 300, 4*i + 25, 300 - lines_lengths[i]);
			}

		}

		//A delay method that pauses the execution for the milliseconds time given as a parameter
		public void delay(int time){
			try{
	        	Thread.sleep(time);
	        }catch(InterruptedException ie){
	        	Thread.currentThread().interrupt();
	        }
		}

	}

