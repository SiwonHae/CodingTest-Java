class Solution {
    static List<List<Integer>> result;
    static List<Integer> tmpList;

    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        tmpList = new ArrayList<>();

        backtrack(1, n, k);

        return result;
    }

    public void backtrack(int depth, int n, int k) {
        if (tmpList.size() == k) {
            result.add(new ArrayList<>(tmpList));
            return;
        }

        for (int i = depth; i <= n; i++) {
            tmpList.add(i);
            backtrack(i + 1, n, k);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}