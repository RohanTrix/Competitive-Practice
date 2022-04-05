public class Minimum_Deletions_to_Make_Character_Frequencies_Unique
{
    // IDEA : https://youtu.be/QvzPHt8ngkg
    public int minDeletions(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch,0)+1);
        
        List<pair> list = new ArrayList<>(); 
        for(char key : map.keySet())
            list.add(new pair(key, map.get(key)));
        
        Collections.sort(list, (a,b) -> b.cnt - a.cnt);
        Set<Integer> hs = new HashSet<>();
        int moves = 0;
        for(int i = 0; i<list.size(); i++)
        {
            char ch = list.get(i).ch;
            int cnt = list.get(i).cnt;
            while(hs.contains(cnt))
            {
                cnt--;
                moves++;
                if(cnt == 0) break;
            }
            hs.add(cnt);
        }
        return moves;
    }
    class pair
    {
        char ch;
        int cnt;
        public pair(char ch, int cnt)
        {
            this.ch = ch;
            this.cnt = cnt;
        }
    }
}