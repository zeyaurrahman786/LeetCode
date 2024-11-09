class Solution {
    public long minEnd(int n, int x) {
        long ans = x;
        n -= 1;
        while (n-- > 0) {
            ans = (ans + 1) | x;
        }
        return ans;
    }
}