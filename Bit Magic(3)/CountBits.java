/*
Count the number of set bits of a given number.

number : 7 -> 0111
o/p : 3 (As 3 bits are set

number : 13 -> 1101
o/p : 3

number : 5 -> 101
o/p : 2
*/

import java.util.*;

class CountBits{
	
	//Naive Solution
	//if we have 5(0101), it has 2 set bits so we will check if first bit is set or not and then discard the bit 
	//by moving it to the right. We will check if first bit is set or not by n/2.
	//We will continue this process till the number n becomes zero, if all bits become 000... then number becomes zero.
	//For every set bit we will increment our result.
	public static int countSet(int x){
		
		int res = 0;
		
		while(x > 0){
			res = res + (x & 1); // x & 1, if its odd returns 1 else so our result will increment if its odd
			//Or we can check,
			//if(x % 2 != 0)
			//	res++;
			x = x/2; //to remove the last bit, or we can do x = x >> 1 to remove last bit
		}
		
		return res;
	}
	
	public static void main(String[] args){
		int n = 1;
		
		Scanner sc = new Scanner(System.in);
		
		while(n>0){
			System.out.println("Enter the number : ");
			n = sc.nextInt();
			
			System.out.println("The number of set bits are(naive solution : "+countSet(n));
		}
	}
}