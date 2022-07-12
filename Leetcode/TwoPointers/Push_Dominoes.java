/**
 *      IDEA : We first make a list `moves` of pairs (L/R, idx)
 *             Now, traversing on adjacent elements of this moves...we process if we find the
 *             following config : "R....L" -> We use 2 pointers to convert this to 'RRRLLL'
 *             Similarly        : "R...L"  -> "RRSL"...here 'S' denotes Stable
 *             
 *             Now...all we have to do is process L's and R's which are not of the above form.
 *             So we traverse...and if we encounter a 'L', then we keep making all the continuous
 *             '.' on the left to 'L'. Similarly for 'R'.
 *             
 *             Now finally...we reconvert the 'S' to '.' since we had protected it from being marked
 *             incorrectly in the logic on the above paragraph.
 */
public class Push_Dominoes {
    public String pushDominoes(String dominoes) {
        char dom[] = dominoes.toCharArray();
        int n = dom.length;
        List<int[]> moves = new ArrayList<>();
        for(int i = 0; i<n; i++)
            if(dom[i] != '.')
                moves.add(new int[]{(int)dom[i], i});
        
        for(int p = 1; p<moves.size(); p++)
        {
            int left[] = moves.get(p-1);
            int right[] = moves.get(p);
            if(left[0] == 'R' && right[0] == 'L')
            {
                for(int i = left[1]+1, j = right[1]-1; i<=j; i++,j--)
                {
                    if(i == j)
                        dom[i] = 'S';
                    else
                    {
                        dom[i] = 'R';
                        dom[j] = 'L';
                    }
                }
            }
        }
        for(int i = 0; i<moves.size(); i++)
        {
            int move[] = moves.get(i);
            int pos = move[1]+((move[0] == 'L')?-1:1);
            if(move[0] == 'L')
                while(pos>=0 && dom[pos] == '.')
                    dom[pos--] = 'L';
            else
                while(pos<n && dom[pos] == '.')
                    dom[pos++] = 'R';
        }
        for(int i = 0; i<n; i++) if(dom[i] == 'S') dom[i] = '.';
        return new String(dom);
    }
}
