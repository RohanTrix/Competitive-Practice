// O(n)
import java.util.*;
public class Count_Triplets_That_Can_Form_Two_Arrays_of_Equal_XOR
{
    // REFER Explanation in OneNote
    public int countTriplets(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> count = new HashMap<>(), total = new HashMap<>();
        count.put(0,1);
        total.put(0,-1);
        int currxor = 0, cnt = 0;
        for(int i = 0; i<n; i++)
        {
            currxor^=arr[i];
            cnt+= count.getOrDefault(currxor,0) * (i-1) - (total.getOrDefault(currxor,0));
            count.put(currxor, count.getOrDefault(currxor,0)+1);
            total.put(currxor, total.getOrDefault(currxor,0)+i);
        }
        return cnt;
    }
}

// O(n2)
public class Count_Triplets_That_Can_Form_Two_Arrays_of_Equal_XOR1
{
    // REFER Explanation in OneNote
    public int countTriplets(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.computeIfAbsent(0, k -> new ArrayList<>()).add(-1);
        int currxor = 0, cnt = 0;
        for(int i = 0; i<arr.length; i++)
        {
            currxor^=arr[i];
            if(map.containsKey(currxor))
            {
                for(int idx : map.get(currxor))
                    cnt+=(i - idx - 1);
            }
            map.computeIfAbsent(currxor, k -> new ArrayList<>()).add(i);
        }
        return cnt;
    }
}