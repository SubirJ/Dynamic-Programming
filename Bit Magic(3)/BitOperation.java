/* 
Bit Manipulation - Simple bit operation tricks
*/

import java.util.*;

class BitOperation{
	
	//This function takes a number as input and returns its output
	//Ex : if 9 as input then 9 -> 1001 -> 0110 -> 6
	public static int invertBits(int x){
		// calculating number of
		// bits in the number
		int b = (int)(Math.log(x) / Math.log(2)) + 1;
		
		if(b <= 4){
			for(int i=0; i<4; i++)
				x = (x ^ (1 << i));
		}
		else{
			for(int i=0; i < b; i++)
				x = (x ^ (1 << i));
		}
		return x;
	}
	
	//function to find log of an integer to base 2
	public static int log2(int x){
		int res = 0;
		while(x > 1){
			res++;
			x >>= 1;
		}
		
		return res;
	}
	
	public static void main(String[] args){
		int n = 9; //binary  = 1001
		
		//***Note*** : When we say nth position below we start the bit position from 0 just like array index
		//So position 0 means first bit ie the LSB and position 1 means 2nd bit from right to left
		//for ex : 9 -> 1001 so position 0 is 1 and position 1 is 0 and position 2 is 0 and position 3 is again 1
		//From right to left
		
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
		System.out.println("");
		
		//Toggle a bit at nth position
		//We just use XOR(^) operator for it
		//To toggle a bit at nth position, just left shift 1 to n places and XOR it with given number
		//We will toggle bit 3 of number 9(1001) to make it 1(0001)
		//And we will toggle bit 1 of number 9(1001) to make it 11(1011)
		System.out.println("Toggle bit at nth position(bit 3) : "+(n ^ (1 << 3)));
		System.out.println("Toggle bit at nth position(bit 1) : "+(n ^ (1 << 1)));
		System.out.println("");
		
		//To check if a bit is set or unset at a given position
		//Just left shift 1 to n places and then perform AND('&') operation with the given number 
		//If the result of AND is greater than 0 then the bit at nth position is set otherwise if it returns 0 it is unset
		//We will check for number 9(1001), whether bit at 3rd position is set or not, it should return number greater than 0
		//We will check for number 9(1001), whether bit at 2nd position is set or not, it should return 0
		System.out.println("Bit set at nth position?(bit 3) : "+(n & (1 << 3)));
		System.out.println("Bit set at nth position?(bit 2) : "+(n & (1 << 2)));
		System.out.println("");
		
		//Divide by 2
		//We just simply right shift the given number by 1 to get division by 2 or half of it
		//Since each bit represents a power of 2, with each shift we are reducing the value of each bit by a factor of 2
		//which is equivalent to division by 2.
		//We will right shift 9(1001) to get 4(0100)
		//And 18(10010) to get 9(1001)
		System.out.println("Divide by 2(number 9) : "+(n >> 1));
		System.out.println("Divide by 2(number 18) : "+(18 >> 1));
		System.out.println("");
		
		//Multiply by 2
		//Similar to above, we just left shift the number to increase bit value by a factor of 2
		//We will left shift 9(1001) to get 18(10010)
		//And 10(1010) to get 20(10100)
		System.out.println("Multiply by 2(number 9) : "+(n << 1));
		System.out.println("Multiply  by 2(number 10) : "+(10 << 1));
		System.out.println("");
		
		// Log to the base 2 of a number/integer
		//We right shift x repeatedly until it becomes 0, meanwhile we keep count on the shift operation. 
		//This count value is the log2(x).
		//We will calculate log2 of 9 and 64 with our method and also with java inbuilt functions
		//We do not have a direct function for calculating log2 in java but we have Math.log10 function
		//But we have a formula : loga b = log10 b / log10 a
		// So for base 2 we can use : log2 N = log10 N / log10 2
		System.out.println("Log of 9(Our method) : "+(log2(n)));
		System.out.println("Log of 9(Inbuilt function) : "+((int)(Math.log10(n) / Math.log10(2))));
		System.out.println("Log of 8(Our method) : "+(log2(64)));
		System.out.println("Log of 8(Inbuilt function) : "+((int)(Math.log10(64) / Math.log10(2))));
		System.out.println("");
		
		//Flipping the bits of a number
		//It can be done by a simple way, just simply subtract the number from the value obtained 
		//when all the bits are equal to 1.
		//We will flip 23(10111) to get 8(01000), by subtracting it from when all the bits are 1
		//23 has 5 bits and when 5 bits are 1 we get 31(11111) so we subtract 23 from 31 to get 8
		//Similarly to flip 4(0100) , we consider it has 4 bits, and to flip it we need 4 bits of 1 which is 15(1111)
		//So after flipping 0100 we get 1011 which is 11, and we get 15-4 = 11
		//We will also use our invertBits function to check the same
		System.out.println("Flipped number 23(Standard method) : "+(31-23));
		System.out.println("Flipped number 23(Our method) : "+invertBits(23));
		System.out.println("Flipped number 4(Standard method) : "+(15-4));
		System.out.println("Flipped number 4(Our method) : "+invertBits(4));
		System.out.println("");
		
		//Swapping two numbers
		//We can easily swap two number using following :
		//a ^= b;
		//b ^= a; 
		//a ^= b;
		int a = 4, b = 5;
		System.out.println("Before swapping a : "+a);
		System.out.println("Before swapping b : "+b);
		a ^= b;
		b ^= a;
		a ^= b;
		System.out.println("After swapping a : "+a);
		System.out.println("After swapping b : "+b);
		
		//Unsigned right shift
		//The signed right shift (>>) will make positive number negative since java has 32-bit integers
		//it adds 1 as leading bits instead of 0
		//But the unsigned right shift(>>>) treats negative number as positive only by adding 0s as leading bits
		System.out.println("Right Shift(Signed) : "+(-2 >> 1)); //(Right shift -2 with any number of bits will always give -1 as result)
		System.out.println("Right Shift(Signed) : "+(-2 >>> 1)); //this will return a positive number
	}
}

/*
a=4,b=5

   0100	   0101    0001
   0101	   0001	   0100
a =0001  b=0100  a=0101
*/
