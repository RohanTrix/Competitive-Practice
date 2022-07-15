public class Minimum_Suffix_Flips {
    // Maintain a variable flipped to denote if suffix starting from i is 0s or 1s
    // We first try to change the first character if required...and then if we change, we also change
    // the suffix(which becomes O(1) by just maintaing flipped variable)
    public int minFlips(String target) {
        int n = target.length(), moves = 0;
        char t[] = target.toCharArray();
        boolean flipped = false; // Denotes if suffix starting from i is all zeros or ones
        for(int i = 0; i<n; i++)
        {
            if((t[i] == '1' && !flipped) || (t[i] == '0' && flipped))
            {
                moves++;
                flipped = !flipped;
            }
        }
        return moves;
    }
}
