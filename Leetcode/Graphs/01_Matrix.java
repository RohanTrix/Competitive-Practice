// IDEA : MULTI-SOURCE BFS FROM ALL ZEROS
public class 01_Matrix{
class pair {
    int x, y;

    public pair(int xx, int yy) {
        x = xx;
        y = yy;
    }

}

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int dist[][] = new int[mat.length][mat[0].length];

        ArrayDeque<pair> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = mat[i][j] == 0 ? 0 : Integer.MAX_VALUE / 2;
                if (mat[i][j] == 0)
                    q.offerLast(new pair(i, j));
            }
        }
        int dr[] = { 0, 0, 1, -1 };
        int dc[] = { 1, -1, 0, 0 };

        while (!q.isEmpty()) {
            pair p = q.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dr[i], ny = p.y + dc[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || dist[nx][ny] <= dist[p.x][p.y] + 1)
                    continue;
                q.offerLast(new pair(nx, ny));

                dist[nx][ny] = dist[p.x][p.y] + 1;

            }
        }
        return dist;
    }
}
