class Solution {
    // IDEA : Removing from beginning or end of a fixed no. of elements...is same as keeping some middle subarray.
    //        Problem is of Finding Min sum fixed sized window of n-k elements
    public int maxScore(int[] cards, int k) {
        int n = cards.length;
        k = n - k;
        int sum = 0, mini = Integer.MAX_VALUE, totSum = 0;
        for(int right = 0; right<n; right++) {
            sum+=cards[right];
            totSum+=cards[right];
            if(right - k>=0) sum-=cards[right - k];
            if(right >= k-1) mini = Math.min(mini, sum);
        }
        return totSum - mini;
    }
}