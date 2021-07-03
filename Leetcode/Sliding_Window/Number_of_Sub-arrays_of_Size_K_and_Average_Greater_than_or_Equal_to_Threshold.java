class Solution {
    public int numOfSubarrays(int[] arr, int k, int thresh) {
        
        int sum = 0, c=0;
        int l = 0;
        for( int i =0 ; i<k; i++) sum+=arr[i];
        if (sum/k>=thresh) c++;
        for(int i =k; i<arr.length; ++i)
        {
            sum-=arr[l++];
            sum+=arr[i];
            if(sum/k>=thresh) c++;
        }
        return c;
    }
}