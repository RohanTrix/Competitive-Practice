package Leetcode.Greedy;

/**
 *          IDEA : Solved by myself :)
 *                 Refer OneNote for explanation       
 */

public class Permutation_Sequence {
    int ans[], fact[];
    public void permute(int ind, int n,int k, int mask, int permCnt)
    {
        if(ind == n) return;
        
        for(int curr = 1; curr<=n; curr++)
        {
            if((mask&(1<<curr))!=0) 
                continue;
            if(permCnt+fact[n-(ind+1)] < k){
                permCnt+=fact[n-(ind+1)];
                continue;
            }
            ans[ind] = curr;
            mask = mask|(1<<curr);
            permute(ind+1,n, k, mask, permCnt);
            return;
        }
    }
    public String getPermutation(int n, int k) {
        ans = new int[n];

        fact = new int[10];
        fact[0] = 1;
        for(int i = 1; i<10; i++) 
            fact[i] = i*fact[i-1];
        permute(0,n,k,0,0);

        StringBuilder str = new StringBuilder();
        for(int num : ans) str.append(Integer.toString(num));
        return str.toString();
    }
}
