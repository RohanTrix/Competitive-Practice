public class Bulls_and_Cows {
    public String getHint(String secret, String guess) {
        char sec[] = secret.toCharArray();
        int freq[] = new int[10];
        for (char s : sec)
            freq[s - '0']++;
        char g[] = guess.toCharArray();
        int n = g.length;
        int x = 0, y = 0;
        for (int i = 0; i < n; i++)
            if (sec[i] == g[i]) {
                x++;
                freq[g[i] - '0']--;
            }
        for (int i = 0; i < n; i++) {
            if (sec[i] != g[i] && freq[g[i] - '0'] > 0) {
                y++;
                freq[g[i] - '0']--;
            }
        }
        return "" + x + "A" + y + "B";
    }
}
