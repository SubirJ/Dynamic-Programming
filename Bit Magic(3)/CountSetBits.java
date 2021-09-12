/*
Count the number of set bits from 1 to n.

Ex : 
Input: n = 3
1  = 0001
2  = 0010
3  = 0011
Output:  4

Input: n = 6
1  = 0001
2  = 0010
3  = 0011
4  = 0100
5  = 0101
6  = 0110
Output: 9

Solution : 
Suppose we have to find number of set bits from 1 to 11.
0  = 0000
1  = 0001
2  = 0010
3  = 0011
4  = 0100
5  = 0101
6  = 0110
7  = 0111
8  = 1000
9  = 1001
10 = 1010
11 = 1011

Step 1 : Find the highest power of 2 in this list, which is 8 = 2^3
		 Number of set bits from 1 to 7 ie the number just less than the power of 2 number will be
		 2^(3-1) * 3 = 4*3 = 12 
		 General formula, for a number of type 2^x, the number of set bit from 1 to ((2^x) - 1) will be
		 2^(x-1) * x
	
Step 2 : Now we calculate number of set bits for 8 to 11.
		 We calculate all the 1s of the highest place which will be (n- 2^x + 1)
		 which will be (11 - 2^3 + 1) = 11-8+1 = 3+1 = 4  
		 8  = 1 | 000
		 9  = 1 | 001
         10 = 1 | 010
         11 = 1 | 011
			  ^
			  |
		we calculated these bits
		
Step 3 : Now we calculate for the bit positions from 8 to 11 which are less than the highest place ie 3
		 8  = 1 | 000
		 9  = 1 | 001
         10 = 1 | 010
         11 = 1 | 011
			       ^
				   |
		we calculate for these bits now
		
		if you notice they again start for 0 ie 000 = 0
												001 = 1
												010 = 2
												011 = 3	
												
		So we repeat the above solution for that again ie for n - 2^x numbers which will be
		11 - 2^3 = 11-8 = 3
		
		So general formula for above process will be, if we want to find number of set bits from 1 to n
		s(n) = (2^(x-1) * x) + (n - 2^x + 1) + s(n - 2^x)
		
Solution Reference youtube : https://www.youtube.com/watch?v=g6OxU-hRGtY&t=332s
*/

import java.util.*;

class CountSetBits{
	
	//Find the highest power of 2 available from 1 to n
	//Time Complexity
	public static int findPowerOf2(int n){
		int x = 0;
		
		while((1 << x) <= n){
			x++;
		}
		
		return x-1;
	}
	
	//Exceute the solution
	public static int solution(int n){
		if(n == 0)
			return 0;
		
		int x = findPowerOf2(n);
		
		int bitupto2raisex = x * (1 << (x - 1)); //x * 2^(x-1)
		int msbfrom2rxton = n - (1 << x) + 1; // n - 2^x + 1
		int rest = n - (1 << x); //remaining bits from 2^x to n, n - 2^x
		int ans = bitupto2raisex + msbfrom2rxton + solution(rest);
		
		return ans;
	}
	
	public static void main(String[] args){
		int n = 1;

		Scanner sc = new Scanner(System.in);
		
		while(n > 0){
			System.out.println("Enter the number : ");
			n = sc.nextInt();
			
			System.out.println("Number of set bits for 1 to "+n+" are : "+solution(n));
		}
	}
}