import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class sortingComplexity {

	//private static ArrayList<Integer> randomNums;

	int[] randnumArry;
	int[] nums;
	int[] mergeTemp;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		sortingComplexity sortingTest = new sortingComplexity();
		
		
		/*
		 * Stack Over flow - to learn how to pass the arguments
		 */
		if(args.length == 4) {
			sortingTest.order = args[0];
			sortingTest.size = Integer.parseInt(args[1]);
			sortingTest.algorithm = args[2];
			sortingTest.FileName= args[3];
			sortingTest.randnumArry = new int[sortingTest.size];
			ArrayList<Integer> randomNums = new ArrayList<Integer>(sortingTest.size);
			
			// should i be checking for the size of the array??
			// if the size is greater than zero, the user specifies the order and size
		
			if(sortingTest.size < 0) {
				System.out.println("Invalid array size, must be >=1");
				System.exit(1);
			}
			
			else {
				
				Random randGen = new Random();
				
				for( int i=0; i < sortingTest.size; i++ ) {
					Integer numbers = randGen.nextInt(100);
					randomNums.add(numbers);
				}
				
				for(int i=0; i<sortingTest.size; i++){
					sortingTest.randnumArry[i] = randomNums.get(i).intValue();
				}
				
				if(sortingTest.order.equals("random")) {
					System.out.println("Arrays with " + sortingTest.size + " random integer values");
				}
				else if(sortingTest.order.equals("ascending")) {
					System.out.println("Arrays with " + sortingTest.size + " ascending integer values");
					// using collection to sort the array
					
					Collections.sort(randomNums);
				}
				
				else if(sortingTest.order.equals("descending")) {
					System.out.println("Arrays with " + sortingTest.size + "descending integer values");
					Collections.sort(randomNums, Collections.reverseOrder());
				}
				
				else {
					System.out.println("Invalid order. Ending...");
					System.exit(1);
				}
				
				sortingTest.sortMethod(sortingTest.size, sortingTest.algorithm, sortingTest.randnumArry);
			}
		}
		
		else{
			System.out.println("Didn't meet the required arguments. Ending program");
			System.exit(1);
		}	

		}	
	
	/*
	 * Implemented the sort fucntion from lecture - CPSC 319
	 */
	 
	
	
	public void selectionSort() {
		
														// Number of Operation
		
		int i,j,min;											// 	1 op
																//  
		for (i=0; i<nums.length-1; i++) {						//  n(2-1) op
			for (j = i+1, min = i; j < nums.length; j++) 		// 	n*n(2)
				
				
				if (nums[j] < nums[min]) 						// 	3n ??
					min = j;									// 	1n op 
					
					swap(nums, min, i);							// 	n(7n-3) 
		
	//														-----------------------				
	//															12n^2-2 = O(n^2)
		}
	}
	
	/*
	 * Selection Sort algorithms makes use of tow for loops where one is used to loop through the length of the array
	 * and the other is used to compare the values of which gives it a time complexity of O(n^2) for all cases.
	 */

	/*
	 * Implemented a method to perform the swap operations on the array index
	 * 
	 */
	
	private static void swap (int [] array, int index1, int index2){
        
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
	
	public void insertionSort() {									// Number of Operations
		for (int i = 1, j; i < nums.length; i++) {						// 	2n
			int insertionTemp = nums[i];								// 	2n
			
			for (j = i; j > 0 && insertionTemp < nums[j-1]; j--)		// 	n(2n)
				nums[j] = nums[j-1];									//	n(2n)
			
			nums[j] = insertionTemp;									// 	2n
	//																-----------------------
		}									//							6n + 4n^2 
	}
	/*
	 * Insertion Sort algorithm transverse through an array while making one comparison for each step
	 * With the use of two for loops to create a nested loop, the algorithm has a time complexity of O(n^2)
	 */
	
	
	/*
	 * Implemented code from CPSC 319 Lecture and Tutorial Code written by MD Shoppon
	 * https://www.geeksforgeeks.org/quick-sort/
	 * 
	 */
	public void quickSort(int first, int last) {						// Number of Operations
										
		int lower = first, upper = last;								// 2 ops
		
		int piv = nums[(first+last)/2];									// 2 ops
		
		while (lower <= upper) {										// n+1 ops
			while(nums[lower] < piv) {									// (n+1)/2
				lower++;												// ((n+1)/2)-1
			}
			
			while (nums[upper] > piv) {									// (n+1)/2
				upper--;												// ((n+1)/2)-1
			}
			if (first <= last) {										// 1 op 
				swap(nums,lower,upper);									// 7 op
				lower++;												// 1 op
				upper--;												// 1 op
			}
			
		} 
		
		if(first < upper) {												// 1 op
			quickSort(lower, upper);									// 1 op
		}
		
		if(lower < last) {												// 1 op
			quickSort(lower,last);										// 1 op
		}
																//----------------------------
																// 		3n+19
		
		/*
		 * Quick Sort algorithm works by partioning the array into two segment by choosing a pivot point and 
		 * to the left, the values are less than the pivot and to the right, the values are higher. Since the 
		 * inputs are not sorted in the worst case, it looks through each item and this is a O(n) operation. 
		 * Next step is a recursive action which is a O(lg n)  by calling it self log(n) times which give the 
		 * Quick Sort algorithm a time complexity of O(n*lg n)
		 */
	}
	
	
		
	
	/*
	 * Code Source: https://www.programiz.com/dsa/merge-sort
	 */
	 // Merge two subarrays L and M into arr
	 public void merge(int p, int q, int r) {				// Number of Operations

	    // Create L ← A[p..q] and M ← A[q+1..r]								
	    int n1 = q - p + 1;											// 	1 op
	    int n2 = r - q;												//	1 op

	    int L[] = new int[n1];										// 	1 op
	    int M[] = new int[n2];										// 	1 op

	    for (int i = 0; i < n1; i++)								// 	2n
	      L[i] = nums[p + i];										//	3 op
	    for (int j = 0; j < n2; j++)								// 	2n
	      M[j] = nums[q + 1 + j];									// 	3 op

	    int i, j, k;
	    i = 0;														// 	1 op
	    j = 0;														//	1 op
	    k = p;														// 	1 op

	    while (i < n1 && j < n2) {									// 	3((n+1)/2)
	      if (L[i] <= M[j]) {										// 	3(((n+1)/2)-1))
	        nums[k] = L[i];											//	3((n+1)/2)-1)
	        i++;													// 	(n+1)/2)-1
	      } else {													
	        nums[k] = M[j];											// 	3((n+1)/2)-1)
	        j++;													//	(n+1)/2)-1
	      }
	      k++;														// 	(n+1)/2)-1
	    }

	    while (i < n1) {											// 	(n+1)
	      nums[k] = L[i];											// 	3 op
	      i++;														// 	1 op
	      k++;														// 	1 op
	    }

	    while (j < n2) {											// 	(n+1)
	      nums[k] = M[j];											// 	3 op
	      j++;														// 	1 op
	      k++;														//	1 op
	    }
	  }
	 public void mergeSort( int l, int r) {
	    if (l < r) {												// 1 op

	      // m is the point where the array is divided into two subarrays
	      int m = (l + r) / 2;										// 1 op

	      mergeSort(l, m);											// 1 op
	      mergeSort(m + 1, r);										// 1 op

	      // Merge the sorted subarrays
	      merge(l, m, r);											// 1 op	
	      //												-------------------------------
	      //																=> O(nlog(n))
	    }
	  }
	
	 /*
	  * Merge Sort algorithm works by using a divide and conquer method where the input is repeatedly halved.
	  * It takes O(log(n)) to loop through the array of inputs and half it and since we have n number of items
	  * in the array, the time complexity of the algorithm become O(n*lg(n)) due to the recursive method called
	  * on the items in the array. 
	  */
	
	
	
	
	int [] tempArray;
	int size;
	long startTime;
	long endTime;
	long sortTime;
	String algorithm;
	
	
	public void sortMethod(int numItems, String algoMethod, int [] sortArray) {
		
		this.nums = sortArray;
		
		this.tempArray = new int[size];
		
		// needs a switch statement in order to choose which one to make use of. Javascript
		if(algoMethod.equals("insertion")){
			startTime = System.nanoTime();
			
			insertionSort();
			
			endTime = System.nanoTime();
			
			sortTime = endTime - startTime;
	
			output();
		}
		
		else if(algoMethod.equals("merge")) {
			
			startTime = System.nanoTime();
			
			mergeSort(0, size-1);
	
			endTime = System.nanoTime();
			sortTime =  endTime - startTime;
			
			output();
			
		}
		
		else if(algoMethod.equals("selection")) {
			startTime = System.nanoTime();
			
			selectionSort();
		
			endTime = System.nanoTime();
			//sortTime = endTime - startTime;
			output();
		}
		
		else if(algoMethod.equals("quick")) {
			
			startTime = System.nanoTime();
			
			quickSort(0, size-1);
	
			endTime = System.nanoTime();
			sortTime =  endTime - startTime;
			output();
			
		}
		
		else {
			System.out.println("Invalid Method Selected.");
			System.exit(1);
		}
		
		System.out.println("\nThe "+algorithm+" sorting algorithm took " +sortTime+ " nanoseconds to sort an array of " + size + " integers\n");
	}

	String FileName;
	String order;
	
	public void output() {
		
		PrintWriter print = null;
		
		try {
			
			//Writer fileName;
			print = new PrintWriter(FileName);
			print.print(order + " order of the array with " +size+" integers before getting sorted with " +algorithm+ " sorting algorithm\n");
		
			
			for (int i = 0; i < nums.length; i++) {
				if((i%20)==0 && i!=0) {
					print.print("\n");
				}else {
					print.print(nums[i] + " ");
				}
			}
			
			sortTime =  endTime - startTime;
			print.print("\nThe "+algorithm+" sort algorithm took " +sortTime+ " nanoseconds to sort an array of " + size + " integers\n");
			
			}
			catch(Exception e){
				e.printStackTrace();
				System.out.println("Does not exist.");
			}
			finally{
				
				if(print != null){
					System.out.println("Closing.");
					print.close();
				}
				
				else{
					System.out.println("PrintWriter is not open");
				}
		}	
		
	}
	
	 
	
	
}
