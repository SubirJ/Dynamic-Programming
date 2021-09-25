/*
You are given a decimal number N. You need to find the gray code of the number N and convert it into 
decimal. To see how it's done, refer here.

Example 1:

Input: N = 7
Output: 4
Explanation: 7 is represented as 111 in 
binary form. The gray code of 111 is 100, 
in the binary form whose decimal equivalent 
is 4.
Example 2:

Input: N = 10
Output: 15
Explanation: 10 is represented as 1010 in 
binary form. The gray code of 1010 is 1111, 
in the binary form whose decimal equivalent 
is 15.
Example 3:

Input: N = 0
Output: 0
Explanation: Zero is represented as zero 
in binary, gray, and decimal.

Expected Time Complexity: O(1).
Expected Auxiliary Space: O(1).

Constraints:
0 <= N <= 10^9
*/

import java.util.*;

class BinaryToGray{

	//The following function takes the input as integer and returns its gray code
	//Binary to Gray code : 
	//Ex : we have to find gray code of 10(1010)
	//     We have to take MSB as it is and the next bits are calculated by XOR of first bit and the 
	//     bit before
	//     1       0       1       0
	//	   |(MSB)  |(1^0)  |(0^1)  |(1^0)
	//     1       1       1       1
	//In the above example, MSB, which is one is taken as it is, then the next 1 we get through XOR of
	//Left Most bit(MSB) 1 and the next bit which is 0, and 2nd bit of Gray code also we get through XOR 
	//of 3rd bits and 2nd bit and so on.
	//Now we just right shift the given integer so we get 1010 >> 1 = 0101
	//And then we XOR original number with right shifted number to get the Gray code
	//							1 0 1 0
	//                         ^0 1 0 1
	//                         =1 1 1 1 = 15
	//Time Complexity : O(1)
	//Space Complexity : O(1)
	public static int getGrayCode(int n){
	
		return (n ^ (n >> 1));
	}

	public static void main(String[] args){
		int n = 1;
		
		Scanner sc = new Scanner(System.in);
		
		while(n > 0){
			System.out.println("Enter the number to get gray code of : ");
			n = sc.nextInt();
			
			System.out.println("Gray Code : "+getGrayCode(n));
		}
	}
}