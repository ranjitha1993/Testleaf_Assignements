package javapractice.assignments;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1="A man, a plan, a canal: Panama";
		
		//Removing the non alphanumeric characters
		str1=str1.replaceAll("[^a-zA-Z0-9]", "");
		
		//Converting the uppercases to lowercase
		str1=str1.toLowerCase();
		
		//Initializing for the checking the reversed string
		String rev="";
		
		//Reversing a String
		for ( int i=str1.length()-1;i>=0;i--)
		{
		rev=rev+str1.charAt(i);
		}
		if(str1.equals(rev))
		{
			System.out.println("The given string is Palindrome");
		}
		else
		{
			System.out.println("The given string is Not Palindrome");
		}

	}

}
