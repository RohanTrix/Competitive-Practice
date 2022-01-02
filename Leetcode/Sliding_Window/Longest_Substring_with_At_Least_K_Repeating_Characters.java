public class Longest_Substring_with_At_Least_K_Repeating_Characters {

    // REFER: https://youtu.be/eNCYapoYsBw

    // Now, we will use sliding window approach to find the window of biggest
    // length. However, it is not that easy. Imagine, that we have s = aabbb... and
    // k = 3, what should we do when we reached window aabbb: should we expand it to
    // the right hoping that we will meet another a? Or should we start to move left
    // side of our window? One way to handle this problem is to do several sliding
    // windows passes, where we fix num number of different symbols we must have in
    // our substring. So, we check all posible num = 1, ... 26 (if fact, not 26, but
    // max unique chars) and do sliding window pass


    public int longestSubstring(String s, int k) {
        char str[] = s.toCharArray();
        int maxi = 0;
        
        Set<Character> set = new HashSet<>(); // To find the no. of unique chars in string
        for (char ch : str)
            set.add(ch);
        
        int n = set.size(); // No. of unique chars

        // We fix the max number of unique characters allowed in the sliding window
        for (int num = 1; num <= n; num++) {

            // Sliding Window procedure starts
            int left = 0;
            Map<Character, Integer> freq = new HashMap<>(); // Freq of chars in sliding window

            for (int right = 0; right < str.length; right++) {

                // Update the sliding window and add to frequency
                freq.put(str[right], freq.getOrDefault(str[right], 0) + 1);

                // Adjust sliding window to meet max allowance condition
                while (left < right && freq.size() > num) {

                    freq.put(str[left], freq.get(str[left]) - 1); // Remove leftmost element
                    // If element not in window, remove from freq table
                    if (freq.get(str[left]) == 0)
                        freq.remove(str[left]);
                    
                    left++; // Increment left pointer

                }

                // Check if window is valid ( frequency is >= k for every character )
                boolean valid = true;
                for (int v : freq.values()) {
                    if (v < k)
                        valid = false;
                }
                // Update ans if window is valid
                if (valid)
                    maxi = Math.max(right - left + 1, maxi);

            }
        }
        return maxi;
    }
}