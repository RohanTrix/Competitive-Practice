public class Check_Knight_Tour_Configuration {

    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0)
            return false;
        int n = grid.length;
        int pos[][] = new int[n * n][2];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                pos[grid[i][j]] = new int[] { i, j };

        for (int i = 1; i < n * n; i++) {
            int x1 = pos[i - 1][0], y1 = pos[i - 1][1];
            int x2 = pos[i][0], y2 = pos[i][1];
            if ((Math.abs(x1 - x2) == 2 && Math.abs(y1 - y2) == 1)
                    || (Math.abs(x1 - x2) == 1 && Math.abs(y1 - y2) == 2))
                continue;
            return false;
        }
        return true;
    }
}