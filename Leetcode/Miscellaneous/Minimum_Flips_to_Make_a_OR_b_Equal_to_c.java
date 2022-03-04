public class Minimum_Flips_to_Make_a_OR_b_Equal_to_c {
    public int minFlips(int a, int b, int c) {
        int cnt = 0;
        for(int i = 0; i<31; i++)
        {
            int c_bit = (c & (1<<i))!=0?1:0;
            int b_bit = (b & (1<<i))!=0?1:0;
            int a_bit = (a & (1<<i))!=0?1:0;
            if(c_bit == 0)
                cnt+=a_bit+b_bit;
            else 
                cnt+=(a_bit + b_bit > 0)?0:1;
        }
        return cnt;
    }
}
