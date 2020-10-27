import java.util.*;
import java.io.*;
public class Monk_and_Multiplication 
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n  =sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        arr[i]= sc.nextInt();
        long prod=1;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i =0; i<n;i++)
        {
            if(i<3)
            {
                prod = prod * arr[i];
                if(i==2)
                System.out.println(prod);
                else{
                System.out.println(-1);
                heap.add(arr[i]);
                
                }
                
                continue;
            }
            heap.add(arr[i]);
            if(heap.peek()<arr[i])
            {
                long temp =heap.poll();
                prod = (prod * arr[i])/temp;
                System.out.println(prod);
            }
            else
            {
                heap.poll();
                System.out.println(prod);
            }
            
        }
    }
}
   
        