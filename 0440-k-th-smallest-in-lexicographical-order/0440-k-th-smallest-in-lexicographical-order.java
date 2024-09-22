class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;

        while (k > 0) {
            long count = countNode(n, curr, curr + 1);

            if (count <= k) {
                curr += 1;
                k -= count;
            } else {
                curr *= 10;
                k -= 1;
            }
        }
        return curr;
    }

    public long countNode(int n, long prefix, long nextPrefix) {
        long count = 0;

        while (prefix <= n) {
            count += Math.min(n + 1, nextPrefix) - prefix;
            prefix *= 10;
            nextPrefix *= 10;
        }
        return count;
    }
}