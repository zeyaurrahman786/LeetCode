class Solution {
    public boolean isAnagram(String s, String t) {
      char [] first_S= s.toCharArray();
      char [] second_t = t.toCharArray();
      Arrays.sort(first_S);
      Arrays.sort(second_t);
      return Arrays.equals(first_S,second_t);
    }
}