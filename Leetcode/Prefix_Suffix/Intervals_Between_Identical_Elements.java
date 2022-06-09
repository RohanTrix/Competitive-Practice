/* 
        IDEA: We first make a hashmap, mapping each unique element to a list of indicies
              where it is present. When we create this, it will be sorted by nature

              Further explanation in this image: https://anonfiles.com/FclcBe5dx0/1_svg

*/


class Solution {
    public long[] getDistances(int[] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n  =arr.length;
        for(int i= 0; i<n; i++)
        {
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i], list);
        }
        
        long ans[] = new long[n];
        
        for(int k : map.keySet())
        {
            List<Integer> al = map.get(k);
            int len = al.size();
            long pref[] = new long[len+1];
            pref[0] = 0;
            for(int i = 1; i<=len; i++)
                pref[i] = pref[i-1] + (long)al.get(i-1);
            
            //System.out.println(al);
            for(int i = 0; i<len; i++)
            {
                if(i==0)
                {
                    ans[al.get(i)] = (pref[len] -  pref[1]) - ((long)(len-1))*al.get(i);
                    
                    continue;
                }
                else if(i==len-1)
                {
                    
                    ans[al.get(i)] = (((long)len-1)*al.get(i))-pref[len-1];
                    
                    continue;
                }

                // n1*ai
                long a = ((long)i)*al.get(i);
                
                // a1+a2+a3..
                long leftSum = pref[i+1-1];
                
                // n2*ai
                long b = ((long)(len - 1 -i))*al.get(i);
                
                // a6+a7+alen
                long rightSum = pref[len] - pref[i+1];
                
                ans[al.get(i)] = a -leftSum + rightSum -b;
                
            }
            
        }
        return ans;

    }
}