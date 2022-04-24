/*
PRE REQUISITE : Be thorough with fastLIS or LIS in nlogn. Code in Java-Competitive repository
    IDEA : STEP 1: The first thing to do to quickly to ease the problem for us is to seperate out the array into multiple lists of elements
           which are k seperated from each other. Since element of once list does not effect the elements of other lists.

           STEP 2: Now we can solve problem to "change minimum elements to make non-decreasing" separately for each list. This is explained
                   here https://youtu.be/HIpZ5Jz0O_g .
                   Refer Algo Zenith and https://youtu.be/nf3YG4CnTbg for LIS in nlogn. Then refer code for longest non-decreasing subseq.
           
           STEP 3: To calculate the Longest Non-Decreasing subsequence length, we need to use a variation of the nlogn LIS.
                   Basically, we need to tweak the the "sol.get(sol.size()-1) < currNum" to "sol.get(sol.size()-1) <= currNum"
                   and find the index of first element greater than the key.

           STEP 4: Finally accumulate the count of elements that didnt have to be changed in each list and return as the answer.
*/
public class Minimum_Operations_to_Make_the_Array_K_Increasing {
    // Longest Non-Decreasing Subsequence
    int fastLNDS(List<Integer> nums){
        List<Integer> sol = new ArrayList<>();
        for(int currNum : nums)
        {
            if(sol.size()==0 || sol.get(sol.size()-1) <= currNum)
            {
                sol.add(currNum);
            }
            else
            {
                int pos = upper_bound_LNDS(sol, currNum);
                sol.set(pos,currNum);
            }
        }
        return sol.size();
    }
    public int upper_bound_LNDS(List<Integer> arr, int key)
    {
        // Largest value less than or equal to key
        int left = 0, right = arr.size()-1;
        int pos = -1;
        while(left<=right)
        {
            int mid = left +(right-left)/2;
            if(arr.get(mid) <= key)
                left = mid + 1;
            else
            {
                pos = mid;
                right = mid -1;
            }
        }
        return pos;
    }
    public int kIncreasing(int[] arr, int k) {
        List<List<Integer>> list = new ArrayList<>();
        int n = arr.length;
        for(int i = 0; i<k; i++)
        {
            List<Integer> tmp = new ArrayList<>();
            for(int j = i; j<n; j+=k)
                tmp.add(arr[j]);
            
            list.add(tmp);
        }
        // System.out.println(list);
        
        int cnt = 0;
        for(int i = 0; i<list.size(); i++)
        {
            int len_of_lnds = fastLNDS(list.get(i));
            cnt+=list.get(i).size() - len_of_lnds;
        }
        
        return cnt;
    }
}
