class Solution {
    private Map<String, Map<String, Double>> graph = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        buildGraph(equations, values);
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            // find the start node
            String var1 = queries.get(i).get(0);
            // find the end node
            String var2 = queries.get(i).get(1);
            res[i] = dfs(var1, var2, new HashSet<>());
        }
        return res;

    }

    private void buildGraph(List<List<String>> equations, double[] values) {
        for (int i = 0; i < equations.size(); i++) {
            String val1 = equations.get(i).get(0);
            String val2 = equations.get(i).get(1);
            double value = values[i];

            // check if val already exist in the graph, add it if
            graph.putIfAbsent(val1, new HashMap<>());
            graph.putIfAbsent(val2, new HashMap<>());

            graph.get(val1).put(val2, value);
            graph.get(val2).put(val1, 1.0 / value);

        }

    }

    // use dfs to find the path between two nodes
    private double dfs(String start, String end, Set<String> visited) {
        // return condition
        // if not exist
        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            return -1.0;
        }
        if (start.equals(end)) {
            return 1.0;
        }
        visited.add(start);
        for (Map.Entry<String, Double> neighbor : graph.get(start).entrySet()) {
            String next = neighbor.getKey();
            if (!visited.contains(next)) {
                double result = dfs(next, end, visited);
                if (result != -1.0) {
                    return result * neighbor.getValue();
                }
            }
        }
        return -1.0;
    }
}