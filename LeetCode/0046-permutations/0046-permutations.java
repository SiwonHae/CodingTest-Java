class Solution {
    static List<List<Integer>> result;
    static boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        visited = new boolean[nums.length];

        backtrack(nums, new ArrayList<>());

        return result;
    }

    public void backtrack(int[] nums, List<Integer> tmpList) {
        if (tmpList.size() == nums.length) {
            result.add(new ArrayList<>(tmpList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            tmpList.add(nums[i]);
            backtrack(nums, tmpList);
            visited[i] = false;

            tmpList.remove(tmpList.size() - 1);
        }
    }
}