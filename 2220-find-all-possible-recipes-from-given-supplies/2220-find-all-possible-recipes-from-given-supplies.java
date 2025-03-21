public class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Integer> indegree = new HashMap<>(); // Store indegrees of recipes
        Map<String, List<String>> graph = new HashMap<>(); // Adjacency list representation

        // Initialize graph and indegree for each recipe
        for (String recipe : recipes) {
            indegree.put(recipe, 0);
            graph.put(recipe, new ArrayList<>());
        }

        // Build the graph
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            for (String ingredient : ingredients.get(i)) {
                graph.putIfAbsent(ingredient, new ArrayList<>());
                graph.get(ingredient).add(recipe); // Directed edge ingredient -> recipe
                indegree.put(recipe, indegree.getOrDefault(recipe, 0) + 1);
            }
        }

        // Initialize queue with all supplies (they have an indegree of 0)
        Queue<String> queue = new LinkedList<>();
        Set<String> available = new HashSet<>(Arrays.asList(supplies));
        queue.addAll(available);

        List<String> result = new ArrayList<>();

        // Perform BFS (Topological Sorting)
        while (!queue.isEmpty()) {
            String item = queue.poll();
            if (indegree.containsKey(item)) { // Only recipes are counted in the result
                result.add(item);
            }

            // Process dependent recipes
            for (String next : graph.getOrDefault(item, new ArrayList<>())) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) { // All ingredients available
                    queue.offer(next);
                }
            }
        }

        return result;
    }

    // Example Usage
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] recipes = { "bread", "sandwich", "burger" };
        List<List<String>> ingredients = Arrays.asList(
                Arrays.asList("yeast", "flour"),
                Arrays.asList("bread", "meat"),
                Arrays.asList("sandwich", "meat", "bread"));
        String[] supplies = { "yeast", "flour", "meat" };

        System.out.println(sol.findAllRecipes(recipes, ingredients, supplies));
    }
}
