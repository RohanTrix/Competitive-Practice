public class Simplified_Fractions // O(n^2 * log n)
{
    public int gcd(int a , int b)
    {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        for(int i = 1; i<=n; i++)
        {
            for(int j = 1; j<i; j++)
            {
                if(gcd(i,j) == 1)
                    res.add(j+"/"+i);
            }
        }
        return res;
    }
}