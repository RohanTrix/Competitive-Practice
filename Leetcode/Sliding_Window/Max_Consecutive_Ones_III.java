package Leetcode.Sliding_Window;

class Max_Consecutive_Ones_III {
    //REFER Link : https://youtu.be/QPfalDbqa4A
    public int longestOnes(int[] A, int K) {
        //We only need to take sublists which are having at max k zeros
        //Maxi stores the max length of sublist with atmost k zeros and zeros is the            count of zeros in it
        int maxi = -1, zeros =0;
        
        int n = A.length;
        int begin = 0;
        // Outer loop traverses each element
        for(int end =0;end<n;++end)
        {
            if(A[end]==0) zeros++;
            // If the element we just arrived on is a zero, we increase its                           count
               
            if(zeros>K)// If the no. of zeros increase on coming at i th position
            {
                // Then we leep moving the begin pointer until                                             we get a zero to elimnate from the window or we arrive                                 just before the end pointer
                while(end>begin && A[begin]!=0)
                {
                    ++begin;
                }
                // If the the element at the begin index is a 0, we remove the element                 // from the window
                if(A[begin]==0)
                {
                    begin++;
                    zeros--;
                }
            }
            //We update the max_length if it is smaller than current window
            maxi = Math.max(maxi,end-begin+1);
        }
        return maxi;
    }
}