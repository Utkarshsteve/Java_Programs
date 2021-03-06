import java.util.Scanner;

public class SumOfSubSet {

	final static int MAX=10;
	static int n;
	static int S[];
	static int soln[];
	static int d;
	
	public static void main(String args[])
	{
	
		S=new int[MAX];
		soln=new int[MAX];
		int sum=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of elements:");
		n=sc.nextInt();
		
		System.out.println("Enter the set in increasing order:");
		for(int i=1;i<=n;i++)
			S[i]=sc.nextInt();
		System.out.println("Enter the max. subset value(d):");
		d=sc.nextInt();
		for(int i=1;i<=n;i++)
			sum=sum+S[i];
		if(sum<d || S[1]>d)
			System.out.println("No Subset Possible");
		else
			SumOfSub(0,0,sum);
		sc.close();
	}
	
	static void SumOfSub(int i,int weight, int total)
	{
	
		if(promising(i,weight,total)==true)
		if(weight==d)
		{
		
			for(int j=1;j<=i;j++)
			{
			
				if(soln[j]==1)
					System.out.print(S[j]+" ");
			
			}
			System.out.println();
		
		}
		
		else
		{
		
			soln[i+1]=1;
			SumOfSub(i+1,weight+S[i+1],total-S[i+1]);
			soln[i+1]=0;
			SumOfSub(i+1,weight,total-S[i+1]);
		
		}
	
	}
	
	static boolean promising(int i,int weight,int total) {
		return((weight+total>=d)&&(weight==d || weight+S[i+1]<=d));
	}
}
