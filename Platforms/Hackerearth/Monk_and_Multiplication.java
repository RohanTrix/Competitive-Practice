package Hackerearth;

import java.util.*;
import java.io.*;
public class Monk_and_Multiplication 
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n  =sc.nextInt();
        long arr[] = new long[n];
        for(int i=0;i<n;i++)
        arr[i]= sc.nextLong();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        if(n<2)
        {
            for(long i: arr){
            System.out.println(-1);}
            return;
        }
        heap.add(arr[0]);
        System.out.println(-1);
        heap.add(arr[1]);
        System.out.println(-1);
        for(int i =2; i<n;i++)
        {
            heap.add(arr[i]);
            if(heap.size()>3)
            heap.poll();
            long a =heap.poll();
            long b = heap.poll();
            System.out.println(a*b*heap.peek());
            heap.add(a);
            heap.add(b);          
        }
        sc.close();
    }
}
   
        