package Leetcode.Miscellaneous;

public class Sequential_Digits {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> valid = new ArrayList<>();
        for(int d =1; d<=9; d++)
        {
            String s = "";
            String ones = "";
            for(int i =1;i<=d; i++)s+=(char)(i+48);
            for(int i = 1;i<=d; i++)ones+=(char)(49);
            
            int num = Integer.valueOf(s);
            int addones = Integer.valueOf(ones);
            while(true)
            {
                if(low<=num && num<=high)
                    valid.add(num);
                num+=addones;
                if(num%10==0) break;
            }
            
        }
        return valid;
    }
}
