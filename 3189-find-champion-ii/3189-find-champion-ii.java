class Solution {
    public int findChampion(int n, int[][] edges) {
        boolean[] team = new boolean[n];
        for (int[] edge : edges) {
            int w = edge[1];
            team[w] = true;
        }
        int unique = 0;
        int winner = -1;
        for (int i = 0; i < n; i++) {
            if (!team[i]) {
                unique++;
                winner = i;
            }
        }
        if (unique == 1) {
            return winner;
        } else {
            return -1;
        }
    }
}