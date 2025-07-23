class Solution {

    public int maximumGain(String s, int x, int y) {
        StringBuilder text = new StringBuilder(s);
        int totalPoints = 0;

        if (x > y) {
            // Remove "ab" first (higher points), then "ba"
            totalPoints += removeSubstring(text, "ab", x);
            totalPoints += removeSubstring(text, "ba", y);
        } else {
            // Remove "ba" first (higher or equal points), then "ab"
            totalPoints += removeSubstring(text, "ba", y);
            totalPoints += removeSubstring(text, "ab", x);
        }

        return totalPoints;
    }

    private int removeSubstring(
        StringBuilder inputString,
        String targetSubstring,
        int pointsPerRemoval
    ) {
        int totalPoints = 0;
        int writeIndex = 0;

        // Iterate through the string
        for (int readIndex = 0; readIndex < inputString.length(); readIndex++) {
            // Add the current character
            inputString.setCharAt(writeIndex++, inputString.charAt(readIndex));

            // Check if we've written at least two characters and
            // they match the target substring
            if (
                writeIndex > 1 &&
                inputString.charAt(writeIndex - 2) ==
                targetSubstring.charAt(0) &&
                inputString.charAt(writeIndex - 1) == targetSubstring.charAt(1)
            ) {
                writeIndex -= 2; // Move write index back to remove the match
                totalPoints += pointsPerRemoval;
            }
        }

        // Trim the StringBuilder to remove any leftover characters
        inputString.setLength(writeIndex);

        return totalPoints;
    }
}