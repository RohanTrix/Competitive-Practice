package Leetcode.Miscellaneous;

public class Check_If_Array_Pairs_Are_Divisible_by_k {
    // We first find the remainders mod k for each no. and make a freq map of that. Remember to handle 
    // negative remainers by converting them in the positive space.

    // Next we loop over each key, if the remainder is zero or 2*rem == k, then return false iff it occurs
    // odd no. of times bcuz it can only be paired with itself and all odd cannot be paired together

    // For other keys, just check if the counterpart for this key had same count as key, meaning
    // key's count == (k-key)'s count. If its unequal anywhere, means all keys or (k-key)s cannot be paired
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int n : arr) {
            int r = n%k;
            if (r<0) r+=k;
            hm.put(r, hm.getOrDefault(r, 0)+1);
        }
        for (int key : hm.keySet()) {
            if (key == k - key || key == 0) {
                if (hm.get(key) % 2 != 0) 
                return false;}
            else if (!hm.get(key).equals(hm.getOrDefault(k - key, 0))) // can not use == here, Integer boxed;
                return false;  
        }
        return true;
    }
}
