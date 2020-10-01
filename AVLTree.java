import java.io.*;
import java.util.*;
public class AVLTree{
	static Node Insert(int arr[],Node root,int i)
	{
		if(i<arr.length)
		{
			root=new Node(arr[i]);	
			root.left=Insert(arr,root.left,i*2);	
			root.right=Insert(arr,root.right,i*2+1);	
		}
		return root;
	}
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n+1];
		for(int i=1;i<n+1;i++)
			arr[i]=sc.nextInt();
		Node root=new Node(0);
		root=Insert(arr,root,1);
		(new travs()).inorder(root);
	}
}
