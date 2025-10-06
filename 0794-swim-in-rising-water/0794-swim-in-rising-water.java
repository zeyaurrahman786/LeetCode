class Solution {
    public int swimInWater(int[][] grid) {
             // Get grid size
        int n = grid.length;

        // Create min-heap for cells by elevation
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Visited matrix
        boolean[][] visited = new boolean[n][n];

        // Push starting cell to heap
        minHeap.add(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        // Direction vectors
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        // Process heap until destination
        while (!minHeap.isEmpty()) {
            // Get cell with lowest elevation
            int[] curr = minHeap.poll();
            int elevation = curr[0], r = curr[1], c = curr[2];

            // If destination reached
            if (r == n - 1 && c == n - 1) return elevation;

            // Check all neighbors
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];

                // Check bounds and visited
                if (nr >= 0 && nc >= 0 && nr < n && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    minHeap.add(new int[]{Math.max(elevation, grid[nr][nc]), nr, nc});
                }
            }
        }
        return -1;
    }
}