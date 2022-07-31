package Leetcode.Greedy;

/**
 *      REFER Alex Wice Interview Weekly 14
 *      Observations explained in OneNote
 *      Implementation explained below
 * 
 */

public class Check_If_String_Is_Transformable_With_Substring_Sort_Operations {
    public boolean isTransformable(String str, String ttr) {
        char s[] = str.toCharArray();
        char t[] = ttr.toCharArray();
        int n = s.length;
        // i -> List of indices where i appears
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for(int i = 0; i<n; i++)
            map.computeIfAbsent(s[i]-'0', k-> new LinkedList<>()).offer(i);
        
        for(int i = 0; i<n; i++)
        {
            int val = t[i] - '0'; // Value to be brought at this pos
            // If there does not exist a val in the string, return false immediatly
            if( map.getOrDefault(val, new LinkedList<>()).isEmpty() ) return false;
            
            int ind = map.get(val).poll(); // We assume we are trying to bring the first index to the curr pos
            for(int lower = 0; lower<val; lower++) // Checking for the presence of numbers below val
            {
                Queue<Integer> idxs = map.getOrDefault(lower, new LinkedList<>());
                if(!idxs.isEmpty() && idxs.peek() < ind) return false;
                // If a smaller no. is present between i and ind, then we will not be able to swap
                // a curr no.(which is larger) with smaller
            }
        }
        return true;
    }
}
