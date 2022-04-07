/*
    IDEA : Note that the numbers can range only upto 100. We need to build freq arr which is obvious.
           Just make 3 cases:
                1) arr[i] == arr[j] ==  arr[k] (All same)
                2) arr[i] == arr[j] OR arr[i]==arr[k] (2 same, 1 diff)
                3) arr[i] != arr[j] !=  arr[k] (All same)

            After doing this, it just becomes a PnC and 3Sum problem. Follow code to get clarity
            
*/
public class 3Sum_With_Multiplicity
{
    public int threeSumMulti(int[] arr, int target) {
        int mod = (int)1e9+7;
        
        int n = arr.length;
        int freq[] = new int[101];
        for(int i =0; i<n ; i++)
            freq[arr[i]]++;
        
        long cnt = 0;
        // All Same Numbers
        for(int i = 0; i<101; i++)
        {
            int amt = freq[i];
            if(3*i == target)
            {
                cnt+=1L*amt*(amt-1)*(amt-2)/6;
                cnt%=mod;
            }
        }
        
        // Only 2 Same
        
        for(int i = 0; i<101; i++)
        {
            
            for(int j = i+1; j<101; j++)
            {
                int sameAmt = freq[i];
                if(2*i+j == target)
                {
                    cnt+=1L*(sameAmt*(sameAmt-1)/2)*(freq[j]);
                    cnt%=mod;
                }
                sameAmt = freq[j];
                if(2*j+i == target)
                {
                    cnt+=1L*(sameAmt*(sameAmt-1)/2)*(freq[i]);
                    cnt%=mod;
                }
            }
        }
        // All Different
        List<Integer> unique = new ArrayList<>();
        for(int i = 0; i<101; i++)
            if(freq[i]>0) unique.add(i);
        
        
        for(int i = 0; i<unique.size()-2;i++)
        {
            int l = i+1, r = unique.size()-1;
            while(l<r)
            {
                int sum = unique.get(i)+unique.get(l)+unique.get(r);
                if(sum == target)
                {
                    cnt+=1L*freq[unique.get(i)]*freq[unique.get(l)]*freq[unique.get(r)];
                    cnt%=mod;
                    l++;
                    
                }
                else if(sum<target) l++;
                else r--;
            }
        }
        return (int)cnt;
    }
}