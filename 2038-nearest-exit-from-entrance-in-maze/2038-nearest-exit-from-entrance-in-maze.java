class Solution {

    int[][] vis;

    public boolean isSafe(char[][] maze, int x, int y) {
        int rowLen = maze.length;
        int colLen = maze[0].length;

        if (x < 0 || x >= rowLen || y < 0 || y >= colLen) {
            return false;
        }

        return vis[x][y] == 0 && maze[x][y] == '.';
    }

    public int bfs(char[][] maze, int[] entrance) {
        int X = entrance[0];
        int Y = entrance[1];

        int x = X;
        int y = Y;

        Queue<int[]> q = new LinkedList<>();

        int dis = 0;
        q.offer(new int[] { x, y, 0 });
        vis[x][y] = 1;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            x = curr[0];
            y = curr[1];
            dis = curr[2];

            // up
            if (isSafe(maze, x - 1, y)) {
                vis[x - 1][y] = 1;
                q.add(new int[] { x - 1, y, dis + 1 });
            }

            // down
            if (isSafe(maze, x + 1, y)) {
                vis[x + 1][y] = 1;
                q.add(new int[] { x + 1, y, dis + 1 });
            }

            // left
            if (isSafe(maze, x, y - 1)) {
                vis[x][y - 1] = 1;
                q.add(new int[] { x, y - 1, dis + 1 });
            }

            // right
            if (isSafe(maze, x, y + 1)) {
                vis[x][y + 1] = 1;
                q.add(new int[] { x, y + 1, dis + 1 });
            }

            if (dis == 0) {
                continue;
            }

            if (x == 0 || y == 0 || x == maze.length - 1 || y == maze[0].length - 1) {
                return dis;
            }

        }

        return -1;
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        this.vis = new int[maze.length][maze[0].length];

        return bfs(maze, entrance);
    }
}