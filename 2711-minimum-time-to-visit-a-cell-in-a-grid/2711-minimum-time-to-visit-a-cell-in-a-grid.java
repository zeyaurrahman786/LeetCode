class Solution {
    private int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        int m = grid.length;
        int n = grid[0].length;

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        heap.offer(new int[] { 0, 0, 0 });

        boolean[][] visited = new boolean[m][n];

        while (!heap.isEmpty()) {
            int[] entry = heap.poll();
            int row = entry[0];
            int col = entry[1];
            int time = entry[2];
            if (row == m - 1 && col == n - 1) {
                return time;
            }
            if (visited[row][col]) {
                continue;
            }
            visited[row][col] = true;

            for (int[] dir : directions) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r < 0 || r == m || c < 0 || c == n || visited[r][c]) {
                    continue;
                }

                if (grid[r][c] <= time + 1) {
                    heap.offer(new int[] { r, c, time + 1 });
                } else {
                    int diff = grid[r][c] - time;
                    if (diff % 2 == 1) {
                        heap.offer(new int[] { r, c, grid[r][c] });
                    } else {
                        heap.offer(new int[] { r, c, grid[r][c] + 1 });
                    }
                }
            }
        }
        return -1;
    }
}