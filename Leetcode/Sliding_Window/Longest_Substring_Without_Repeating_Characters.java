package Leetcode.Sliding_Window;
import java.util.*;

public class Longest_Substring_Without_Repeating_Characters
{

    // IDEA: We maintain a running hashmap which should always have only 1 occurence of each char
    // If we increase our window by s[right], it may be possible that freq of
    // s[right] changes from 1 to 2. Hence we should shrink our window from left until the prev occurence
    // s[right] gets removed and only current occurence remains(i.e freq of [right] again equal to 1)
    public int lengthOfLongestSubstring(String str) {
        int left = 0;
        char s[] = str.toCharArray();
        HashMap<Character, Integer> hm = new HashMap<>();
        int n = str.length();
        int maxi = 0;
        for(int right = 0; right<n; right++)
        {
            hm.put(s[right], hm.getOrDefault(s[right],0)+1);
            while(left<right && hm.get(s[right])>1)
            {
                hm.put(s[left], hm.get(s[left])-1);
                if(hm.get(s[left]) == 0) hm.remove(s[left]);
                left++;
            }
            maxi = Math.max(maxi, right-left+1);
        }
        return maxi;
    }
}

// Using HashSet
public class Longest_Substring_Without_Repeating_Characters1 {
    public int lengthOfLongestSubstring(String s) {
        int begin = 0, maxi  =-1;
        if(s.equals("")) return 0;
        HashSet<Character> hs = new HashSet<Character>();
        char ch[] = s.toCharArray();
        for(int end =0;end<ch.length;end++)
        {
            if(!hs.contains(ch[end]))
            {
                hs.add(ch[end]);
            }
            else
            {
                while(end>begin && ch[begin]!=ch[end])
                {
                    hs.remove(ch[begin]);
                    begin++;
                    
                }
                if(ch[begin]==ch[end])
                {
                    begin++;
                }
            }
            maxi = Math.max(maxi, hs.size());
            //System.out.println(begin+" "+end+" "+maxi);
        }
        return maxi;
            
    }
}
