import java.util.*;
import java.io.*;
class swip{
public static void swap(int arr[],int i, int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
class sortingmethods{
	void bubblesort(int arr[])
	{
		for(int i=arr.length-1;i>=1;i--)
			for(int j=0;j<i;j++)
				if(arr[j]>arr[j+1])
					 swip.swap(arr,j,j+1);
		
	}
	void selectionsort(int arr[])
	{

		int n=arr.length;
		//for(int i=0;i<n;i++)System.out.println(arr[i]);
		for(int i=0;i<n;i++)
		{
			int mindex=i;
			for(int j=i;j<n;j++)
			{
				if(arr[mindex]>arr[j])
					mindex=j;
			}
			 swip.swap(arr,mindex,i);
		}
		
	}
	void insertionsort(int arr[])
	{
		int n=arr.length;
		for(int i=1;i<n;i++)
		{
			int temp=arr[i],j=i-1;
			for(;j>=0;j--)
			{
				if(temp>arr[j])break;
				arr[j+1]=arr[j];
			}
			arr[j+1]=temp;
		}
		
	}
}

class mergesorter{
	void merge(int[] arr,int l,int r,int m )
	{
		int na=m-l+1,nb=r-m;
		int a[]=new int[na];
		int b[]=new int[nb];

		for(int i=0;i<na;i++)
			a[i]=arr[l+i];

		for(int i=0;i<nb;i++)
			b[i]=arr[i+m+1];

		int i=0,j=0,k=l;

		while(i<na&&j<nb)
		{
			if(a[i]<b[j])
				arr[k++]=a[i++];
			else arr[k++]=b[j++];
		}
		while(i<na)
			arr[k++]=a[i++];
		while(j<nb)
			arr[k++]=b[j++];

	}
	void  mergesort(int arr[],int l,int r)
	{
		int mid= (l+r)/2;
		if(l<r)
		{
			mergesort(arr,l,mid);
			mergesort(arr,mid+1,r);
			merge(arr,l,r,mid);
		}
		
	}
}

class qsrt{
	void quicksort(int arr[],int low,int high)
	{
		if(low<high)
		{
			int pi=partition(arr,low,high);
			// System.out.println( );
			// for(int i:arr)
			// 	System.out.print( i+" ");
			quicksort(arr,low,pi-1);
			quicksort(arr,pi+1,high);
		}
		
	}
	int partition(int arr[],int low,int high)
	{
		int pivot=arr[high];
		int left=low;
		for(int j=low;j<high;j++)
		{
			if(arr[j]<pivot)
			{
				int temp=arr[j];
				arr[j]=arr[left];
				arr[left]=arr[j];
				left++;
			}
		}
		int temp=arr[high];
		arr[high]=arr[left];
		arr[left]=temp;
		return left;	
	}
}
class Hsrt
{
	void heapify(int arr[],int n,int i)
	{
		int l=2*i+1,r=2*i+2,mx=i;
		if(l<n&&arr[mx]<arr[l])
			mx=l;
		if(r<n&&arr[mx]<arr[r])
			mx=r;
		if(mx!=i)
		{
			swip.swap(arr,mx,i);
			heapify(arr,n,mx);
		}
	}
	void heapsort(int arr[])
	{
		int n=arr.length;
		for(int i=n/2-1;i>=0;i--)
			heapify(arr,n,i);
		for(int i=n-1;i>0;i--)
		{
			swip.swap(arr,0,i);
			heapify(arr,i,0);	
		}
		
	}
}
