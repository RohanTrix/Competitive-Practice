public class Longest_Arithmetic_Subsequence_of_Given_Difference {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxi = -1;
        for(int num : arr)
        {
            int newLen = 1 + map.getOrDefault(num - difference, 0);
            maxi = Math.max(maxi, newLen);
            map.put(num, newLen);
        }
        return maxi;
    }
}
