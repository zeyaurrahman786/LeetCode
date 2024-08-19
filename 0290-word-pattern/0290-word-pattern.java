class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> mp = new HashMap<>();

        String arr[] = s.split(" ");
        if (arr.length != pattern.length())
            return false;

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);

            if (mp.containsKey(ch)) {
                // If the pattern character is already mapped, check if it maps to the same
                // string
                if (!mp.get(ch).equals(arr[i])) {
                    return false;
                }
            } else {
                // If the string word is already mapped to a different character, return false
                if (mp.containsValue(arr[i])) {
                    return false;
                }
                // Otherwise, map the pattern character to the current string word
                mp.put(ch, arr[i]);
            }
        }
        return true;
    }
}