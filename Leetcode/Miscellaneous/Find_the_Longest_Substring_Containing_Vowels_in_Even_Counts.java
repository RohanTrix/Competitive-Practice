/*
    IDEA : Sliding Window WILL NOT WORK for this problem. This is because we can have a vowel towards rightwards 
            of the right pointer that could make a long and even count string, but before that we would have shrinked
            our window.

           A common technique for finding the shortest subarray, count of subarrays or longest subarray with sum
           = 0 can be applied to this problem as well. We will maintain a mask to denote whether the count of
           each vowel is even or odd. Now, we can see that if we have seen the exact mask before, then that means
           and even number of vowels were added after that point j if we are at i right now.

           Since we want the longest subarray, we only store the first occurence of the mask we compute.

*/

public class Find_the_Longest_Substring_Containing_Vowels_in_Even_Counts {
    public int findTheLongestSubstring(String s) {
        int mask = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int ans = 0;
        int i = 0;
        for(char ch : s.toCharArray())
        {
            if("aeiou".contains(""+ch))
                mask^=1<<(ch-'a');
            if(map.containsKey(mask))
                ans = Math.max(ans, i - map.get(mask));
            else
                map.put(mask, i);
            i++;
            //System.out.println(mask);
        }
        return ans;
    }
}
