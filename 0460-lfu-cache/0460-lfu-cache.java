class LFUCache {

    private final int capacity;
    private int minFreq;
    private final Map<Integer, int[]> keyToValFreq; // key -> [value, freq]
    private final Map<Integer, LinkedHashSet<Integer>> freqToKeys;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        keyToValFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToValFreq.containsKey(key))
            return -1;
        int[] valFreq = keyToValFreq.get(key);
        int val = valFreq[0];
        int freq = valFreq[1];
        // Remove from current freq set
        freqToKeys.get(freq).remove(key);
        // If current freq is minFreq and no keys left, increment minFreq
        if (freq == minFreq && freqToKeys.get(freq).isEmpty()) {
            minFreq++;
        }
        // Add to higher freq set
        freq++;
        freqToKeys.computeIfAbsent(freq, k -> new LinkedHashSet<>()).add(key);
        // Update frequency
        keyToValFreq.put(key, new int[] { val, freq });
        return val;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;
        if (keyToValFreq.containsKey(key)) {
            keyToValFreq.get(key)[0] = value;
            get(key); // Update frequency
            return;
        }
        if (keyToValFreq.size() >= capacity) {
            // Evict the least frequently used key
            LinkedHashSet<Integer> minFreqKeys = freqToKeys.get(minFreq);
            int evictKey = minFreqKeys.iterator().next();
            minFreqKeys.remove(evictKey);
            keyToValFreq.remove(evictKey);
        }
        // Insert new key
        keyToValFreq.put(key, new int[] { value, 1 });
        freqToKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        minFreq = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */