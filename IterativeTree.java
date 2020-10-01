import java.util.*;
import java.io.*;
class CreateTree{
	static Node Create(int arr[],Node root,int i)
	{
		if(i<arr.length)
		{
			root=new Node(arr[i]);	
			root.left=Insert(arr,root.left,i*2);	
			root.right=Insert(arr,root.right,i*2+1);	
		}
		return root;
	}
}
class Node{
	Node left,right;
	int val,height;
	Node(int v)
	{
		this.val=v;
		this.height=1;
		this.left=null;
		this.right=null;
	}
}
class MyPair{
	Node s;
	int state;
	MyPair(Node a,int st)
	{
		this.s=a;
		this.state=st;
	}
}
class travs
{
	void postorder(Node x)
	{
		Stack<MyPair> st= new Stack<>();
		st.push(new MyPair(x,0));	
		while(!st.isEmpty())
		{
			MyPair top=st.pop();
			if(top.state==3||top.s==null)continue;
			st.push(new MyPair(top.s,top.state+1));
			if(top.state==0)st.push(new MyPair(top.s.left,0));
			else if(top.state==1)st.push(new MyPair(top.s.right,0));
			else if(top.state==2)System.out.print(top.s.val+" ");
		}
	}
	void inorder(Node x)
	{
		Stack<MyPair> st= new Stack<>();
		st.push(new MyPair(x,0));	
		while(!st.isEmpty())
		{
			MyPair top=st.pop();
			if(top.state==3||top.s==null)continue;
			st.push(new MyPair(top.s,top.state+1));
			if(top.state==0)st.push(new MyPair(top.s.left,0));
			else if(top.state==2)st.push(new MyPair(top.s.right,0));
			else if(top.state==1)System.out.print(top.s.val+" ");
		}
	}

	void preorder(Node x)
	{
		Stack<MyPair> st= new Stack<>();
		st.push(new MyPair(x,0));	
		while(!st.isEmpty())
		{
			MyPair top=st.pop();
			if(top.state==3||top.s==null)continue;
			st.push(new MyPair(top.s,top.state+1));
			if(top.state==1)st.push(new MyPair(top.s.left,0));
			else if(top.state==2)st.push(new MyPair(top.s.right,0));
			else if(top.state==0)System.out.print(top.s.val+" ");
		}
	}

}
public class IterativeTree{
	public static void main(String args[])
	{
		int n;
		Scanner sc=new Scanner(System.in);
		travs tp=new travs();
		System.out.println("Enter number of elements in tree.");
		n=sc.nextInt();
		int arr[]=new int[n+1];
		System.out.println("Enter elements in level order fashion");
		for(int i=1;i<=n;i++)	
			arr[i]=sc.nextInt();
		//travs tp=new travs();
		// tp.postorder(x);
		// System.out.println( );
		// tp.inorder(x);
		// System.out.println( );
		// tp.preorder(x);
	}
}
