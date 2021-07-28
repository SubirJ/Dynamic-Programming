/* 
Bit Manipulation - Simple bit operation tricks
*/

import java.util.*;

class BitOperation{
	public static void main(String[] args){
		int n = 9; //binary  = 1001
		
		//Set a bit at nth position in a number
		//we will set bit at position 2 to make it 13
		//Just left shift "1" to n places and then mask it with given number(9 in our case) with "OR" operator
		//This will give us the required number
		System.out.println(n | (1 << 2));
	}
}