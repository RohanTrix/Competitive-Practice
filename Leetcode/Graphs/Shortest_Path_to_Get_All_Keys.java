/*
    IDEA : Solved in One Go :)

           First observation of the problem should be to use BFS as shortest path is asked. However,
           we also notice two other things

                1) There are cells with locks which we can only pass through if we have collected the key at
                   that position. By collected, we do not mean to remove it from its place, but we only want to 
                   maintain the fact that we have passed over that cell.
                
                2) The following situation can happen where we might have to traverse a cell more than once.
                    Image : https://ibb.co/ZLNB9gd

            Thus, this gives us the hint that making a state/node as only the coordinates x,y is not enough
            to mark visited states in BFS.

            We also need to know which keys have we taken till now, so that we stop as soon as we get all keys.
            So we can take benefit of the constraint on the keys(upto 6) and create a bitmask for keys taken till now.

            So a node in BFS for us will be (x,y, MASK of keys taken till now, COST to reach this state)

*/
public class Shortest_Path_to_Get_All_Keys {
    public int shortestPathAllKeys(String[] g) {
        int maskSize = 1<<6;
        boolean visited[][][] = new boolean[31][31][1<<6];
        char grid[][] = new char[g.length][g[0].length()];

        int m = grid.length, n = grid[0].length;
        
        // Converting to character grid
        for(int i = 0; i<m; i++)
            for(int j = 0; j<n; j++)
                grid[i][j] = g[i].charAt(j);
        
        String keys = "abcdef";
        int fullMask = 0;
        int stx = 0, sty = 0;
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(grid[i][j] == '@')
                    stx = i; sty = j;
                if(keys.contains(""+grid[i][j])) // Which all keys are present in our input out of 6 keys
                    fullMask = fullMask | (1<<(grid[i][j]-'a'));
            }
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(stx, sty, 0, 0));
        visited[0][0][0] = true;
        // Direction vectors
        int dr[] = {1,-1,0,0};
        int dc[] = {0,0,-1,1};
        
        while(!queue.isEmpty())
        {
            Node curr = queue.poll();
            // System.out.println(curr);
            if(curr.mask == fullMask) // Shortest path to collect all keys reached
                return curr.cost;
            
            for(int p = 0; p<4; p++)
            {
                int nx = curr.x + dr[p], ny = curr.y + dc[p];
                if(!insideBound(nx,ny, m, n) || grid[nx][ny] == '#') continue; // Invalid cell to go to
                
                if(keys.contains(""+grid[nx][ny])) // If the cell has a key
                {
                    int key = grid[nx][ny] - 'a'; // Key position in bitmask
                    if(visited[nx][ny][curr.mask | 1<<key]) continue; // If state reached, skip
                    // Mark key as taken, update cost to this new node and add to Queue
                    queue.add(new Node (nx,ny, curr.mask | 1<<key, 1 + curr.cost));
                    visited[nx][ny][curr.mask | 1<<key] = true;
                }
                else
                {
                    char lock = Character.toLowerCase(grid[nx][ny]);
                    int keyPos = lock - 'a';
                    if(keys.contains(""+lock)) // If this char is a LOCK
                    {
                        
                        if((curr.mask&(1<<keyPos))!=0) // If the key is collected by us for this lock
                        {
                            if(visited[nx][ny][curr.mask]) continue;
                            queue.add(new Node(nx,ny, curr.mask,  1 + curr.cost));
                            visited[nx][ny][curr.mask] = true;
                        }
                    }
                    else // Empty Cell can also be reached if not visited
                    {
                        if(visited[nx][ny][curr.mask]) continue;
                        queue.add(new Node(nx, ny, curr.mask, 1 + curr.cost));
                        visited[nx][ny][curr.mask] = true;
                    }
                }
            }
        }
        return -1; // Return -1 if all keys could not be collected
    }
    // Check if inside bounds
    public boolean insideBound(int x, int y, int m, int n)
    {
        return x>=0 && x<m && y>=0 && y<n;
    }
    // x,y are coords....mask denotes keys collected after reaching this state and cost is cost to reach this state
    private class Node
    {
        int x, y;
        int mask, cost;
        public Node(int x, int y, int mask, int cost)
        {
            this.x = x;
            this.y = y;
            this.mask = mask;
            this.cost = cost;
        }
        public String toString()
        {
            return x+" "+y+" "+mask+" Cost : "+cost;
        }
    }
}
