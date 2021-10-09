/*
Insertion sort
*/

import java.util.*;

class InsertionSort{

	//The function takes in an array and sorts it using Insertion Sort
	//Time Complexity : O(n^2)
	public static void insertionSort(int[] arr){
		
		for(int i=0; i < arr.length; i++){
			int key = arr[i];
			int j = i-1;
			while((j>=0) && (arr[j] > key)){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
		
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args){
		int[] arr = {55,10,15,2,22,4,3,11};
		
		insertionSort(arr);
	}
}