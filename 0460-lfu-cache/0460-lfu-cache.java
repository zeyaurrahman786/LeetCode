import java.util.*;

class LFUCache {

    private int cacheCapacity, minFrequency; // \U0001f31f Maximum capacity and current minimum frequency
    private Map<Integer, Integer> keyToValue; // \U0001f5c2️ Maps key -> value
    private Map<Integer, Integer> keyToFrequency; // \U0001f522 Maps key -> frequency count
    private Map<Integer, LinkedHashSet<Integer>> frequencyToKeys; // \U0001f6e0️ Maps frequency -> keys in insertion order

    public LFUCache(int capacity) {
        this.cacheCapacity = capacity; // \U0001f511 Cache size
        this.minFrequency = 0; // \U0001f522 Initialize minimum frequency
        this.keyToValue = new HashMap<>();
        this.keyToFrequency = new HashMap<>();
        this.frequencyToKeys = new HashMap<>();
    }

    // \U0001f3af Retrieve the value associated with the key
    public int get(int key) {
        if (!keyToValue.containsKey(key)) {
            return -1; // \U0001f6ab Key not found
        }
        // \U0001f504 Update the frequency of the key
        updateKeyFrequency(key);
        return keyToValue.get(key);
    }

    // ✍️ Insert or update a key-value pair
    public void put(int key, int value) {
        if (cacheCapacity == 0)
            return; // \U0001f6ab No capacity, do nothing

        if (keyToValue.containsKey(key)) {
            keyToValue.put(key, value); // \U0001f58a️ Update value
            updateKeyFrequency(key); // \U0001f504 Update frequency
            return;
        }

        // \U0001f6a8 Evict the least frequently used key if at capacity
        if (keyToValue.size() >= cacheCapacity) {
            evictLeastFrequentKey();
        }

        // \U0001f195 Add the new key-value pair
        keyToValue.put(key, value);
        keyToFrequency.put(key, 1); // Start frequency at 1
        frequencyToKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        minFrequency = 1; // Reset minimum frequency to 1
    }

    // \U0001f504 Update the frequency of a key
    private void updateKeyFrequency(int key) {
        int currentFreq = keyToFrequency.get(key); // \U0001f522 Get the current frequency
        frequencyToKeys.get(currentFreq).remove(key); // \U0001f5d1️ Remove key from current frequency bucket

        // \U0001f31f If the frequency bucket is empty, remove it and adjust `minFrequency`
        if (frequencyToKeys.get(currentFreq).isEmpty()) {
            frequencyToKeys.remove(currentFreq);
            if (currentFreq == minFrequency) {
                minFrequency++;
            }
        }

        // \U0001f522 Increase the frequency and move the key to the new frequency bucket
        int newFreq = currentFreq + 1;
        keyToFrequency.put(key, newFreq);
        frequencyToKeys.computeIfAbsent(newFreq, k -> new LinkedHashSet<>()).add(key);
    }

    // \U0001f5d1️ Evict the least frequently used key
    private void evictLeastFrequentKey() {
        // \U0001f50d Get the list of keys with the minimum frequency
        LinkedHashSet<Integer> keysWithMinFreq = frequencyToKeys.get(minFrequency);

        // \U0001f6aa Remove the least recently used key
        int keyToEvict = keysWithMinFreq.iterator().next();
        keysWithMinFreq.remove(keyToEvict);

        // \U0001f31f Clean up if the bucket becomes empty
        if (keysWithMinFreq.isEmpty()) {
            frequencyToKeys.remove(minFrequency);
        }

        // \U0001f5d1️ Remove the key from all mappings
        keyToValue.remove(keyToEvict);
        keyToFrequency.remove(keyToEvict);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */