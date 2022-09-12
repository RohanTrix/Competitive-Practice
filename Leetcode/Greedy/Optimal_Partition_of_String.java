public class Optimal_Partition_of_String
{
    // IDEA : Using a bitmask to check whether a letter is already present
    //        Greedily extend a partition until u can
    public int partitionString(String str) {
        char s[] = str.toCharArray();
        int cnt = 1;
        int mask = 0;
        for(int i = 0; i<s.length; i++)
        {
            if((mask & (1<<(s[i] - 'a'))) != 0)
            {
                cnt++;
                mask = 0;
            }
            mask|=1<<(s[i] - 'a');
        }
        return cnt;
    }
}