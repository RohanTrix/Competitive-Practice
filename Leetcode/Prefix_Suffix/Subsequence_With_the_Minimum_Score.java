public class Subsequence_With_the_Minimum_Score {
    // Self Explanatory or Watch a Youtube Video
    public int minimumScore(String str, String ttr) {
        char s[] = str.toCharArray(), t[] = ttr.toCharArray();
        int slen = s.length, tlen = t.length;
        int pref[] = new int[slen], suff[] = new int[slen];
        int k = 0;
        // Building pref[] : pref[i] is longest prefix length of t that is a subsequence of s[0...i]
        for(int i = 0; i<slen; i++){
            if(k<tlen && s[i] == t[k])
                k++;
            pref[i] = k;
        }
        k = tlen - 1;
        // Building suff[] : suff[i] is longest suffix length of t that is a subsequence of s[i...slen-1]
        for(int i = slen-1; i>=0; i--){
            if(k>=0 && s[i] == t[k])
                k--;
            suff[i] = tlen - k - 1;
        }
        
        int maxi = Math.max(pref[slen-1], suff[0]);
        for(int i = 0; i<slen-1; i++){
            if(pref[i] + suff[i+1] > tlen) continue; // xxxsubxxxxxsubxxxx   -> in a case like this, adding both pref and suff can be more than tlen which is invalid
            maxi = Math.max(maxi, pref[i] + suff[i+1]);
        }
        return tlen - maxi;
    }
}
