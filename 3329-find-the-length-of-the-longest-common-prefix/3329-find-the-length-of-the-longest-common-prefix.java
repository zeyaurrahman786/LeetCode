class Solution {
    Trie root;

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        root = new Trie();
        for (int val : arr1) {
            Trie curr = root;
            for (char ch : String.valueOf(val).toCharArray()) {
                if (curr.children[ch - '0'] == null) {
                    curr.children[ch - '0'] = new Trie();
                }
                curr = curr.children[ch - '0'];
            }
        }

        int currCount = 0;
        int ans = 0;
        for (int val : arr2) {
            Trie curr = root;
            for (char ch : String.valueOf(val).toCharArray()) {
                if (curr.children[ch - '0'] == null) {
                    break;
                }
                currCount++;
                curr = curr.children[ch - '0'];
            }
            ans = Math.max(ans, currCount);
            currCount = 0;
        }
        return ans;

    }

    class Trie {
        Trie children[] = new Trie[10];

        Trie() {
        }

    }
}