package week1.day1;

public class Prime {

	public static void main(String[] args) {
		// Primenumber or not 
		
		int n=21;
		int count =0;
		if (n<=1)
			count++;
		for (int i=1;i<=n;i++)
		{
			if(n %i == 0) {
				count++;
			}
		}
		if (count==2)
			System.out.println("The number is primenumber");
		else
			System.out.println("The number is not primenumber");

	}

}
