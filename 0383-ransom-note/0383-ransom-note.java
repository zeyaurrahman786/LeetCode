class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[26];
        for (char c : magazine.toCharArray())
            letters[c - 'a']++;
        for (char ch : ransomNote.toCharArray()) {
            letters[ch - 'a']--;
            if (letters[ch - 'a'] == -1)
                return false;
        }
        return true;
    }
}