import java.util.Scanner;

public class Hamiltonian
{

	boolean found=false;
	int G[][];
	int x[];
	int n;
	
	public static void main(String args[])
	{
	
		Hamiltonian hamiltonian=new Hamiltonian();
		hamiltonian.getData();
		System.out.println("\nSolution:");
		hamiltonian.HamiltonianMethod(2);
		hamiltonian.printNoSln();
	}
	
	public void printNoSln() {
		
		if(found==false)
			System.out.println("No Solution Possible");
	
	}
	
	public void getData() {
	
		Scanner sc=new Scanner(System.in);
		System.out.println("\t\t\tHAMILTONIAN CYCLE");
		System.out.print("\nEnter the number of vertices:");
		n=sc.nextInt();
		G=new int[n+1][n+1];
		x=new int[n+1];
		System.out.print("\nIf edge between the following vertices enter 1 else 0:\n");
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
			{
				
				if((i!=j)&&(i<j))
				{
				
					System.out.print(i+ "and" +j+":");
					G[j][i]=G[i][j]=sc.nextInt();
				
				}
				
				if(i==j)
					G[i][j]=0;
			
			}
			for(int i=1;i<=n;i++)
				x[i]=0;
			x[1]=1;
			
			sc.close();
		}
		
		void HamiltonianMethod(int k)
		{
		
			while(true)
			{
			
				NextValue(k,G,x,n);
				if(x[k]==0)
					return;
				if(k==n)
				{
				
					for(int i=1;i<=k;i++)
						System.out.print(x[i]+" ");
					System.out.println(x[1]);
					System.out.println();
					found=true;
					return;
				}
				
				else
					HamiltonianMethod(k+1);
			}
		
	 }
	 
	 void NextValue(int k,int G[][],int x[],int n) {
	 
	 	while(true)
	 	{
	 	
	 		x[k]=(x[k]+1)%(n+1);
	 		if(x[k]==0)
	 			return;
	 		if(G[x[k-1]][x[k]]!=0)
	 		{
	 			int j;
	 			for(j=1;j<k;j++);
	 				if(x[k]==x[j])
	 					break;
	 					
	 			if(j==k)
	 				if((k<n)||((k==n)&&G[x[n]][x[1]]!=0))
	 					return;
	 		}
	 	}
	 }
}
