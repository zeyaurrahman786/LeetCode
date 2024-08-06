class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                if (!s.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(ch);
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        ans.reverse();
        return ans.toString();

    }
}