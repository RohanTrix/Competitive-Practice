/*
    IDEA : The first simply idea/logic is that we want to place the higher chars before lower chars to make
           lexicographically largest. However, we have a constraint her...that is repeatLimit is the maximum limit of the
           consecutive same characters we have. Hence, we want to place some other char just before we insert the (repeatLimit+1)th
           occurence of the current char. And this should be the 2nd largest char(lexicographically).
           So we can use a Max PriorityQueue which stores a pair(char, occurence cnt).

           The ordering of pq is lexicographical (highest to lowest). 
           We are also given we do not have to use all characters necessaily. Here is an example for that:

           Example : "AAAABBBBCC", limit = 2

                    CC -> CCBB_ -> CCBBA -> CCBBABB -> CCBBABBAA_ 
                    
                    (Since no more char is left to separate the last A from the pervious 2 consecutive A's, we just return whatever
                     was formed uptil now. )

            If not understood, REFER (same idea) : https://youtu.be/NTNqhDA7gts

*/
public class Construct_String_With_Repeat_Limit {
    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        int freq[] = new int[26];
        for(char ch: s.toCharArray())
            freq[ch-'a']++;
        
        for(int i = 0; i<26; i++)
            if(freq[i] != 0)
                pq.offer(new pair((char)(i+'a'), freq[i]));
        StringBuilder str = new StringBuilder();
        while(!pq.isEmpty())
        {
            pair char1 = pq.poll();
            for(int i = 1; i<=char1.cnt; i++)
            {
                str.append(char1.ch);
                if(i%repeatLimit==0 && i!=char1.cnt)
                {
                    if(pq.isEmpty()) return str.toString();
                    pair char2 = pq.poll();
                    str.append(char2.ch);
                    char2.cnt--;
                    if(char2.cnt!=0) pq.offer(char2);
                }
            }
        }
        return str.toString();          
    }
    private class pair implements Comparable<pair>
    {
        char ch; int cnt;
        public pair(char ch_, int cnt_)
        {
            ch = ch_;
            cnt = cnt_;
        }
        public int compareTo(pair p)
        {
            return ch-p.ch;
        }
        public String toString()
        {
            return ch+" "+cnt;
        }
    }
}
