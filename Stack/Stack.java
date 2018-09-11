import java.util.*;

class ArrayStack {
	
	int arr[];
	int top,max;
	int elem=0;
	
	ArrayStack(int n)
	{
		max=n;
		arr=new int[max];
		top=-1;
	}
	
	void push(int i) {
		
		if(top==max-1)	
			System.out.println("Stack Overflow");
		else
			arr[++top]=i;
	}
	
	void pop() {
		
		if(top==-1)
			System.out.println("Stack Underflow");
		else
			{
				
				elem = arr[top--];
				System.out.println("Popped Element: " + elem);
			}
	}
	
	void display() {
	
		System.out.println("\nSTACK:");
		if(top==-1)
		{
			System.out.println("Stack Underflow #Empty");
			return;
		}
		
		for(int i=top;i>=0;i--)
			System.out.println(arr[i]+"");
		System.out.println();
	}
}

public class Stack
{

	public static void main(String args[]) {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Size of Integer Stack");
		int n=sc.nextInt();
		boolean done=false;
		
		ArrayStack stk = new ArrayStack(n);
		
		do {
		
			System.out.println("\nSTACK OPERATIONS");
			System.out.println("1.PUSH 2.POP 3.DISPLAY 4.EXIT");
			int ch = sc.nextInt();
			switch(ch)
			{
			
				case 1:System.out.println("Enter Integer Element to PUSH");
					  stk.push(sc.nextInt());
					  break;
					 
				case 2:stk.pop();
					   break;
					   
				case 3:stk.display();
					   break;
					   
				case 4:done=true;
					   break;
					   
			   default:System.out.println("Enter a Valid Option");
			   		   break;	   	   	   
			
			}
		
		
		
		}while(!done);
	
	}

}
