public class Stamping_The_Sequence
{
    // REFER : https://youtu.be/2QN_0tfvB_E
    int stampLen, tarLen;
    char stamp[], tar[];
    public boolean check(int start)
    {
        boolean flag = false;
        for(int i = start; i<start+stampLen; i++)
        {
            if(tar[i] == '?')
                continue;
            flag = true;
            if( stamp[i - start] != tar[i])
                return false;
        }
        return flag;
            
    }
    public int[] movesToStamp(String st, String target) {
        
        tar = target.toCharArray();
        stamp = st.toCharArray();
        stampLen = stamp.length;
        tarLen = tar.length;
        
        int remain = tarLen;
        List<Integer> ans = new ArrayList<>();
        
        while(remain>0)
        {
            boolean flag = false;
            
            for(int i = 0; i<tarLen - stampLen +1; i++)
            {
                if(check(i))
                {
                    flag = true;
                    ans.add(i);
                    for(int j = i; j < i+stampLen; j++)
                    {
                        if(tar[j] != '?')
                            remain--;
                        tar[j] = '?';
                    }       
                }
            }
            if(!flag)
                return new int[]{};
            
        }
        int resArr[] = new int[ans.size()];
        int k = ans.size()-1;
        for(int num : ans) resArr[k--] = num;
        return resArr;
    }
}