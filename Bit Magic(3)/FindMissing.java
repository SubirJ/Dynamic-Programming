/*
Given an array of n number that has values in range [1 to n+1].
Every number will appear exactly once.
Hence one number is missing. find the missing number.

Input : {1,4,3}
O/p : 2

Input : {1,5,3,2}
O/p : 4 

Constraints : All the elements of an array should be distinct and in range till n+1
*/

class FindMissing{

	//Function to find the missing element from an array of distinct and sequential numbers
	//Time Complexity : O(n)
	//Auxiliary Space / Space Complexity : O(1)
	public static int findMissing(int arr[]){
		int res = 0;
		
		for(int i : arr)
			res = res ^ i;
			
		for(int i=1; i <= (arr.length + 1); i++)
			res = res ^ i;
			
		return res;
	}

	public static void main(String[] args){
		int arr[]  = {1,4,3};
		int arr2[] = {1,5,3,2};
		int arr3[] = {1,2,3,9,8,5,4,7,11,13,6,10}; 
		
		System.out.println("Array Elements : ");
		for(int x : arr)
			System.out.print(x+" ");
		System.out.println("\nMissing element : "+findMissing(arr));
		
		System.out.println("");
		
		System.out.println("Array Elements : ");
		for(int x : arr2)
			System.out.print(x+" ");
		System.out.println("\nMissing element : "+findMissing(arr2));
		
		System.out.println("");
		
		System.out.println("Array Elements : ");
		for(int x : arr3)
			System.out.print(x+" ");
		System.out.println("\nMissing element : "+findMissing(arr3));
	}
}