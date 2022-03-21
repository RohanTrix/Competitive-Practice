
public class Minimum_Domino_Rotations_For_Equal_Row {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int top = tops[0];
        int bot = bottoms[0];
        int n = tops.length;
        int score = 0, mini = Integer.MAX_VALUE/2;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i = 0; i<n; i++)
        {
            if(tops[i] == top) set1.add(i);
            if(bottoms[i] == top) set1.add(i);
            if(bottoms[i] == bot) set2.add(i);
            if(tops[i] == bot) set2.add(i);
        }
        if(set1.size()!=n && set2.size()!=n) return -1;
        for(int i = 0; i<n; i++)
        {
            if(tops[i] != top)
            {
                if(bottoms[i] == top) score++;
                else score = Integer.MAX_VALUE/2;
            }
        }
        mini = Math.min(score, mini);
        score = 0;
        for(int i = 0; i<n; i++)
        {
            if(bottoms[i] != top)
            {
                if(tops[i] == top) score++;
                else score = Integer.MAX_VALUE/2;
            }
        }
        mini = Math.min(score, mini);
        score = 0;
        for(int i = 0; i<n; i++)
        {
            if(tops[i] != bot)
            {
                if(bottoms[i] ==bot) score++;
                else score = Integer.MAX_VALUE/2;
            }
        }
        mini = Math.min(score, mini);
        score = 0;
        for(int i = 0; i<n; i++)
        {
            if(bottoms[i] != bot)
            {
                if(tops[i] ==bot) score++;
                else score = Integer.MAX_VALUE/2;
            }
        }
        mini = Math.min(score, mini);
        return mini;
    }
}
