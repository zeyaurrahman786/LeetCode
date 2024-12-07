class Solution {
    public int snakesAndLadders(int[][] board) {
        int destination = board.length * board.length;
        boolean[] visited = new boolean[destination + 1];
        Deque<Integer> q = new ArrayDeque();
        q.add(1);
        visited[1] = true;
        int ans = 0;
        while (!q.isEmpty()) {
            ans++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int f = q.poll();
                boolean added = false;
                for (int j = 6; j > 0; j--) {
                    int nc = f + j;
                    if (nc >= destination)
                        return ans;
                    if (!visited[nc]) {
                        int c = getCell(board, nc);
                        if (c == destination)
                            return ans;
                        if ((c == -1 || c == nc) && !added) {
                            q.offer(nc);
                            added = true;
                        } else if (c > 0) {
                            q.offer(c);
                        }
                        visited[nc] = true;
                    }
                }
            }
        }
        return -1;
    }

    int getCell(int[][] board, int k) {
        int n = board.length;
        int r = n - 1 - (k - 1) / n;
        int c = 0;
        if (n % 2 == 1)
            c = (r % 2 == 0 ? (k - 1) % n : n - 1 - (k - 1) % n);
        else
            c = (r % 2 == 0 ? n - 1 - (k - 1) % n : (k - 1) % n);
        return board[r][c];
    }
}