/* 
Bit Manipulation - Simple bit operation tricks
*/

import java.util.*;

class BitOperation{
	
	//This function takes a number as input and returns its output
	//Ex : if 9 as input then 9 -> 1001 -> 0110 -> 6
	public static int invertBits(int x){
		
		for(int i=0; i<4; i++)
			x = (x ^ (1 << i));
		
		return x;
	}
	
	public static void main(String[] args){
		int n = 9; //binary  = 1001
		
		//Set a bit at nth position in a number
		//we will set bit at position 2 of number 9 to make it 13
		//Just left shift "1" to n places and then mask it with given number(9 in our case) with "OR" operator
		//This will give us the required number
		System.out.println("Set bit at nth position : "+(n | (1 << 2)));
		System.out.println("");
		
		//To unset a bit at nth position in a number
		//We will unset the bit at position 0 of number 9 to make it 8 -> 1000
		//First left shift 1 to n places (1 << n) and then we will invert the given bits to unset that shifted "1"
		//Now after clearing this left shifted '1' ie making it '0' we will AND(&) with the given number, in our case 9.
		//This will unset the bit at nth position
		System.out.println("Unset bit at nth position : "+(n & invertBits(1 << 0)));
		
		
	}
}