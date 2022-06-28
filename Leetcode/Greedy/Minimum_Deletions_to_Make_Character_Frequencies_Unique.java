public class Minimum_Deletions_to_Make_Character_Frequencies_Unique
{
    // IDEA : https://youtu.be/QvzPHt8ngkg
    class Solution {
    public int minDeletions(String s) {
        int freq[] = new int[26];
        for(char ch : s.toCharArray())
            freq[ch-'a']++;
        Set<Integer> set = new HashSet<>();
        Arrays.sort(freq);
        int moves = 0;
        for(int num : freq)
        {
            if(num == 0)
                continue;
            while(num!=0 && set.contains(num))
            {
                num--;
                moves++;
            }
            set.add(num);            
        }
        return moves;
    }
}
}