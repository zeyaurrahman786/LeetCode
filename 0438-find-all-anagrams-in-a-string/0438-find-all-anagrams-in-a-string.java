class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }

        int[] pmap = new int[26];
        int[] smap = new int[26];

        for (char c : p.toCharArray()) {
            pmap[c - 'a']++;
        }

        for (int i = 0; i < p.length(); i++) {
            smap[s.charAt(i) - 'a']++;
        }

        if (matches(smap, pmap)) {
            result.add(0);
        }

        for (int i = p.length(); i < s.length(); i++) {
            smap[s.charAt(i) - 'a']++;
            smap[s.charAt(i - p.length()) - 'a']--;

            if (matches(smap, pmap)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }

    private boolean matches(int[] smap, int[] pmap) {
        for (int i = 0; i < smap.length; i++) {
            if (smap[i] != pmap[i]) {
                return false;
            }
        }
        return true;
    }
}