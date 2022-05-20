package Leetcode.Miscellaneous;

// Greedily Remove Highest power of three that can be removed. If at the end, remaining number!=0, then not a power of 3
public class Check_if_Number_is_a_Sum_of_Powers_of_Three {
    public boolean checkPowersOfThree(int n) {
        int pow = (int) Math.ceil((Math.log(n) / Math.log(3)));
        pow = (int)Math.pow(3,pow);
        while(pow>0)
        {
            if(pow<=n)
                n-=pow;
            pow/=3;
        }
        return n == 0;
        
    }
}
