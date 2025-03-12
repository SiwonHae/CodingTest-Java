class Solution {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean[][] visited;

    public int numIslands(char[][] grid) {
        int result = 0;

        visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j, grid);
                    result++;
                }
            }
        }

        return result;
    }

    public void dfs(int y, int x, char[][] grid) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= grid.length || nx < 0 || nx >= grid[0].length) {
                continue;
            }

            if (grid[ny][nx] == '1' && !visited[ny][nx]) {
                visited[ny][nx] = true;
                dfs(ny, nx, grid);
            }
        }
    }
}