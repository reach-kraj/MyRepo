package leetcode;
/*	
	70. Climbing Stairs  
only can climb 1 to 2 steps at a time 
so find the all possible combination available
*/
public class climbingStairs {
	public static void main(String[] args) {
		int n=5;
		int a=1,b=2,c=0;
		int size=n-1;
		if(n==1) {
			c=1;
		}else{
		for(int i=1;i<size;++i)   
		{   
				c=a+b;    
				a=b;    
				b=c;    
			}    
		}
		System.out.print(c);
	}
}
