/*
Find the only odd occuring number from an array.

Input : {4,3,4,4,4,5,5}
O/p : 3

Input : {2,2,5,6,7,7,7,6,8,8,5,3,3}
O/p : 7

Constraint : The array has exactly one odd occurring element
*/

class OddOccurring{
	
	//function finds the odd occuring number from the input array
	//We use the XOR operator for this, XOR has the property that for a number x , x^x = 0
	//So if a number occurs even times then they cancel each other and we get zero
	//If a number occurs odd number of times, then its even occurences cancel each other and we get one remaing occurence
	//Time Complexity : O(n)
	//Auxiliary Space / Space Complexity : O(1)
	public static int findOdd(int arr[]){
		int res = 0;
		
		for(int i=0; i < arr.length; i++){
			res = res ^ arr[i];
		}
		
		return res;
	}
	
	public static void main(String[] args){
		int arr[] = {4,3,4,4,4,5,5};
		int arr2[] = {2,2,5,6,7,7,7,6,8,8,5,3,3};
		
		System.out.println("Array elements :");
		for(int x : arr)
			System.out.print(x+" ");
			
		System.out.println("\nNumber which occurs odd number of times : "+findOdd(arr));
		System.out.println("");
		
		System.out.println("Array elements :");
		for(int x : arr2)
			System.out.print(x+" ");
		System.out.println("\nNumber which occurs odd number of times : "+findOdd(arr2));
	}
}