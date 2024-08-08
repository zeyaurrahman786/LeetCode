class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<Integer>();
        for (int a : asteroids) {
            if (a > 0) {
                s.push(a);
            } else {
                while (!s.isEmpty() && s.peek() > 0 && -a > s.peek()) {
                    s.pop();
                }
                if (s.isEmpty() || s.peek() < 0) {
                    s.push(a);
                }
                if (s.peek() == -a) {
                    s.pop();
                }
            }
        }
        int[] ans = new int[s.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = s.pop();
        }
        return ans;
    }
}