/*
Number is sparse or not
Given a number N. The task is to check whether it is sparse or not. A number is said to be a sparse number 
if no two or more consecutive bits are set in the binary representation.

Example 1:

Input: N = 2
Output: 1
Explanation: Binary Representation of 2 is 10, 
which is not having consecutive set bits. 
So, it is sparse number.
Example 2:

Input: N = 3
Output: 0
Explanation: Binary Representation of 3 is 11, 
which is having consecutive set bits in it. 
So, it is not a sparse number.

Your Task: The task is to complete the function checkSparse() that takes n as a parameter and returns 1 
if the number is sparse else returns 0.

Expected Time Complexity: O(log N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 106
*/

import java.util.*;

class SparseNumber{

	//The function takes input as integer and returns true if the number is Sparse
	public static boolean checkSparse(int n){
		
		//number of bits
		int b = (int)(Math.log10(n) / Math.log10(2));
		
		for(int i=0; i <= b; i++){
			if(((n & (1 << i)) > 0) && ((n & (1 << (i+1))) > 0))
				return false;
		}
		
		return true;
	}

	public static void main(String[] args){
		int n = 1;
		
		Scanner sc = new Scanner(System.in);
		
		while(n > 0){
			System.out.println("Enter the number to check : ");
			n = sc.nextInt();
			
			System.out.println("Sparse or not : " + checkSparse(n));
		}
	}
}