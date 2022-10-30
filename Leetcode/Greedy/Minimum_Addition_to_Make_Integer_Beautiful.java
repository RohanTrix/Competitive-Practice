public class Minimum_Addition_to_Make_Integer_Beautiful {
    // REFER for logic: https://youtu.be/JXMj2XrfDFw
    public long makeIntegerBeautiful(long n, int target) {
        List<Integer> num = new ArrayList<>();
        int orgsum = 0;
        for(char dig : String.valueOf(n).toCharArray())
        {
            orgsum+=(dig - '0');
            num.add(dig - '0');
        }
        Collections.reverse(num);
        if(orgsum<=target) return 0;
        List<Integer> x = new ArrayList<>();
        for(int i = 0; i<num.size(); i++)
        {
            
            int dig = num.get(i);
            if(dig == 0)
                x.add(0);
            else
            {
                x.add(10 - dig);
                int carry = 1;
                for(int j = i+1; j<num.size(); j++)
                {
                    int d = num.get(j);
                    d = d+carry;
                    num.set(j, d%10);
                    carry = d/10;
                }
            }
            int sum = 0;
            for(int j = i+1; j<num.size(); j++)
                sum+=num.get(j);
            if(sum <= target)
                break;
        }
        Collections.reverse(x);
        long ans = 0;
        for(int dig : x)
            ans = ans*10 + dig;
        return ans;
    }
}
