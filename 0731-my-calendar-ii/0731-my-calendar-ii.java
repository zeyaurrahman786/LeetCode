class MyCalendarTwo {

    // List to store single bookings
    private List<int[]> booked;
    // List to store double bookings
    private List<int[]> overlaps;

    public MyCalendarTwo() {
        booked = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        // First, check if the new event overlaps with any double-booked intervals
        for (int[] overlap : overlaps) {
            if (Math.max(start, overlap[0]) < Math.min(end, overlap[1])) {
                return false;  // Triple booking would happen
            }
        }

        // Then, check for overlap with single-booked events and record double bookings
        for (int[] event : booked) {
            if (Math.max(start, event[0]) < Math.min(end, event[1])) {
                // Add the overlapping part to double bookings
                overlaps.add(new int[] { Math.max(start, event[0]), Math.min(end, event[1]) });
            }
        }

        // Finally, add the new event to the single-booked list
        booked.add(new int[] { start, end });
        return true;
    }
}
/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */