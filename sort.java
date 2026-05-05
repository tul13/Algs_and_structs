import java.util.*;
import java.lang.*;
import java.io.*;

class MySort
{
	static void bubble(int[] arr)
	{
		for(int i = 0; i < arr.length-1; i++)
		{
		    for(int j = 0; j < arr.length-i-1; j++)
		    {
		        if(arr[j] > arr[j+1])
		        {
		            int t = arr[j];
		            arr[j] = arr[j+1];
		            arr[j+1] = t;
		        }
		    }
		}
	}
	
	static void quick(int[] arr,int low,int high)
	{
	    if(low < high)
	    {
	        int pivot = arr[high];
	        int i = low - 1;
	        
	        for(int j = low; j < high; j++)
	        {
	            if(arr[j] <= pivot)
	            {
	                i++;
	                int temp = arr[i];
	                arr[i] = arr[j];
	                arr[j] = temp;
	            }
	        }
	        
	        int temp = arr[i+1];
	        arr[i+1] = arr[high];
	        arr[high] = temp;
	        
	        int pivotIndex = i+1;
	        
	        quick(arr,low,pivotIndex-1);
	        quick(arr,pivotIndex+1,high);
	    }
	}
	    
	    
	public static void main(String[] args)
	{
	     int n = 10000;
	     int[] arr = new Random().ints(n,0,10000).toArray();
	       
	     int[] a1 = arr.clone();
	     long t1 = System.currentTimeMillis();
	     bubble(a1);
	     t1 = System.currentTimeMillis() - t1;
	       
	     int[] a2 = arr.clone();
	     long t2 = System.currentTimeMillis();
	     quick(a2,0,n-1);
	     t2 = System.currentTimeMillis() - t2;
	       
	     System.out.println("Пузырьковая: "+t1+" мс");
	     System.out.println("Быстрая сортировка: "+t2+" мс");
	     System.out.println("Разница: в "+(t1/t2)+" раз");
	 }
}
