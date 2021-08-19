/*
Given two numbers M and N. The task is to find the position of the rightmost different bit in the binary representation of numbers.

Example 1: 

Input: M = 11, N = 9
Output: 2
Explanation: Binary representation of the given 
numbers are: 1011 and 1001, 
2nd bit from right is different.
Example 2:

Input: M = 52, N = 4
Output: 5
Explanation: Binary representation of the given 
numbers are: 110100 and 0100, 
5th-bit from right is different.

Constraints:
0 <= M <= 10^9
0 <= N <= 10^9

If both m and n are the same then return -1 in this case.
*/

import java.util.*;

class RightDifferentBit{

	//Function to find the first position with different bits.
    public static int posOfRightMostDiffBit(int m, int n)
    {
            
        // Your code here     
        if(m == n)
            return -1;
            
        int nbits = (int)(Math.log(n) / Math.log(2)) + 1;
        int mbits = (int)(Math.log(m) / Math.log(2)) + 1;
        
        int b = ((m > n) ? m : n);
        
        for(int i=1 ; i <= b; i++){
            if((m % 2) != (n % 2)){
                return i;
            }
            m = m/2;
            n = n/2;
        }
        
        return 0;
    }

	public static void main(String[] args){
		int m = 0, n = 0;
		
		Scanner sc = new Scanner(System.in);
		
		while((m > -1) && (n > -1)){
			System.out.println("Enter First number : ");
			m = sc.nextInt();
			
			System.out.println("Enter Second Number : ");
			n = sc.nextInt();
			
			System.out.println("Position of the right most different bit is : "+posOfRightMostDiffBit(m,n));
		}
	}
}	