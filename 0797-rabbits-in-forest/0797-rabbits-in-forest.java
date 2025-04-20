class Solution 
{
    public int numRabbits(int[] answers) 
    {
        Map<Integer, Integer> map = new HashMap<>();
        int total = 0;

        // Step 1: Count frequency of each answer
        for (int ans : answers) 
        {
            map.put(ans, map.getOrDefault(ans, 0) + 1);
        }

        // Step 2-4: For each unique answer, calculate group size and number of groups
        for (int k : map.keySet()) 
        {
            int count = map.get(k);
            int groupSize = k + 1;

            // Step 3: Compute number of groups needed (ceil of count / groupSize)
            int groups = (int) Math.ceil((double) count / groupSize);

            // Step 4: Add total rabbits in all groups of this kind
            total += groups * groupSize;
        }

        // Step 5: Return total rabbits
        return total;
    }
}