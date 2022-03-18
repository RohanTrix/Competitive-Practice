public class Reverse_Integer
{
    // To check overflow, we can just check if the after adding the digit to the end, if
    // we are able to retrieve it back, then no overflow, else yes
    public int reverse(int x) {
        boolean sign = Integer.signum(x) == -1;
        int res = 0; x = Math.abs(x);
        while(x>0)
        {
            res = res*10 + (x%10);
            if(res%10 != x%10) return 0;
            x/=10;
        }
        return sign?-res:res;
    }
}