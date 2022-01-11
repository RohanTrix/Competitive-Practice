/*
        IDEA: Since there are only 22 powers of 2, we basically have to find the number of pairs
              that sum up to x, x being a power of 2.
              We iterate on the numbers one by one. Inside that, we iterate over all powers of 2.
              For each power of 2, now the problem is basically
              finding count of pairs with sum= power of 2. 
              After we count that using hashmap, we can add this element for the next elements to come.
*/

public class Count_Good_Meals {
    int mod = 1000_000_000+7;
    public int countPairs(int[] delic) {
        Map<Integer, Integer> map = new HashMap();
        
        int cnt = 0;
        
        for(int num : delic)
        {
            int power = 1;
            for(int i=0; i<=21; i++)
            {
                if(map.containsKey(power-num))
                {
                    cnt+=map.get(power-num);
                    cnt%=mod;
                }
                power*=2;
            }
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        return cnt;
    }
}
