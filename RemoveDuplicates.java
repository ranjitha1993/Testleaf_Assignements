package assignements.week1;


public class RemoveDuplicates {

	public static void main(String[] args) {
		// RemoveDuplicates
		
		String text = "We learn java basics as part of java sessions in java week1";
		text= text.toLowerCase();
		int count=0;
		String[] split = text.split(" ");
		// System.out.println(Arrays.toString(split));
		for (int i=0;i<=split.length-1;i++)
		{
			for (int j=i+1;j<=split.length-1;j++)
			{
				if (split[i].equals(split[j]))
				{
					count++;
					split[j]="";
					
				}
			}
			if(count>=0 && split[i]!="")
			{
				System.out.print(" "+split[i]);
			}
			
		}
			
	}
}

