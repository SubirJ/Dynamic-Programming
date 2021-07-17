/*
Space complexity and auxiliary space for recurrsive functions

Space of recurrsive functions can be calculated.
Following function gives the sum of integers till n.

In the recurrsive function sumOfIntegers we see only one constant which is n but space complexity is not O(1)
becuase we also consider the recurssive call stack.

A memory stack is maintained to note the function calls which will be like:
                   sumOfIntegers(0)
						  |
				   sumOfIntegers(1)
						  |
				   sumOfIntegers(2)
					      |
				   sumOfIntegers(3)
						  |
				   sumOfIntegers(4)
						  |
			       sumOfIntegers(5)

As you can notice function call for 5 will be at the last.
first sumOfIntegers(0) will be resovled giving 0 as output which will add with 1 oof parent call of sumOfIntegers(1) and so on
So we get 0+1+2+3+4+5 = 15

So Auxiliary space or extra space needed for this function will be O(n+1) or just O(n)
*/

class RecurrsiveSpace{
	public static int sumOfIntegers(int n){
		if(n<=0)
			return 0;
			
		return n + sumOfIntegers(n-1);
	}

	public static void main(String[] args){
		int x = 5;
		
		System.out.println(sumOfIntegers(x));
	}
}