package Leetcode.TwoPointers;
/*
    IDEA:
        Try to first draw and come up with a 2 pointer approach
        It is obvious that the first partition will start forming from the 1st character.
        And also it will extend to AT LEAST the last occurence of this character. But if some
        other character comes before the last occurence of this character and this other char's
        last occurence lies far away, then the partition window will expand to cover it too.

        Hence we first track the lastPos of every character. While traversing, we update the 
        maxPos( which is basically telling us the current ending of the partion window). If while traversing,
        our right pointer reaches maxPos, means this partition should be added to answer.

*/ 



public class Partition_Labels {
    public List<Integer> partitionLabels(String str) {
        int maxPos = 0;
        Map<Character, Integer> lastPos = new HashMap<>();
        char s[] = str.toCharArray();
        int i = 0;
        for(char ch : s)
            lastPos.put(ch,i++);
        List<Integer> res = new ArrayList<>();
        int left = 0;
        for(int right = 0;right<s.length; right++)
        {
            char ch = s[right];
            maxPos = Math.max(maxPos, lastPos.get(ch));
            if(right==maxPos)
            {
                res.add(right-left+1);
                left = right+1;
            }
        }
        return res;
    }
}
