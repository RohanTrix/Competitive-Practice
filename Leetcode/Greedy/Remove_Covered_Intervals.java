
// IDEA : Sort the intervals based on the starting index first and then the sizes.
//        By doing this, we are able to process largest interval starting at an index,
//        and skipping the ones that end before this current one ends.

public class Remove_Covered_Intervals {
    public int removeCoveredIntervals(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for(int inter[] : intervals)
            list.add(inter);
        Collections.sort(list, (a,b) -> a[0]-b[0]==0?Integer.compare(b[1] - b[0], a[1]-a[0]):a[0]-b[0]);
        int right = list.get(0)[1];
        int cnt = 1;
        for(int i = 1; i<list.size(); i++)
        {
            int curr_right = list.get(i)[1];
            if(curr_right<=right) continue;
            else
            {
                right = curr_right;
                cnt++;
            }
        }
        return cnt;
    }
}
