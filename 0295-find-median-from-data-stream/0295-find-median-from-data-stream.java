class MedianFinder {
    private PriorityQueue<Integer> lowerHalf; // max-heap
    private PriorityQueue<Integer> upperHalf; // min-heap

    public MedianFinder() {
        lowerHalf = new PriorityQueue<>((a, b) -> b - a); // Max-heap for the lower half
        upperHalf = new PriorityQueue<>(); // Min-heap for the upper half
    }

    public void addNum(int num) {
        // Add to the appropriate heap
        if (lowerHalf.isEmpty() || num <= lowerHalf.peek()) {
            lowerHalf.add(num);
        } else {
            upperHalf.add(num);
        }

        // Balance the heaps so that the sizes differ at most by 1
        if (lowerHalf.size() > upperHalf.size() + 1) {
            upperHalf.add(lowerHalf.poll());
        } else if (upperHalf.size() > lowerHalf.size()) {
            lowerHalf.add(upperHalf.poll());
        }
    }

    public double findMedian() {
        if (lowerHalf.size() > upperHalf.size()) {
            return lowerHalf.peek(); // Odd number of elements
        } else {
            return (lowerHalf.peek() + upperHalf.peek()) / 2.0; // Even number of elements
        }
    }
}
