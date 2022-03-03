public class XOR_Queries_of_a_Subarray {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int pref[] = new int[n+1];
        
        for(int i = 1; i<=n; i++) pref[i] = pref[i-1]^arr[i-1];
        
        int ans[] = new int[queries.length];
        for(int i = 0; i<queries.length; i++)
        {
            int l = queries[i][0] + 1;
            int r = queries[i][1] + 1;
            ans[i] = pref[r] ^ pref[l-1];
        }
        return ans;
    }
}
