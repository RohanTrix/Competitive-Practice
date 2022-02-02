package Leetcode.Miscellaneous;

/*
    We can precompute, for every element i,
        1) the no. of elements lower than ith on left and right
        2) the no. of elements larger than ith on left and right
    
    Then the problem just becomes a counting problem. For every ith element, we try to make it the middle 
    element of the 2 allowed sequences.

        -> For ith being middle of increasing sequence, we want to find ways to combine no. of smaller elements on 
          left with no. of larger elements on right;
          
        -> For ith being middle of decreasing sequence, we want to find ways to combine no. of higher elements on
           left with no. of smaller elements on right

*/


public class Count_Number_of_Teams {
    public int numTeams(int[] rating) {
        int n = rating.length;
        pair lower[] = new pair[n];
        pair higher[] = new pair[n];
        for(int i=0; i<n; i++){lower[i] = new pair(0,0);higher[i] = new pair(0,0);}
        
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(i==j) continue;
                if(j<i)
                {
                    if(rating[j]<rating[i])
                        lower[i].left++;
                    if(rating[j]>rating[i])
                        higher[i].left++;
                }
                else
                {
                    if(rating[j]<rating[i])
                        lower[i].right++;
                    if(rating[j]>rating[i])
                        higher[i].right++;
                }
            }
        }
        int ans = 0;
        for(int i = 1; i<n-1; i++)
        {
            // For increasing sequence, if any of left or right is zero, a triplet cannot be formed
            if(lower[i].left>0 && higher[i].right>0)
               ans+=(lower[i].left*higher[i].right);
            // For decreasing sequence, if any of left or right is zero, a triplet cannot be formed
            if(higher[i].left>0 && lower[i].right>0)
                ans+=(higher[i].left*lower[i].right);
        }
        return ans;
        
    }
    private class pair
    {
        int left, right;
        public pair(int x, int y)
        {
            left = x;
            right = y;
        }
    }
}
