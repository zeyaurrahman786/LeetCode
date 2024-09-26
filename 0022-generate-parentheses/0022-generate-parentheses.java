class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        Solve("", 0, 0, n, ans);
        return ans;
    }

    public void Solve(String curr, int open, int closed, int total, List<String> ans) {
        if (curr.length() == 2 * total) {
            ans.add(curr);
            return;
        }

        if (open < total) {
            Solve(curr + "(", open + 1, closed, total, ans);
        }

        if (closed < open) {
            Solve(curr + ")", open, closed + 1, total, ans);
        }
    }
}