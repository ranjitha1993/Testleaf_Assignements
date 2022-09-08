package assignements.week1;

public class ReverseEvenWords {

	public static void main(String[] args) {
		// ReverseEvenWords
		
		String test = "I am a software tester";
		String test1="";
		String k="";
		String[] split = test.split(" ");
		for(int i=0;i<=split.length-1;i++)
		{			
			if(i%2 !=0)
			{
				//System.out.println(split[i]);
				test1=split[i];
				for(int j=test1.length()-1;j>=0;j--)
				{
					k=k+test1.charAt(j);
					//System.out.println(k);			
				}
				split[i]=k;
				k="";
			}
			
		}
		for(int i=0;i<split.length;i++)
		{
			System.out.print(split[i]+" ");
			
		}
		
	}

}
