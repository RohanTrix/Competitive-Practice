/*
        IDEA : We go on every even position and every odd position and build one freq map for each
               Then we will sort keys of the map based on the largest occurence.

               Some cases arise:
               1) If there is only one type of element in both even pos and odd pos:
                    a) If they are same, we will change whichever has lesser elements(eventh or oddth elements)
                    b) Or if both are diff, means best array acheived, ans is 0

               2) The majority element of both are diff. So we make all other eventh elements as even's majority
                  and all oddth elements as odd's majority.
              
               3) The majority element is same in both. Then we have 2 options. either we use 1st majority of 
                   evens and 2nd majority of odds or 1st majority of odds and 2nd majority of evens. Answer is the
                   Minimum of these. Edge cases also to be handled if anyone of them has only one majority
*/
public class Minimum_Operations_to_Make_the_Array_Alternating
{
    public int minimumOperations(int[] nums) {
        HashMap<Integer, Integer> even = new HashMap<>();
        HashMap<Integer, Integer> odd = new HashMap<>();
        if(nums.length==1) return 0;
        for(int i = 0; i<nums.length ; i+=2)
            even.put(nums[i], even.getOrDefault(nums[i], 0) + 1);
        for(int i = 1; i<nums.length ; i+=2)
            odd.put(nums[i], odd.getOrDefault(nums[i], 0) + 1);
        
        int eveCnt = (int)Math.ceil(1.0*nums.length/2);
        int oddCnt = nums.length/2;
        List<Integer> evenKeys = new ArrayList<>(even.keySet());
        List<Integer> oddKeys = new ArrayList<>(odd.keySet());
        Collections.sort(evenKeys, (b,a) -> even.get(a) - even.get(b));
        Collections.sort(oddKeys, (b,a) -> odd.get(a) - odd.get(b));
        int ans = 0;
        
        if(evenKeys.size() == 1 && oddKeys.size() == 1)
        {
            if(evenKeys.get(0)==oddKeys.get(0)) return Math.min(eveCnt, oddCnt);
            else return 0;
        }
        else if(evenKeys.get(0) != oddKeys.get(0))
        {
            int moves1 = eveCnt-even.get(evenKeys.get(0));
            int moves2 = oddCnt-odd.get(oddKeys.get(0));
            ans = moves1+moves2;
        }
        else
        {
            if(evenKeys.size() ==1)
                ans = oddCnt-odd.get(oddKeys.get(1));
            else if(oddKeys.size() == 1)
                ans = eveCnt-even.get(evenKeys.get(1));
            else
            {
                int ans1 = (eveCnt-even.get(evenKeys.get(0))) + (oddCnt-odd.get(oddKeys.get(1)));
                int ans2 = (eveCnt-even.get(evenKeys.get(1))) + (oddCnt-odd.get(oddKeys.get(0)));
                ans = Math.min(ans1, ans2);
            }
        }
        return ans;
    }
}