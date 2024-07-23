class Solution {
    public boolean isAnagram(String s, String t) {
        char[] first_s = s.toCharArray();
        char[] second_t = t.toCharArray();
        Arrays.sort(first_s);
        Arrays.sort(second_t);
        return Arrays.equals(first_s, second_t);
    }
}