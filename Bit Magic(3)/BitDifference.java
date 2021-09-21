/*
You are given two numbers A and B. The task is to count the number of bits needed to be flipped to convert A to B.

Example 1:

Input: A = 10, B = 20
Output: 4
Explanation:
A  = 01010
B  = 10100
As we can see, the bits of A that need 
to be flipped are 01010. If we flip 
these bits, we get 10100, which is B.

Example 2:

Input: A = 20, B = 25
Output: 3
Explanation:
A  = 10100
B  = 11001
As we can see, the bits of A that need 
to be flipped are 10100. If we flip 
these bits, we get 11001, which is B.

Expected Time Complexity: O(log N).
Expected Auxiliary Space: O(1).
*/

import java.util.*;

class BitDifference{

	//The function takes two integers as input, given number and the target number 
	//and returns number of bits to be converted in base number to get the target number
	//Time Complexity : O(log N)
	//Space Complexity/Auxiliary Space : O(1)
	public static int countBitsFlip(int a, int b){
        
        int res = 0;
        
        // Your code here
        while(((b > a) ? b : a) > 0){
            if((b % 2) != (a % 2))
                res += 1;
            b = b / 2;
            a = a / 2;
        }
        
        return res;
    }

	public static void main(String[] args){
		int a = 1, b = 1;
		
		Scanner sc = new Scanner(System.in);
		
		while(b > 0){
			System.out.println("Enter the numbers : ");
			a = sc.nextInt();
			b = sc.nextInt();
			
			System.out.println("Bit Difference is : "+countBitsFlip(a,b));
		}
	}
}