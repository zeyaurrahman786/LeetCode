class Solution {
    public int findComplement(int num) {
        // Find the length
        int length = (int) (Math.log(num) / Math.log(2) + 1);
        int mask = (1 << length) - 1;
        return mask ^ num;
    }
}