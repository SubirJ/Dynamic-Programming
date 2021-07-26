/*
Given a positive integer value N. The task is to find how many numbers less than or equal to N have numbers of divisors 
exactly equal to 3.

Input: N = 6
Output: 1
Explanation: The only number less than 6 with 
3 divisors is 4.

Input: N = 10
Output: 2
Explanation: 4 and 9 have 3 divisors.

Time Complexity : less than O(Sqrt(n) * Sqrt(n))
Space Complexity : O(1)
*/

import java.util.*;

class ExactlyThreeFactors{
	
	public static boolean isPrime(int p){
        
		if(p % 2 == 0 || p % 3 == 0)
            return false;
		
        for(int i = 5; i*i <= p; i=i+6){
            if(p % i == 0 || p % (i+2) == 0)
                return false;
        }
        
        return true;
    }
    
    public static int exactly3Divisors(int N)
    {
        //Your code here
        int cnt = 0;
        if(4 <= N)
            cnt++;
        if(9 <= N)
            cnt++;
            
        for(int i=5; i*i <= N; i=i+6){
            if(isPrime(i))
                cnt++;
            if(isPrime(i+2) && (Math.pow(i+2, 2) <= N))
                cnt++;
        }
        
        return cnt;
    }

	public static void main(String[] args){
		int n = 1;
		
		Scanner sc = new Scanner(System.in);
		
		while(n > 0){
			System.out.println("Enter the number : ");
			n = sc.nextInt();
			
			System.out.println("Count of Numbers having exactly 3 factors : ");
			System.out.println(exactly3Divisors(n));
		}
	}
}