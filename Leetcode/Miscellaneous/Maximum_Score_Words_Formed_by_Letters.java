/*
    IDEA: We keep a running hashmap in DFS, from which we decrese the chars if we are including the word
          in our answer (only if it is possible). If we include a word, we remove the freq of its 
          chars from running hashmap. Else, we will not update hashmap and call dfs for next index
*/
public class Maximum_Score_Words_Formed_by_Letters
{
    int maxi = 0;
    public void dfs(int ind, int currScore, String words[], int score[], Map<Character, Integer> hm)
    {
        if(ind==words.length)
        {
            maxi = Math.max(maxi, currScore);
            return;
        }
        boolean f = true;
        int sc = 0;
        Map<Character, Integer> currmp = new HashMap<>(hm);
        for(char c: words[ind].toCharArray())
        {
            int cnt = currmp.getOrDefault(c,0);
            if(cnt==0){f = false; break;}
            currmp.put(c, currmp.get(c)-1);
            sc+=score[c-'a'];
        }
        if(f)dfs(ind+1, currScore+sc, words, score, currmp);
        dfs(ind+1, currScore, words, score, hm);
    }
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        Map<Character, Integer> hm = new HashMap<>();
        for(char c: letters)
            hm.put(c, hm.getOrDefault(c, 0)+1);
        dfs(0, 0, words, score, hm);
        return maxi;
    }
}