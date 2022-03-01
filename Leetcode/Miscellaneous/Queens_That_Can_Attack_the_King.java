package Leetcode.Miscellaneous;

/*
    Do not need to create a matrix since queens can be max 63 length...and we will search queen linearly
    at max 4*8 times.
*/
public class Queens_That_Can_Attack_the_King {
    public boolean isPresent(int x, int y, int queens[][])
    {
        if(x<0 || y<0 || x>=8 || y>=8) return false;
        for(int i = 0; i<queens.length; i++)
            if(x == queens[i][0] && y == queens[i][1])
                return true;
        return false;
    }
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int dir[] = {-1,0,1};
        List<List<Integer>> ans = new ArrayList<>();
        int cnt = 0;
        for(int r = 0; r<3; r++)
        {
            for(int c = 0; c<3; c++)
            {
                for(int i = 0 ; i<8; i++)
                {
                    int nx = king[0] + dir[r]*i;
                    int ny = king[1] + dir[c]*i;
                    if(isPresent(nx,ny, queens))
                    {
                        List<Integer> pair = new ArrayList<>();
                        pair.add(nx); pair.add(ny);
                        ans.add(pair);
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
