class Solution {

    static boolean[] visited;
    static int answer = 0;

    public void dfs(int depth, int sum, int target, int[] numbers) {
        if (depth == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        dfs(depth + 1, sum + numbers[depth], target, numbers);
        dfs(depth + 1, sum - numbers[depth], target, numbers);
    }

    public int solution(int[] numbers, int target) {

        int depth = 0;
        int sum = 0;
        visited = new boolean[numbers.length];
        
        dfs(depth, sum, target, numbers);

        return answer;
    }
}