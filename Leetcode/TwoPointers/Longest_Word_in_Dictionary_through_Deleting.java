public class Longest_Word_in_Dictionary_through_Deleting
{
    // Sort the strings to get lexicographical order
    // Check for every string if it is a subsequence of the given string using 2 pointers
    // Take the best answer.
    public String findLongestWord(String s, List<String> dict) {
        Collections.sort(dict);
        int len = -1;
        String finAns = "";
        for(String str: dict)
        {
            boolean f = false;
            int p1=0,p2 = 0;
            while(p2<s.length())
            {
                if(str.charAt(p1)==s.charAt(p2))p1++;
                p2++;
                if(p1==str.length())
                {
                    f = true;
                    break;
                }
            }
            if(f)
            {
                if(str.length()>len)
                {
                    len = str.length();
                    finAns = str;
                }
            }
        }
        return finAns;
    }
}