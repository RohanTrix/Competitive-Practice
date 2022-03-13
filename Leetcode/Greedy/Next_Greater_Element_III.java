/*
    IDEA : Problem is very similar to next permutation. Here the
           array will the digits of the number. And then we need to find
           the next permutation(so check that solution out).
           When reforming the ans, we also have to check where the answer
           is within 32 bit integer limit. For that we can find the answer in
           long and then chekc whether its more than INTMAX or not. 
*/
public class Next_Greater_Element_III {
    public int nextGreaterElement(int n) {
        int infpt = 0;
        int digs[] = new int[Integer.toString(n).length()];
        int p = 0;
        for(char ch : Integer.toString(n).toCharArray())
            digs[p++] = ch-'0';
        
        int pos = 0;
        
        for(int i = digs.length - 1; i >0; i--)
        {
            if(digs[i] > digs[i-1])
            {
                pos = i;
                break;
            }
        }
        if(pos == 0) return -1;
        for(int i = digs.length-1; i>=pos; i--)
        {
            //System.out.println(digs[i]);
            if(digs[i]>digs[pos-1])
            {
                int tmp = digs[i];
                digs[i] = digs[pos-1];
                digs[pos-1] = tmp;
                break;
            }

        }

        int start = pos, end = digs.length-1;
        while(start<end)
        {
            int tmp = digs[start];
            digs[start] = digs[end];
            digs[end] = tmp;
            start++;
            end--;
        }
        long ans = 0;
        for(int i = 0; i<digs.length; i++)
            ans = ans*10+ digs[i];
        if(ans>Integer.MAX_VALUE) return -1;
        return (int)ans;
    }
}
