/* 
Given an integer an N. The task is to return the position of first set bit found from the right side in the binary 
representation of the number.
Note: If there is no set bit in the integer N, then return 0 from the function.  

Input: N = 18
Output: 2
Explanation: Binary representation of 
18 is 010010,the first set bit from the 
right side is at position 2.

Input: N = 12 
Output: 3 
Explanation: Binary representation 
of  12 is 1100, the first set bit 
from the right side is at position 3.

*/

import java.util.*;

class FirstSetBit{

	//Function to find position of first set bit in the given number.
    public static int getFirstSetBit(int n){
            
        // Your code here
        if(n == 0)
			return n;
        
        n = n & ~(n - 1);
        
        int b = (int)(Math.log(n) / Math.log(2)) + 1;
        
        return b;
    }
	
	public static void main(String[] args){
		int n = 0;
		
		Scanner sc = new Scanner(System.in);
		
		while(n > -1){
			System.out.println("Enter the number to find the first set bit of : ");
			n = sc.nextInt();
			
			System.out.println("Position of right most set bit is : "+getFirstSetBit(n));
		}
	}	
}