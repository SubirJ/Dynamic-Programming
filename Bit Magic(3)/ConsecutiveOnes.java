/*
Given a number N. Find the length of the longest consecutive 1s in its binary representation.

Example 1:

Input: N = 14
Output: 3
Explanation: 
Binary representation of 14 is 
1110, in which 111 is the longest 
consecutive set bits of length is 3.
Example 2:

Input: N = 222
Output: 4
Explanation: 
Binary representation of 222 is 
11011110, in which 1111 is the 
longest consecutive set bits of length 4. 

new
*/

import java.util.*;

class ConsecutiveOnes{
	
	//Following function will take an integer as input and return the number of longest string of 
	//consecutive 1s in its bit representation
	//Time Complexity : O(Log N)
	//Space Complexity / Auxiliary Space : O(1)
	public static int maxConsecutiveOnes(int N) {
        
        // Your code here
        int res = 0, temp = 0;
        
        while(N > 0){
            if((N % 2) == 0){
                    temp = 0;
            }
            else{
                temp++;
                if(temp > res)
                    res = temp;
            }
            N = N / 2;
        }
        
        return res;
    }

	public static void main(String[] args){
		int n = 1;
		
		Scanner sc = new Scanner(System.in);
		
		while(n > 0){
			System.out.println("Enter the number to check : ");
			n = sc.nextInt();
			
			System.out.println("Highest number of consecutive 1s are : " + maxConsecutiveOnes(n));
		}
	}
}