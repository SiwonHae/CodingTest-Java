class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // (0, 0)과 비교해서 가장 가까운 거리의 point를 k개 반환하자.
        int[][] result = new int[k][2];

        Map<Integer, Double> map = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];

            map.put(i, calcDistance(0, 0, x, y));
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet, (o1, o2) -> Double.compare(map.get(o1), map.get(o2)));

        for (int i = 0; i < k; i++) {
            result[i][0] = points[keySet.get(i)][0];
            result[i][1] = points[keySet.get(i)][1];
        }
    
        return result;
    }

    public double calcDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)));
    }
}