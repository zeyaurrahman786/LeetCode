class SmallestInfiniteSet {

    private PriorityQueue<Integer> pq;
    private HashMap<Integer, Integer> hm;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<Integer>();
        hm = new HashMap<Integer, Integer>();
        for (int i = 1; i <= 1000; i++) {
            pq.add(i);
        }
    }

    public int popSmallest() {
        hm.put(pq.peek(), 1);
        return pq.poll();
    }

    public void addBack(int num) {
        if (hm.containsKey(num)) {
            hm.remove(num);
            pq.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */