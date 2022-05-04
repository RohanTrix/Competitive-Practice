/*
    IDEA : The lengths of both the arrays can go uptil 10^4 which means that they both cannot be
           traversed in a O(n^2) fashion. The key observation in this problem is that, for every string
           in words1 to be a valid answer, it needs to have each of its character's frequency more than 
           all the words in words2. So if we store only the max char freq across all the strings in word2,
           then in O(26*words1.length) we can find which words will be added to final result.

           By storing maxfreq, we ensure that if for any char in any word, the cnt of it in a word from words1
           is lesser than maxfreq of this char, then we cannot consider this string.
*/

public class Word_Subsets
{
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int maxfreq2[] = new int[26];
        for(String word : words2)
        {
            int freq[] = new int[26];
            for(char ch : word.toCharArray())
                freq[ch-'a']++;
            for(int i = 0; i<26; i++)
                maxfreq2[i] = Math.max(maxfreq2[i], freq[i]);
        }
        List<String> list = new ArrayList<>();
        for(String word : words1)
        {
            int freq[] = new int[26];
            for(char ch : word.toCharArray())
                freq[ch-'a']++;
            boolean b = true;
            for(int i = 0; i<26; i++)
                if(freq[i]<maxfreq2[i])
                    b = false;
            if(b) list.add(word);
        }
        return list;
    }
}