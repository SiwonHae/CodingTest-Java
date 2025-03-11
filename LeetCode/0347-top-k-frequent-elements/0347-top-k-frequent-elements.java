class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 가장 많은 숫자를 k개 출력하자.

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet, (o1, o2) -> map.get(o2) - map.get(o1));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = keySet.get(i);
        }

        return result;
    }
}