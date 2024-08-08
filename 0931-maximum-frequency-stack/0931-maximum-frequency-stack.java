class FreqStack {

    HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
    HashMap<Integer, Stack<Integer>> mp = new HashMap<Integer, Stack<Integer>>();
    int maxFreq = 0;

    public void push(int x) {
        int f = hash.getOrDefault(x, 0) + 1;
        hash.put(x, f);
        maxFreq = Math.max(f, maxFreq);
        if (!mp.containsKey(f))
            mp.put(f, new Stack<Integer>());
        mp.get(f).push(x);
    }

    public int pop() {
        int x = mp.get(maxFreq).pop();
        hash.put(x, maxFreq - 1);
        if (mp.get(maxFreq).isEmpty()) {
            maxFreq--;
        }
        return x;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */