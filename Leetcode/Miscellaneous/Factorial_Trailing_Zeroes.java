package Leetcode.Miscellaneous;


// 10 = 2*5
// Since we have many multiples of 2 compared to fives(expand upto any factorial to see this),
// we only need to count 5's we have.
// We first divide by 5...to cnt how many fives we have. Then by 25..to cnt the second 5s in (5*5)
// then by 125..to count third 5s in (5*5*5). 
public class Factorial_Trailing_Zeroes { // log5(n)
    public int trailingZeroes(int n) {
        long fivepow = 5;
        int cnt = 0;
        while(fivepow<=n)
        {
            cnt+=(n/fivepow);
            fivepow*=5;
        }
        return cnt;
    }
}
// 2s,5s in each term of factorial can combine to make 10.
class Factorial_Trailing_Zeroes1 { // n *(log2(n) + log5(n))
    public int trailingZeroes(int n) {
        int two = 0, five = 0;
        for(int i = 2; i<=n; i++)
        {
            int tmp = i;
            while(tmp%2==0){
                tmp/=2;
                two++;
            }
            while(tmp%5==0)
            {
                tmp/=5;
                five++;
            }
        }
        return Math.min(two, five);
    }
}
