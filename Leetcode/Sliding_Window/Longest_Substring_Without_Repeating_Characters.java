package Leetcode.Sliding_Window;

import java.util.*;

public class Longest_Substring_Without_Repeating_Characters {

    // IDEA: We maintain a running hashmap which should always have only 1 occurence
    // of each char
    // If we increase our window by s[right], it may be possible that freq of
    // s[right] changes from 1 to 2. Hence we should shrink our window from left
    // until the prev occurence
    // s[right] gets removed and only current occurence remains(i.e freq of [right]
    // again equal to 1)
    public int lengthOfLongestSubstring(String str) {
        int left = 0;
        char s[] = str.toCharArray();
        HashMap<Character, Integer> hm = new HashMap<>();
        int n = str.length();
        int maxi = 0;
        for (int right = 0; right < n; right++) {
            hm.put(s[right], hm.getOrDefault(s[right], 0) + 1);
            while (left < right && hm.get(s[right]) > 1) {
                hm.put(s[left], hm.get(s[left]) - 1);
                if (hm.get(s[left]) == 0)
                    hm.remove(s[left]);
                left++;
            }
            maxi = Math.max(maxi, right - left + 1);
        }
        return maxi;
    }
}

// Using HashSet
class Longest_Substring_Without_Repeating_Characters1 {
    public int lengthOfLongestSubstring(String str) {
        Set<Character> set = new HashSet<>();
        int left = 0, ans = 0;
        char s[] = str.toCharArray();
        for (int right = 0; right < s.length; right++) {
            while (left < right && set.contains(s[right]))
                set.remove(s[left++]);
            set.add(s[right]);
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
