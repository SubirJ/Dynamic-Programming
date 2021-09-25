/*
Gray to Binary

Given N in Gray Code, find its binary equivalent. 
Return the decimal representation of the binary equivalent.

Example 1:

Input: N = 4
Output: 7
Explanation:
Given 4 representing gray code 110.
Binary equivalent of gray code 110 is 100.
Return 7 representing gray code 100.
Example 2:

Input: N = 15
Output: 10
Explanation:
Given 15 representing gray code 1000.
Binary equivalent of gray code 1000 is 1111.
Return 10 representing gray code 1111 
ie binary 1010.
Example 3:

Input: N = 0
Output: 0
Explanation: 
Zero remains the same in all systems.

Expected Time Complexity: O(log N)
Expected Auxiliary Space: O(1)

Constraints:
0 <= N <= 10^8
*/

import java.util.*;

class GrayToBinary{
	
	//This function takes in an integer as gray code and returns its binary
	//Ex : Find Gray code of 4 
	//It is calculated by taking MSB bit as it is and XOR it with the bit next in line
	//the resultant bit is again XORed with the next bit of the number
	//						 1  0       0
	//                  (MSB)|/ |(1^0) /|(1^0)
	//                       1  1       1     = 7
	// In our solution we will assign the given integer to a temp variable and keep right shifting it 
	// and with every right shift with XOR with original number
	// Step 1 :              100
	//                      ^010
	//                    	 110
	//                      ^001
	//						 111 = 7
	//We do this until temp becomes 0 or less than zero
	//Time Complexity : O(1)
	//Space Complexity : O(1)
	public static int getBinaryCode(int n){
		int temp = n/2;
		
		while(temp > 0){
			 n = n ^ temp;
			 temp = temp / 2;
		}
		
		return n;
	}

	public static void main(String[] args){
		int n = 1;
		
		Scanner sc = new Scanner(System.in);
		
		while(n > 0){
			System.out.println("Enter the get gray code to get the binary of : ");
			n = sc.nextInt();
			
			System.out.println("Binary Code : "+getBinaryCode(n));
		}
	}
}
