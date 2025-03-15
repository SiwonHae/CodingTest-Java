class Solution {
    static List<List<Integer>> result;
    static List<Integer> tmpList;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        tmpList = new ArrayList<>();

        backtrack(0, nums);

        return result;
    }

    public void backtrack(int depth, int[] nums) {
        result.add(new ArrayList<>(tmpList));

        for (int i = depth; i < nums.length; i++) {
            tmpList.add(nums[i]);
            backtrack(i + 1, nums);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}