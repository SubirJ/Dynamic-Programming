/*
To check if a number is a power of 2 or not using Bit manipulation

formula : If we subtract 1 from a number which is a power of 2 then all of it's unset bits after the only set bit become set;
		  and the set bit become unset.
		  
		  For example, consider 4 ( Binary representation: 100) and 16(Binary representation: 10000), 
		  we get following after subtracting 1 from them:
		  
		  3 –> 011
		  15 –> 01111
		  
You can clearly see that bitwise-AND(&) of 4 and 3 gives zero, similarly 16 and 15 also gives zero.

So, if a number N is a power of 2 then bitwise-AND(&) of N and N-1 will be zero. 
We can say that N is a power of 2 or not based on the value of N&(N-1).
*/ 

import java.util.*;

class PowerOfTwo{
	
	//this function will take an integer and check if its a power of two or not
	//We use the concept that, if the AND(&) operation of number N and N-1 is 0 then number is a power of two
	public static boolean checkPower(int x){
		return ((x & (x-1)) == 0);
	}
	
	public static void main(String[] args){
			int n = 1;
			
			Scanner sc = new Scanner(System.in);
			
			while(n > 0){
				System.out.println("Enter the number to check if its power of 2 or not");
				n = sc.nextInt();
				
				System.out.println("Result : "+checkPower(n));
				
			}
	}
}