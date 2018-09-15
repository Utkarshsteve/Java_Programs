import java.util.*;
public class Kruskal
{

	int n;
	int find(int v, int p[])
	{
	
		while(p[v]!=v)
			v=p[v];
		return v;
	}
	
	void union_ij(int i,int j,int p[])
	{
	
		if(i<j)
			p[j]=i;
		else
			p[i]=j;
	}
	
	void minspantree(int n,int cost[][])
	{
	
		int count,i,min,j,u=0,v=0,k,sum;
		int p[]=new int[10];
		int t[][]=new int[10][10];
		count=1;
		k=1;
		sum=0;
		for(i=1;i<=n;i++)
			p[i]=i;
		while(count<n)
		{
		
			min=999;
			for(i=1;i<=n;i++)
				for(j=1;j<=n;j++)
				{
				
					if(cost[i][j]!=0 && cost[i][j]<min)
					{
						min=cost[i][j];
						u=i;v=j;
						
					}
				
				}
		
		
		if(min==999)
		break;
		i=find(u,p);
		j=find(v,p);
		if(i!=j)
		{
			
			t[k][1]=u;
			t[k][2]=v;
			k++;
			count++;
			sum+=min;
			union_ij(i,j,p);
		
		}
		
		cost[u][v]=cost[v][u]=999;
	}
	
	if(count==n)
	{
	
		System.out.println("Cost of Spanning Tree: "+sum);
		System.out.println("\nSpanning Tree is shown below \n");
		for(k=1;k<=n;k++)
			System.out.print("<"+t[k][1]+","+t[k][2]+">\n");
		return;
	}
	System.out.println("The Spanning tree does not exist for the given graph\n");
}

	public static void main(String[] args)
	{
	
		Kruskal k=new Kruskal();
		int cost[][]=new int[20][20];
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no. of nodes:");
		int n=sc.nextInt();
		System.out.println("\nEnter the cost adjacency matrix:");
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
				cost[i][j]=sc.nextInt();
		
		k.minspantree(n,cost);	
	
	}
}	
