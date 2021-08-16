/*
Extension of OddOccuring problem. Given an array we have to find 2 odd Occurring numbers in an array

Input : {3,4,3,4,5,4,4,6,7,7}
O/p : 5 6

Input : {20,15,20,18}
O/p : 15 18

Constraint : The array has exactly 2 odd occurring number
*/

class TwoOddOccurring{

	//Naive Solution
	//function to find 2 odd occurring numbers in an array
	//Time Complexity : O(n^2)
	//Auxiliary Space / Space complexity : O(1)
	public static void find2Odd(int arr[]){
		for(int i=0; i < arr.length; i++){
			int count = 0;
			
			for(int j=0; j < arr.length; j++){
				if(arr[i] == arr[j])
					count++;
			}
			
			if(count % 2 != 0)
				System.out.print(arr[i]+" ");
		}
	}
	
	//Efficient solution
	/*
	Explanation : 
	For ex : consider array {3,4,3,4,8,4,4,32,7,7}
			Step 1 : We perform XOR of all elements as previous one odd occurring number problem
			Step 2 : from above example, all even occurring numbers cancel each other and we get result as 8^32 = 40
			Now we have to find individual number for the XOR ie 8 and 32
			Step 3 : We know, 8^32 = 40 -> 0....0001000
										  ^0....0100000
										  =0....0101000 = 40
										  
					But as we can see, if we consider XOR operation and the right most set bit, the bit is set only when
					opposite pairs of 0 and 1 are there, So in one number that bit is set and in another its not
					
			Step 4 : So considering this we find the right most set bit of resultant XOR using formula : result & ~(result-1),
					 this formula gives us only the right most set bit of the number. For 40, we get result as 0....001000 = 8
					 and using this bit we divide the elements of the array into two groups, one group of numbers in which this
					 bit is set and another group in which its not.
					 We do it by performing AND operation of right most bit number(which is 8) with the array element, if the 
					 bit is set in that number then we get result as something greater than zero, if not set, we get result as 
					 zero
			Step 5 : So as per above example we get two groups as, bit set: {8} and bit not set : {3,4,3,4,4,4,32,7,7}
					  And now we perform two separte XOR operation of elements of these 2 groups
					  XOR of first group will give 8 and XOR of second will give 32
	*/
	//Time Complexity : O(n)
	//Auxiliary Space / Space Complexity : O(1)
	public static void oddAppearing(int arr[]){
		int XOR = 0, res1 = 0, res2 = 0;
		
		for(int i=0; i < arr.length; i++){
			XOR = XOR ^ arr[i];
		}
		
		int rn = XOR & ~(XOR-1); //This will give the rightmost set bit only
		
		for(int i=0; i < arr.length; i++){
			if((arr[i] & rn) != 0)
				res1 = res1 ^ arr[i];
			else
				res2 = res2 ^ arr[i];
		}
		
		System.out.println(res1+" "+res2);
	}
	
	public static void main(String[] args){
		int arr[]  = {3,4,3,4,5,4,4,6,7,7};
		int arr2[] = {20,15,20,18};

		System.out.println("Array Elements : ");
		for(int i : arr)
			System.out.print(i+" ");
		System.out.println("\nOdd Occurring numbers(Naive Solution) : ");
		find2Odd(arr);
		
		System.out.println("\n");
		
		System.out.println("Array Elements : ");
		for(int i : arr2)
			System.out.print(i+" ");
		System.out.println("\nOdd Occurring numbers(Naive Solution) : ");
		find2Odd(arr2);
		
		System.out.println("\n");
		
		System.out.println("Array Elements : ");
		for(int i : arr)
			System.out.print(i+" ");
		System.out.println("\nOdd Occurring numbers(efficient solution) : ");
		oddAppearing(arr);
		
		System.out.println("\n");
		
		System.out.println("Array Elements : ");
		for(int i : arr2)
			System.out.print(i+" ");
		System.out.println("\nOdd Occurring numbers(efficient solution) : ");
		oddAppearing(arr2);
	}
}