/**
 *     IDEA : We first build a freq map of letters present in the string t. The reason for this is...that this is a minimum requirement
 *            that we should fulfil to make our substring a valid one. So basically if the
 *                  1) Value of a letter is >0  ---> We need to add include more such letters to decrease its frequency to 0
 *                  2) Value of a letter is <=0 ---> It means that this letter occurs required or more than required number of times.
 *            
 *            Now we use our sliding window approach since the shortest substring is asked. We also need to store
 *            the left and right indexes of the shortest valid substring we find so that later on we can simply return a substring
 *            of that.
 *            At every position `right`, we decrease the letter's freq in our hashmap if that letter was already a key in hashmap.
 *            I do this since I only care about the presence of chars which are a part of my string t also(ignoring the extra ones).
 * 
 *            Next, after including `right` char everytime, we check whether all the freqs of the chars in map are <=0. If it is...then we know
 *            we have all the required chars or maybe more than we need...and also some other chars which are not even present in t.
 *            
 *            So this tells us we need to reduce our string. We record the length of the curr bounds if they make a better minimum and we remove
 *            the char present on `left`. To remove the char, we basically increase its freq in the map. And we only do this if the key was already
 *            present in the map(for the same reason that I only care abt chars of String t).
 */

public class Minimum_Window_Substring {
    public String minWindow(String s, String t) {
        char str[] = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : t.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0)+1);
        int left = 0;
        int mini = str.length+1, l_ans = -1, r_ans = -1;
        for(int right = 0; right<str.length; right++)
        {
            if(map.containsKey(str[right]))
                map.put(str[right], map.get(str[right])-1);
            while(left<=right && isEmpty(map))
            {
                if(right - left + 1 < mini)
                {
                    l_ans = left;
                    r_ans = right;
                    mini = right-left+1;
                }
                if(map.containsKey(str[left]))
                    map.put(str[left], map.get(str[left])+1);
                left++;
            }
        }
        return mini == str.length+1?"":s.substring(l_ans, r_ans+1);
    }
    public boolean isEmpty(Map<Character, Integer> map)
    {
        for(char k : map.keySet())
            if(map.get(k)>0) return false;
        return true;
    }
}
