/*
Selection Sort
*/

import java.util.*;

class SelectionSort{

	//Simple Solution
	//The function takes in an array and sorts it using Selection Sort
	//Time Complexity : O(n^2)
	public static void selectionSort(int[] arr){
		
		int[] temp = new int[arr.length];
		
		for(int i=0; i < arr.length; i++){
			int min_index = 0;
			for(int j=1; j < arr.length; j++){
				if(arr[j] < arr[min_index])
					min_index = j;
			}
			temp[i] = arr[min_index];
			arr[min_index] = Integer.MAX_VALUE;
		}
		
		for(int i=0; i < arr.length; i++){
			arr[i] = temp[i];
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	//Efficient Solution
	//Time Complexity : O(n^2)
	public static void efficientSelectionSort(int[] arr){
		
		for(int i=0; i < arr.length; i++){
			int min_index = i;
			for(int j=i+1; j < arr.length; j++){
				if(arr[j] < arr[min_index]){
					min_index = j;
				}
			}
			int temp = arr[min_index];
			arr[min_index] = arr[i];
			arr[i] = temp;
		}
		
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args){
		int[] arr = {10,15,2,22,4,3,11};
		
		selectionSort(arr);
		efficientSelectionSort(arr);
	}
}