class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        Solve(new StringBuilder(), 0, 0, n, ans);
        return ans;
    }

    public void Solve(StringBuilder curr, int open, int closed, int total, List<String> ans) {
        if (curr.length() == 2 * total) {
            ans.add(curr.toString());
            return;
        }

        if (open < total) {
            curr.append("("); // Add an open parenthesis
            Solve(curr, open + 1, closed, total, ans);
            curr.deleteCharAt(curr.length() - 1); // Backtrack
        }

        if (closed < open) {
            curr.append(")"); // Add a close parenthesis
            Solve(curr, open, closed + 1, total, ans);
            curr.deleteCharAt(curr.length() - 1); // Backtrack
        }
    }
}
