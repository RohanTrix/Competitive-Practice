public class Find_Smallest_Common_Element_in_All_Rows
{
    // IDEA : Use a TreeMap to count the occurences
    //        For each row...update the treemap with the unique values of the row
    public int solve(int[][] matrix) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        Set<Integer> ts = new HashSet<>();
        int n = matrix.length;
        for(int row[] : matrix)
        {
            ts.clear();
            for(int num : row)
                ts.add(num);
            for(int num : ts)
                tm.put(num, tm.getOrDefault(num, 0)+1);
        }
        for(int key : tm.keySet())
        {
            if(n == tm.get(key))
                return key;
        }
        return -1;
    }
}