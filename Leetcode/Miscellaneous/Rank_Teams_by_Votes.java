public class Rank_Teams_by_Votes {
    int ranks[][] = new int[26][26];
    public int compareChar(Character a, Character b)
    {
        for(int i = 0; i<26; i++)
        {
            if(ranks[a-'A'][i]==ranks[b-'A'][i]) continue;
            return ranks[b-'A'][i] - ranks[a-'A'][i];
        }
        return a-b;
    }
    public String rankTeams(String[] votes) {
        
        for(String vote : votes)
            for(int i = 0; i<vote.length(); i++)
                ranks[vote.charAt(i)-'A'][i]++;
        
        ArrayList<Character> list = new ArrayList<>();
        for(char ch : votes[0].toCharArray()) list.add(ch);
        Collections.sort(list, (a,b) -> compareChar(a,b));
        StringBuilder str =  new StringBuilder();
        for(char ch : list) str.append(ch);
        return str.toString();
    }
}
