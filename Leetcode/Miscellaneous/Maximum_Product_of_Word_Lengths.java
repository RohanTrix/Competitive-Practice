public class Maximum_Product_of_Word_Lengths
{
    // Save bitmask for each word. Traverse array in n^2...and record the best product of lengths if the bitmasks are disjoint.
    // Checking if bitmasks are disjoint can be done by taking BITWISE AND and checking if it is 0.
    // Also can be done by checking XOR == OR
    public int maxProduct(String[] words) {
        int n = words.length;
        int bits[] = new int[n];
        for(int i = 0; i<n; i++)
        {
            int val = 0;
            for(char ch : words[i].toCharArray())
                val = val|(1<<(ch-'a'));
            bits[i] = val;
        }
        int maxi = 0;
        for(int i = 0; i<n; i++)
            for(int j = 0; j<i; j++)
                if((bits[i]&bits[j]) == 0)
                    maxi = Math.max(maxi, words[i].length() * words[j].length());
        return maxi;
    }
}