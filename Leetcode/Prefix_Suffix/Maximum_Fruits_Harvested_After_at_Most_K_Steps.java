/*
        IDEA : Explained in OneNote
        Corner cases while implementing are explained below
*/

public class Maximum_Fruits_Harvested_After_at_Most_K_Steps {
    int limit = 5*100000; // This is the max size of the garden.
    int pref[] = new int[limit+1]; // Prefix Sum array
    public int getSum(int l, int r) // Function to get sum of range[l,r]
    {
        if(l<=0)return pref[r];
        return pref[r] - pref[l-1];
    }
    public int maxTotalFruits(int[][] fruits, int start, int k) {
        int arr[] = new int[limit+1];
        // We created an array with fuits filled at respective positions
        for(int[] a: fruits)
            arr[a[0]]+=a[1];
        
        // Calculate Prefix Sum
        pref[0] = arr[0];
        for(int i =1;i<=limit;i++)
            pref[i] = pref[i-1]+arr[i];
        
        int maxi = 0; // Storing final result

        // We check for every right step we take, what is the answer we get
        // We don't need to worry about crossing the right boundary due to constraints of the problem
        // right denotes the no. of steps towards right from startPos
        for(int right = 0; right<=k; right++)
        {
            // left denotes the no. of steps towards left from startPos
            // If (k-2*right)<0, it means that we do not have sufficient steps to cross the startPos
            // when going towards left. 
            // In that case, we don't go towards left or go as much as we can(but don't gain anything extra)
            int left = Math.max(0,k-2*right);
            // Take prefix sum of leftmost pos we reached to rightmost pos reached.
            maxi = Math.max(maxi, getSum(start-left,start+right));
        }
        
        // Same logic for left as we did for right
        // We need to take care that while taking `left` steps towards left, we
        // don't cross 0 on number line as prefix sum starts at 0 index. S0 max left steps we go is
        // uptil 0th position
        for(int left = 0; left<=k&&(start-left)>=0; left++)
        {
            int right = Math.max(0, k-2*left);
            // Take prefix sum of leftmost pos we reached to rightmost pos reached.
            maxi = Math.max(maxi, getSum(start-left, start+right));
        }
        return maxi;
    }
}
