class Solution {
    static List<String> result;
    static Map<String, PriorityQueue<String>> map;

    public List<String> findItinerary(List<List<String>> tickets) {
        result = new LinkedList<>();
        map = new HashMap<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            map.put(from, map.getOrDefault(from, new PriorityQueue<>()));
            map.get(from).add(to);
        }

        dfs("JFK");

        return result;
    }

    public void dfs(String from) {
        while (map.containsKey(from) && !map.get(from).isEmpty()) {
            dfs(map.get(from).poll());
        }

        result.add(0, from);
    }
}