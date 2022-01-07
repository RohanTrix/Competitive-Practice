package Hackerearth;

import java.util.*;
public class Minimum_indexes

{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int arr[] = new int[n];
        int digs[] = new int[n];
        for(int i=0;i<n;i++)
        {
            int s=0;
            arr[i] = sc.nextInt();
            int copy = arr[i];
            while(copy> 0)
            {
                int d = copy%10;
                s +=d;
                copy = copy/(int)10;
            }
            digs[i] = s;
        }
        //System.out.println(Arrays.toString(arr));
        //System.out.println(Arrays.toString(digs));
        int ans[] = new int[n];
        Arrays.fill(ans, -1);
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1; j<n; j++)
            if(( digs[i] > digs[j]) && arr[i] < arr[j]){
                ans[i] = j+1;
                break;
            }
        }
        //System.out.println(Arrays.toString(ans));
        for(int i=0;i<q;i++)
        System.out.println(ans[sc.nextInt()-1]);
        sc.close();
    }
}
