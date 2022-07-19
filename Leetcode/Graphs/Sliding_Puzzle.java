public class Sliding_Puzzle {
    public boolean matEqual(int board1[][], int board2[][])
    {
        return Arrays.deepToString(board1).equals(Arrays.deepToString(board2));
    }
    public int slidingPuzzle(int[][] board) {
        Queue<Node> q = new LinkedList<>();
        int dr[] = {0,1,0,-1,0};
        Set<Node> set = new HashSet<>();
        set.add(new Node(board.clone()));
        q.offer(new Node(board.clone()));
        int level = 0;
        int result[][] = {{1,2,3},{4,5,0}};
        while(!q.isEmpty())
        {
            int size = q.size();
            // debug(q);
            for(int l = 0; l<size; l++)
            {
                Node curr = q.poll();
                if( matEqual(curr.mat, result) ) return level;
                for(int i = 0; i<4; i++)
                {
                    int nx = curr.x+dr[i], ny = curr.y+dr[i+1];
                    if(Math.min(nx, ny)<0 || nx>=2 || ny>=3) continue;
                    
                    int newMat[][] = new int[][]{curr.mat[0].clone(), curr.mat[1].clone()};
                    int tmp = newMat[nx][ny];
                    newMat[nx][ny] = newMat[curr.x][curr.y];
                    newMat[curr.x][curr.y] = tmp;
                    if(set.contains(new Node(newMat))) continue;
                    set.add(new Node(newMat) );
                    q.offer( new Node(newMat) );
                }
            }
            level++;
        }
        return -1;
        
    }
    class Node
    {
        int mat[][], x,y;
        public Node(int mat[][])
        {
            this.mat = mat;
            x = 0; y = 0;
            for(int i = 0; i<2; i++) for(int j = 0; j<3; j++) if(mat[i][j] == 0) {x = i; y = j;};
        }
        public boolean equals(Object o)
        {
            Node p = (Node) o;
            return Arrays.deepToString(mat).equals(Arrays.deepToString(p.mat));
        }
        public int hashCode()
        {
            return Objects.hash(Arrays.deepToString(mat));
        }
    }
}
