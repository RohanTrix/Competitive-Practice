import java.io.*;
import java.util.*;
public class Maximum_sum_increasing_subsequence
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
            sc.close();
        }
}  

class Solution
{
	public int maxSumIS(int arr[], int n)  
	{  
	    int i,j;
	    int trackSum[] = new int[n];
	    for(i=0; i< n;i++)
	    trackSum[i] = arr[i];
	    for(i = 0;i < n; i++)
	    {
	        int currNum = arr[i];
	        
	        for(j = 0; j<i; j++)
	        {
	            if( currNum > arr[j])
	                trackSum[i] = Math.max(trackSum[i],trackSum[j] + arr[i]);
	        }
	    }
	    int maxi = Integer.MIN_VALUE;
	    for(int el : trackSum)
	        maxi = Math.max(maxi, el);
	    return maxi;
	}  
}