public class Best_Sightseeing_Pair {
    public int maxScoreSightseeingPair(int[] values) { // n apporach
        int maxi = 0, n = values.length;
        int maxSoFar = values[0];
        for(int j = 1; j<n; j++)
        {
            int curr = values[j] - j;
            maxi = Math.max(maxi, curr + maxSoFar);
            maxSoFar = Math.max(maxSoFar, values[j] + j);
        }
        return maxi;
    }
    public int maxScoreSightseeingPair1(int[] values) { // n log n Appraoch / Max PQ also usable instead of TreeSet
        int maxi = 0, n = values.length;
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(values[0] + 0);
        for(int j = 1; j<n; j++)
        {
            int curr = values[j] - j;
            maxi = Math.max(maxi, curr + ts.last());
            ts.add(values[j] + j);
        }
        return maxi;
    }
}
