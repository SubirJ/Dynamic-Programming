// In this code we will see Time Complexity of Common Loops

import java.io.*;
import java.util.*;

class LoopComplexity {	
	public static void main(String[] args){
		int n = 10, c = 2;
		
		// first loop
		// TC : O(n)
		for(int i=0; i<n; i=i+c){ //this loop runs for theta(n)(exact) / O(n) TC because loop runs for approx n/c times
			System.out.println(i+" "+c);
		}

		System.out.println("\n");
		// second loop
		// TC : Theta(n) / O(n)
		for(int i = n; i>0; i=i-c){ //this loop runs for theta(n)(exact) / O(n) TC because loop runs for approx n/c times
			System.out.println(i+" "+c);
		}
		
		System.out.println("\n");
		// Third loop
		// TC : Theta(log n) / O(log n)
		n=33;
		for(int i=1; i<n; i=i*c){
			System.out.println(i+" "+c);
		}
		/*
		Mathematical Explanation of above loop:
		The above loop runs as c^0, c^1, c^2, c^3, ...,c^k-1
		so, we get, c^(k-1) < n
					k-1 < log(n) to the base c
					k < log(n)+1
		so removing constants we get TC as Theta(log n) / O(log n)
		*/
		
		System.out.println("\n");
		// Fourth loop
		// TC : Theta(log n) / O(log n)
		for(int i = n; i>1; i=i/c){
			System.out.println(i+" "+c);
		}
		/*
		Mathematical Explanation of above loop:
		the loop will go as, n/c^1, n/c^2, n/c^3, ......,n/(c^(k-1))
		so, we get, n / c^(k-1) > 1
					n > c^(k-1)
					log n > k-1
					log n + 1 > k				
		so after removing constants we get TC as Theta(log n) / O(log n)
		*/
		
		System.out.println("\n");
		// Fifth loop
		// TC : Theta(log log n) / O(log log n)
		n= 513; c= 3;
		for(int i = 2; i < n ; i = (int)Math.pow(i, c)){
			System.out.println(i+" "+c);
		}
		/*
		Mathematical Explanation of above loop:
		the loop will go as 2, 2^3, (2^(3^))^3,.......
		which is            2^(c^0), 2^(c^1), 2^(c^2), ......, 2^(c^(k-1))
		so we get			2^(c^(k-1)) < n
							c^(k-1) < log n, to the base 2
							k-1 < log log n, to the base c^
							k < log log n + 1
		so after removing constants we get TC as Theta(log log n) / O(log log n)
		*/
    }
}	