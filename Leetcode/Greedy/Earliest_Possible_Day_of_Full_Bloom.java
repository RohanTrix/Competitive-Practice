public class Earliest_Possible_Day_of_Full_Bloom
{
    // Sort by Largest growing day since during one's growing days, the planting of another 
    // can take place(be parallized)
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        int plant[][] = new int[n][2];
        for(int i = 0; i<n; i++)
        {
            plant[i][0] = plantTime[i];
            plant[i][1] = growTime[i];
        }
        
        Arrays.sort(plant, (a,b) -> Integer.compare(b[1],a[1]));
        int maxDay = 0;
        int lastEnd = -1;
        for(int p[]:plant)
        {
            lastEnd+=p[0];
            maxDay = Math.max(lastEnd+p[1]+1, maxDay);
        }
        return maxDay;
    }
}