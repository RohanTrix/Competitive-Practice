/**
 *      IDEA : We create a TreeMap of val -> list of labels which have this val. The keys will be sorted in descending order.
 *             Now, we just keep geedily adding elements to the sum until we hit numWanted or elements are over. Also, we maintain a
 *             frequency map used which counts how many times a label is used. This will help when we want to add a val to our subset sum
 *             but we will skip it if we have already used `useLimit` number of labels in our sum.
 */
public class Largest_Values_From_Labels {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>(Collections.reverseOrder());
        for(int i = 0; i<labels.length; i++)
            map.computeIfAbsent(values[i], k->new ArrayList<>()).add(labels[i]);
        
        int sum = 0, cnt = 0;
        int used[] = new int[20000+1];
        outer:
        for(int key : map.keySet())
        {
            List<Integer> list = map.get(key);
            for(int label : list)
            {
                if(used[label]==useLimit) continue;
                if(cnt == numWanted) break outer;
                // System.out.println(key);
                cnt++;
                used[label]++;
                sum+=key;
            }
        }
        return sum;
    }
}
