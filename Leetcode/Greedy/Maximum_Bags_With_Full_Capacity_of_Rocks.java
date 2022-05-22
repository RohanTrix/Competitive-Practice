public class Maximum_Bags_With_Full_Capacity_of_Rocks
{
    // REFER : Pick greedily least difference
    public int maximumBags(int[] capacity, int[] rocks, int extra) {
        List<Integer> list = new ArrayList<>();
        int n = rocks.length;
        for(int i = 0; i<n; i++)
        {
            list.add(capacity[i] - rocks[i]);
        }
        Collections.sort(list);
        int cnt = 0;
        for(int diff : list)
        {
            if(diff<=extra)
            {
                extra-=diff;
                cnt++;
            }
            
        }
        return cnt;
    }
}