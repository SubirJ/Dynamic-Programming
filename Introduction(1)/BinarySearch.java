/*
Find the index of a given element in a sorted array using binary search

Input : {2,3,4,5,10,20}, 10
o/p : 4

Input : {1,7,11,20,50,100}, 7
o/p :  2
*/

import java.util.*;

class BinarySearch{
	
	//Time Complexity : O(log n)
	//Auxiliary space / Space Complexity : O(1)
	public static int binarySearch(int arr[], int l, int p, int x){
		
		if(p >= l){
			
			int mid = l + (p - l) / 2;
			
			if(arr[mid] == x)
				return mid;
				
			if(arr[mid] > x)
				return binarySearch(arr, l, mid-1, x);
				
			return binarySearch(arr, mid+1, p, x);
		}
		
		//If no element found
		return -1;
	}

	public static void main(String[] args){
		
		int n = 1;
		int arr[] = {1,2,3,5,6,11,22,50,100};
		Arrays.sort(arr);
		
		Scanner sc = new Scanner(System.in);
		
		while(n > 0){
			System.out.println("Enter the number to find : ");
			n = sc.nextInt();
			
			System.out.println("Index of the given number : "+binarySearch(arr, 0, arr.length - 1, n));
		}	
	}
}