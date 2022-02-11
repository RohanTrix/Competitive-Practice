/*
    IDEA : To check if one string is a permutation of another, we always go for a hashmap and do
           a frequency check. Now, this problem simply becomes checking for permutation for every substring
           of size str1. We use a fixed sliding window approach with a hashmap.

           1) Fill the hashmap as a freq map for str1
           2) For chars in each window, decrease the count in the hashmap. By doing this...whenever we find a
              permutation of the string, the hashmap elements wud have cancelled themselves and hashmap size wud
              be 0.

*/
public class Permutation_in_String
{
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        char str1[] = s1.toCharArray();
        char str2[] = s2.toCharArray();
        int len = str1.length;
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i<str1.length; i++)
            hm.put(str1[i], hm.getOrDefault(str1[i], 0) + 1);
        
        for(int i = 0; i<str1.length; i++)
        {
            hm.put(str2[i], hm.getOrDefault(str2[i], 0) -1);
            if(hm.get(str2[i]) == 0) hm.remove(str2[i]);
        }
        if(hm.size() == 0) return true;
        boolean ans = false;

        for(int right = str1.length; right<str2.length; right++)
        {
            int left = right-str1.length;
            hm.put(str2[right], hm.getOrDefault(str2[right], 0) -1);
            hm.put(str2[left], hm.getOrDefault(str2[left], 0)+1);
            if(hm.getOrDefault(str2[right], 0) == 0) hm.remove(str2[right]);
            if(hm.getOrDefault(str2[left], 0) == 0) hm.remove(str2[left]);
            ans = ans || hm.isEmpty();
        }
        return ans;
    }
}