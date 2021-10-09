/*
Merge Sort
*/

import java.util.*;

class MergeSort{

	//this function merges the two array
	//Time Complexity : Theta(n) / O(n)
	//Auxiliary Space : O(n)
	public static void merge(int[] a, int low, int mid, int high){
		
		int n1 = mid - low + 1;
		int n2 = high - mid;
		
		int[] left = new int[n1];
		int[] right = new int[n2];
		
		for(int i=0; i < n1; i++){
			left[i] = a[low+i];
		}
		for(int i=0; i < n2; i++){
			right[i] = a[mid+i+1];
		}
		
		int i=0,j=0,k=low;
		
		while((i < left.length) && (j < right.length)){
			if(left[i] <= right[j]){
				a[k] = left[i];
				i++;
				k++;
			}
			else{
				a[k] = right[j];
				j++;
				k++;
			}
		}
		while(i < left.length){
			a[k] = left[i];
			i++;
			k++;
		}
		while(j < right.length){
			a[k] = right[j];
			j++;
			k++;
		}
	}

	//The function takes in an array and sorts it using Merge Sort
	//Time Complexity : O(n^2)
	public static void mergeSort(int[] arr, int l, int r){
		
		if(r > l){
			int m = l + (r-l) / 2;
			mergeSort(arr, l, m);
			mergeSort(arr, m+1, r);
			merge(arr, l, m, r);
		}
	}

	public static void main(String[] args){
		int[] a = {12, 11, 13, 5, 13, 6, 7};
		
		mergeSort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
	}
}