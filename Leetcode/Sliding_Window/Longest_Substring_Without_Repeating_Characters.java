package Leetcode.Sliding_Window;
import java.util.*;
public class Longest_Substring_Without_Repeating_Characters {
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
