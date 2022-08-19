/*
 * # my algorithm
    
    1. iterate over element of array and for each element
    2. check its previous number => check if we have a subsequence ending at prev (if multiple are present,
       pick that one which is of shorter length (use pq for this))
    3. if subsequence ending at prev is not present, add a new subsequence ending at cur of length 1
    4. if subsequence ending at prev is present, remove subsequence ending at prev, and create a new one ending at cur 
       with one more length are length of prev subsequence.
    5. in the end check if all current present subsequences have length more than or equal to 3.
 */

public class Split_Array_into_Consecutive_Subsequences {
    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(int num : nums) 
            map.put(num, new PriorityQueue<>());

        int n = nums.length;
        for(int i = 0; i<n; i++)
        {
            int val = nums[i];
            if(map.containsKey(val - 1) && map.get(val - 1).size() > 0)
            {
                int oldLen = map.get(val-1).poll();
                map.get(val).add(oldLen+1);
            }
            else
                map.get(val).add(1);
        }
        for(int key : map.keySet())
            if(map.get(key).size()>0 && map.get(key).peek() < 3)
                return false;
        return true;
    }
}
