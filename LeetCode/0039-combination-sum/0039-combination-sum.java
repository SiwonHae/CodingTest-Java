class Solution {
    static List<List<Integer>> result;
    static List<Integer> tmpList;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        tmpList = new ArrayList<>();

        backtrack(0, candidates, target);
        return result;
    }

    private void backtrack(int depth, int[] candidates, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(tmpList));
            return;
        }

        for (int i = depth; i < candidates.length; i++) {
            if (candidates[i] > target) {
                continue;
            }

            tmpList.add(candidates[i]);
            backtrack(i, candidates, target - candidates[i]);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}