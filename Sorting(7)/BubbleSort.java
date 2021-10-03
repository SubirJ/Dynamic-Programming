/*
Bubble Sort
*/

import java.util.*;

class BubbleSort{

	//The function takes in an array and sorts it using bubbleSort
	//Time Complexity : O(n^2)
	public static void bubbleSort(int[] arr){
		for(int i=0; i < arr.length; i++){
			boolean swapped = false;
			for(int j=0; j < arr.length-i-1; j++){
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swapped = true;
				}	
			}
			if(swapped == false)
				break;
		}
		
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args){
		int[] arr = {10,15,2,22,4,3,11};
		
		bubbleSort(arr);
	}
}