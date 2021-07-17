/*
Recurrence Relation

In recurrsive functions we don't have loops or anything, the function calls itself which cannot be considered as loops.
So for recurrsive functions we calculate something called as recurrence relation.

This is Introduction to recurrence relation
*/

public class RecurrenceRelation{

	public static void func(int n){
		if(n <= 0)
			return ;
		System.out.println("G+G");
		func(n/2);
		func(n/2);
	}
	//For above function we calculate Recurrence Relation as : 
	// T(n)(total recurrence relation) = T(n/2) + T(n/2) + Theta(1)
	// 2 times T(n/2) because function calls itself with n/2, 2 times
	// and Theta(1) because function is performing constant work, it doesn't have any loop or other iterative members
	//So, T(n) = 2T(n/2) + Theta(1), is the Recurrence Relation for above recurrsive function
	//And all this is true when n > 0
	//Beacuse when n < 0, then T(0) = Theta(1) constant work
	
	//Second Example
	public static void func2(int n){
		if(n <= 0)
			return ;
		for(int i=0; i < n; i++)
			System.out.println(i+" G+G");
		func2(n/2);
		func2(n/3);
	}
	//The second function, for n > 0, will have following Recurrence Relation for TC of this function
	// T(n) = T(n/2)+T(n/3)+Theta(n), for the loop with n iterations
	// And T(0) = Theta(1), if n < 0
	
	//Third Example
	public static void func3(int n){
		System.out.println("\n");
		if(n <= 1)
			return ;
		System.out.println("G+G");
		func3(n-1);
	}
	//In above example, Recurrence Relation for TC of this function will be
	//T(n) = T(n-1) + Theta(1)
	//T(1) = Theta(1)
	
	public static void main(String[] args){
		func(5);
		func2(5);
		func3(5);
	}
}

/*
						func(5)
						/     \
					func(2)  func(2)
					 /    \   /   \			
				  func(1) func(1) func(1)
				  
						func2(5)
						/      \
					func2(2)  func2(1)
					/   
				func2(1)  
*/