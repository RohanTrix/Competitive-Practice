public class Find_Players_With_Zero_or_One_Losses {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> set = new HashSet<>();
        List<Integer> noloss = new ArrayList<>();
        List<Integer> oneloss = new ArrayList<>();
        int score[] = new int[(int)1e5+1];
        for(int match[] : matches)
        {
            set.add(match[0]); set.add(match[1]);
            score[match[1]]++;
        }
        
        for(int i = 1; i<=100000;i++)
        {
            if(set.contains(i))
            {
                if(score[i]==0) noloss.add(i);
                if(score[i]==1) oneloss.add(i);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(noloss); res.add(oneloss);
        return res;
    }
}
