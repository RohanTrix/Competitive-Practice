**Explanation**: The answer( ith day ) has to be binary searched because of the  following property: 
> If there is a valid path possible on day `i`, then it was also possible on all days before day `i`

So the possible function(function which divides is the answer is Y or N), will check whether there is path possible from top to bottom. To acheive this, we only have to do a bfs, from each valid cell in the first row. If the bfs can reach any cell in the last row, then we return true( i.e it is possible), store the current mid as bestAns and search only towards the right, else search for a valid answer towards right.
```java
class Solution {
    int dx[] = {0,0,1,-1};
    int dy[] = {1,-1,0,0};
    static class pair
    {
        int x, y;
        public pair(int xx, int yy)
        {
            x = xx;
            y = yy;
        }
        public String toString()
        {
            return x+" "+y;
        }
        public boolean equals(Object o) {
            pair x = (pair) o;
            return (x.x == this.x && x.y == this.y);
        }
    }
    public boolean checkWater(int r, int c, int cells[][], int ind)
    {
       
        for(int i = 0; i<=ind; i++)
            if(cells[i][0]-1==r && cells[i][1]-1==c) return true;
        return false;
    }
    public boolean possible(int row, int col,int cells[][], int mid)
    {
        int vis[][] = new int[row][col];
        
        ArrayDeque<pair> q = new ArrayDeque<>();
        for(int i = 0; i<=mid; i++)
            vis[cells[i][0]-1][cells[i][1]-1] =1;
        for(int i = 0; i<col; i++)
        {
            
            
            if(checkWater(0,i, cells, mid)==false)
            {
                q.offerLast(new pair(0,i));   
            }
       
        }
        //System.out.println(q);
        while(!q.isEmpty())
        {
            pair temp = q.pollFirst();
            
            if(temp.x==row-1) return true;
            for(int i = 0; i<4; i++)
            {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                
                if(nx<0 || nx>=row || ny<0 || ny>=col)
                    continue;
                if(vis[nx][ny]==1)
                    continue;
                
                q.offerLast(new pair(nx,ny));
                vis[nx][ny] = 1;
            }
        }
        return false;
        
        
    }
    public int latestDayToCross(int row, int col, int[][] cells) {
        int l = 0, r = cells.length-1;
        int bestAns = -1;
        while(l<=r)
        {
            int mid = l + (r-l)/2;
            
            if(possible(row, col, cells, mid))
            {
                bestAns = mid;
                l = mid+1;
            }
            else
                r = mid-1;
                
        }
        return bestAns+1;
    }
}
```