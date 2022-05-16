public class Shortest_Path_in_Binary_Matrix
{
    // IDEA : BFS
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int dr[] = {-1,-1,-1,0,0,1,1,1};
        int dc[] = {1,0,-1,1,-1,1,0,-1};
        Queue<Node> queue = new LinkedList<>();
        if(grid[0][0] == 0)
            queue.offer(new Node(0,0,1));
        while(!queue.isEmpty())
        {
            Node tmp = queue.poll();
            if(tmp.x == m-1 && tmp.y == n-1)
                return tmp.dist;
            
            for(int i = 0; i<8; i++)
            {
                int nx = tmp.x+dr[i], ny = tmp.y + dc[i];
                if(nx>=m || ny>=n || nx<0 || ny<0 || grid[nx][ny]==1) continue;
                grid[nx][ny] = 1;
                queue.offer(new Node(nx,ny,tmp.dist+1));
            }
        }
        return -1;
    }
    class Node
    {
        int x, y, dist;
        public Node(int x, int y, int dist)
        {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}