/*
    IDEA : The first step is to build a map which maps value to list
           of indices where this value is present.

           Now for each value, their corresponding lists are in sorted form....and hence binary searchable.
           In query function, we search the for the sorted position of left and right, and count the number
           indices that fall in this range. If any boundary is -1, then no index lies in the queried interval.
 */
public class Range_Frequency_Queries
{
    Map<Integer, List<Integer>> map;
    public RangeFreqQuery(int[] arr) {
        map = new HashMap<>();
        for(int i = 0; i<arr.length; i++)
            map.computeIfAbsent(arr[i], key -> new ArrayList<>()).add(i);
    }
    public int query(int left, int right, int value) {
        List<Integer> list = map.computeIfAbsent(value, key -> new ArrayList<>());
        int l = 0, r = list.size()-1;
        int ans1 = -1, ans2 = -1;
        while(l<=r)
        {
            int mid = (l+r)/2;
            if(list.get(mid)>=left)
            {
                ans1 = mid;
                r = mid - 1;
            }
            else
                l = mid + 1;
        }
        l = 0; r = list.size()-1;
        while(l<=r)
        {
            int mid = (l+r)/2;
            if(list.get(mid)<=right)
            {
                ans2 = mid;
                l = mid + 1;
            }
            else
                r = mid - 1;
        }
        if(ans1 == -1 || ans2 == -1) return 0;
        return ans2 - ans1 + 1;
    }
}