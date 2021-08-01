/*
Given a number N, find the most significant set bit in the given number.

Examples:
Input : N = 10
Output : 8
Binary representation of 10 is 1010
The most significant bit corresponds
to decimal number 8.

Input : N = 18
Output : 16
*/

import java.util.*;

class FindMSB{
	
	//The following function takes integer as an input and returns the value of MSB of the number
	//The most-significant bit in binary representation of a number is the highest ordered bit, 
	//that is it is the bit-position with highest value.
	//We find the bit position of MSB by calculating log to the base 2 of the given number
	//then we use the formula 2^log2(n), where n is the bit position of MSB starting from 0
	public static int findMSB(int x){
		int bit_position = (int)(Math.log10(x) / Math.log10(2));
		
		System.out.println("Bit representation of the number : "+Integer.toBinaryString(x));
		
		return (int)(Math.pow(2, bit_position));
	}
	
	public static void main(String[] args){
		int n = 1;
		
		Scanner sc = new Scanner(System.in);
		
		while(n > 0){
			System.out.println("Enter the number to find the MSB value of : ");
			n = sc.nextInt();
			
			System.out.println("MSB value of given number : "+findMSB(n));
			System.out.println("");
		}
	}
}