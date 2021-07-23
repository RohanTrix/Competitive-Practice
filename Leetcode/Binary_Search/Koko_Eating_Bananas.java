package Leetcode.Binary_Search;

/*
The idea is to use Binary Search. We assume a capacity(in our case, the mid of binary search) and calculate the
number of hours taken to eat the bananas. If this number is less than the hours we are allowed, then we return True,
else False. This is what possible() does. Our search space for binary search is from 1 banana to highest integer
(Ideally, we should have taken sum of all bananas as the upper bound but there were unnecessary overflow errors).
We calculate mid, then check if it is possible to finish all bananas in h hours with mid bananas per hour. If yes,
then we know that  it is possible to finish all bananas in h hours with mid+1 or mid+2 .... or mid + n bananas per hour.
Thus we need to store the current mid as current best answer and 
check on the left side. If that is not the case, then we need to check on the right side as 
we have to increase the number of bananas per hour.

*/
public class Koko_Eating_Bananas {
    public boolean possible(int[] piles, int cap, int h)
    {
        int hoursPassed = 0;
        for(int el : piles)
        {
            hoursPassed+=(el/cap);
            if( el%cap!=0) hoursPassed++;
        
        }
        //System.out.println(hoursPassed+" "+cap);
        return hoursPassed<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int mod = (int)1e9 +7;
        int low = 1;
        int high = mod-1;

        int bestans = high;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(possible(piles, mid, h))
            {
                bestans = mid;
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return bestans;
    }
}
