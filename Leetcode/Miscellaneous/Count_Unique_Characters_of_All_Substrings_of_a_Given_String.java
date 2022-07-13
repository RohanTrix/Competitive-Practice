/**
 *      IDEA : Solved in One Go :)
 *             Basically when the question incolves to calculate something over all substrings...we take the contribution
 *             of each char upto the substring it is allowed to extend to. So basically, for every character...we will find
 *             till where can it extend its subarray on both sides until it meets another same character. Now, we have the following
 *             situation in some way:
 *                              
 *                                  |* * * * * i * * * |
 *             
 *             Now, if we have these boundaries, we know that the NO. OF SUBARRAYS PASSING THRU `i` IS
 *             EQUAL TO THE NO. OF SUBARRAYS FOR WHICH i is one of the unique characters.
 *             
 *             Thus, for all such characters, we will find the no. of such subarrays and SUM it up.
 *             
 *             Now, for the NO. of subarrays containing i are:
 * 
 *                                  |* * * * * i * * * |
 *                                   _________   _____
 *                                        5         3          = (5+1)*(3+1)
 */
public class Count_Unique_Characters_of_All_Substrings_of_a_Given_String {
    public int uniqueLetterString(String s) {
        int n = s.length();
        char str[] = s.toCharArray();
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0; i<n; i++)
            map.computeIfAbsent(str[i], k -> new ArrayList<>(List.of(-1))).add(i);
        for(char ch : map.keySet())
            map.get(ch).add(n);
        int sum = 0;
        for(char ch : map.keySet())
        {
            List<Integer> idxs = map.get(ch);
            for(int i = 1; i<idxs.size()-1; i++)
            {
                int left = idxs.get(i) - (idxs.get(i-1)+1);
                int right = (idxs.get(i+1)) - (idxs.get(i)+1);
                sum+=(left+1)*(right+1);
            }
        }
        return sum;
    }
}
