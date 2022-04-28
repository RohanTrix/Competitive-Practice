/*
    IDEA : First thing I observed was that it does not matter how many heaters cover a particular house.
           So this gives me a search space to find the range for a heater. Now, if we select a range and find out
           that all houses are covered by some heater, then we know that increasing the range will also
           keep the houses covered. So we can try decreasing it and hope to try a smaller range. Hence, this is
           a binary searchable property.

           Greedy Logic for possible() : We loop over the houses and keep a itering variable k for heaters.
                                         If kth heater cannot cover the current house, then we keep going to the next
                                         heater until this condition is true. If at any time, we are out of heaters
                                         to assign to a house, we cannot use this range. Else, we can.



*/
public class Heaters {
    public boolean possible(int range, int houses[], int heaters[])
    {
        int k = 0;
        for(int i = 0; i<houses.length; i++)
        {
            while(Math.abs(heaters[k] - houses[i])>range)
            {
                k++;
                if(k == heaters.length) return false;
            }
        }
        return true;
    }
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int left = 0, right = (int)1e9+1;
        int ans = -1;
        while(left<=right)
        {
            int mid = left + (right - left)/2;
            if(possible(mid, houses, heaters))
            {
                ans = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        return ans;
    }
}
