/*

Given an unsigned integer N. The task is to swap all odd bits with even bits. For example, if the given 
number is 23 (00010111), it should be converted to 43(00101011). Here, every even position bit is swapped
with adjacent bit on the right side(even position bits are highlighted in the binary representation of 23),
and every odd position bit is swapped with an adjacent on the left side.

Example 1:

Input: N = 23
Output: 43
Explanation: 
Binary representation of the given number 
is 00010111 after swapping 
00101011 = 43 in decimal.
Example 2:

Input: N = 2
Output: 1
Explanation: 
Binary representation of the given number 
is 10 after swapping 01 = 1 in decimal.

Expected Time Complexity: O(1).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 10^9

*/

import java.util.*;

class SwapOddEven{

	//Following function takes input as an integer, swaps the odd bits with even bits and return the 
	//result
	//For this problem we will be making use of the masks
	//Follow the given steps
	//For ex : Swapping bits of 23 -> 00010111
	//Step 1 : create a mask as 1010101010 as required
	//		   And perform Logical AND operation with it
	//		   		00010111
	//         	   &10101010
	//				00000010 ->  This will preserve all your Even bits and make odd bits disappear
	//Step 2 : create another mask as 0101010101 again as required And perform above operation again
	// 		        00010111
	//			   &01010101
	//				00010101 -> This will preserve all your odd bits and unset the even bits
	//Step 3 : Now we will Right shift the even preserved number or bits
	//		   And we will left shift the odd preserved bits
	//		   And take the Logical OR of the two
    //             00000001 -> right shifted even bits preserved sequence
	//			  |00101010 -> left shifted odd bits preserved sequence
	//			   00101011 -> So this gives us 43 which the required sequence
	//Note : To create a mask of 10101010.... and 01010101.... we use hexadecimal notations or values
	//		 for 10101010... we use int even_mask = 0xAAAAAAAA and int odd_mask = 0x55555555
	//       where each A = 1010 which is 10 in hexadecimal and 5 = 0101
	public static int swapBits(int n){
		int odd_mask  = 0x55555555;
		int even_mask = 0xAAAAAAAA;

		int odds = (n & odd_mask);
		int evens = (n & even_mask);
		
		odds <<= 1;
		evens >>= 1;
		
		n = odds | evens;
		
		return n;
	}

	public static void main(String[] args){
		int n = 1;
		
		Scanner sc = new Scanner(System.in);
		
		while(n > 0){
			System.out.println("Enter the number : ");
			n = sc.nextInt();
			
			System.out.println("After Swapping odd bits with even bits : "+swapBits(n));
		}
	}
}