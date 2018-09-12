import java.util.Scanner;

class KObject {			//Knapsack Object Details

	float w;
	float p;
	float r;
}

public class KnapsackGreedy
{

	static final int MAX=20;		//Maximum no. of objects
	static int n;					//no. of objects
	static float M;					//capacity of Knapsack

    public static void main(String args[]) {
    
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter no. of Objects:");
    	n=sc.nextInt();
    	KObject[] obj =new KObject[n];
    	for(int i=0;i<n;i++)
    		obj[i]=new KObject();		//allocate memory for members
    		
     	ReadObjects(obj);
     	Knapsack(obj);
     	sc.close();
    
    
    }
    
    static void ReadObjects(KObject obj[])
    {
    
    	KObject temp=new KObject();
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the max capacity of knapsack:");
    	M=sc.nextFloat();
    	
    	System.out.println("Enter weights:");
    	for(int i=0;i<n;i++)
    		obj[i].w=sc.nextFloat();
    		
    	System.out.println("Enter Profits:");
    	for(int i=0;i<n;i++)
    		obj[i].p=sc.nextFloat();
    	
    	for(int i=0;i<n;i++)
    		obj[i].r=obj[i].p/obj[i].w;
    		
    	//sort objects in descending order, based on p/w ratio
    	for(int i=0;i<n-1;i++)
    		for(int j=0;j<n-1-i;j++)
    			if(obj[j].r<obj[j+1].r)
    			{
    			
    				temp=obj[j];
    				obj[j]=obj[j+1];
    				obj[j+1]=temp;
    			
    			}
    	sc.close();
    
    }
    
    static void Knapsack(KObject kobj[])
    {
    
    	float x[] = new float[MAX];
    	float tp=0;
    	int i;
    	float U;		//U place holder for M
    	U=M;
    	
    	for(i=0;i<n;i++)
    		x[i]=0;
    	for(i=0;i<n;i++)
    	{
    	
    		if(kobj[i].w>U)
    			break;
    			
    		else
    		{
    		
    			x[i]=1;
    			tp=tp+kobj[i].p;
    			U=U-kobj[i].w;
    		
    		
    		}	
    	
    	}
    	System.out.println("i= "+i);
    	if(i<n)
    		x[i]=U/kobj[i].w;
    	tp=tp+(x[i]*kobj[i].p);
    	System.out.println("The Solution Vector, x[]:");
    	for(i=0;i<n;i++)
    		System.out.println(x[i]+"");
    	System.out.println("\n Total Profit is = "+tp);
     }	
	
}

