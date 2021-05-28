class Solution {
    /* Algorithm:
    We make a Pair class to store a cell as a node.
    BFS will be used. For the first layer of the BFS algorithm, add all the cells with value=2.
    This ensures that after all the nodes in this first layer have completed, we have completed one unit of time.
    Hence to acheive this layer-wise boundary, we introduce a null after each layer. 
    Basically, there are 2 cases when popping from queue:
        a) Node popped: Means rotting all its 4-neighbours(setting val=2) and appending the newly created.
        b) null popped: Means a layer of rotten oranges have finished. This  denotes that all the rotten oranges that were present in this layer have rottended their neighbours and put in the queue after the null              that was just popped.
    At the end, if all the ones were converted, we return the min(stores minutes) else return -1 
    */
    static class Pair
    {
        int x;
        int y;
        public Pair(int a,int b)
        {
            x=a;
            y=b;
        }
    }
    public int orangesRotting(int[][] grid) {
        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};
        int onesChanged=0, onesTotal = 0;
        Queue<Pair> ad = new LinkedList<Pair>();
        int n = grid.length;
        int m = grid[0].length;
        for( int i=0; i<n;++i)
        {
            for( int j = 0;j<m;j++)
            {
                if(grid[i][j]==1)
                    onesTotal++;
                if(grid[i][j]==2)
                ad.offer(new Pair(i,j));
            }
        }
        ad.add(null);
        int min=0;
        
        while(!ad.isEmpty())
        {
            Pair p = ad.poll();
            
            if(p!=null)
            {
                System.out.println(p.x+" "+p.y);
                for(int i = 0;i<4;i++)
                {
                    int nx = p.x+dx[i];
                    int ny = p.y+dy[i];
                    if(nx<0 || nx>=n ||ny<0 || ny>=m || grid[nx][ny]==0 || grid[nx][ny]==2)
                        continue;
                    grid[nx][ny] = 2;
                    onesChanged++;
                    ad.offer(new Pair(nx,ny));
                }
            }
            else
            {
                if(!ad.isEmpty())
                {
                    min++;
                    ad.offer(null);
                }
                else
                break;
            }
        }
        
        return onesChanged<onesTotal?-1: min;
        
    }
}