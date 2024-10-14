class Solution {

    public int numSquares(int n) {
        int arr[] = new int[n + 1];
        Arrays.fill(arr, -1);
        return solve(n, arr);
    }

    public int solve(int n, int[] arr) {
        if (arr[n] != -1)
            return arr[n];
        if (n <= 0)
            return 0;
        int res = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= Math.sqrt(n); i++) {
            res = 1 + solve(n - (i * i), arr);
            min = Math.min(min, res);
        }

        return arr[n] = min;
    }
}