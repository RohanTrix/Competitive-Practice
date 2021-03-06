class Solution {
    public int minimumLengthEncoding(String[] words) {
        /* Logic: Put all strings in the set.
        Then remove all strings which are suffixes of any string by taking a substring from ith to end
        Now add the (length of word) +1 (for #) to the answer for each of remaining string
        */
        HashSet<String> hs = new HashSet<String>();
        for(String w: words) hs.add(w);
        for(String w : words) 
        {
            for(int i = 1;i<w.length();i++)
                hs.remove(w.substring(i));
        }
        
        int ans = 0;
        for(String w: hs)
            ans+= (w.length()+1);
        return ans;
    }
}