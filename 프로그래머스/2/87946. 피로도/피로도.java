class Solution {

    static boolean[] visited;
    static int answer = 0;

    public void dfs(int depth, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(depth + 1, k - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, depth);
    }

    public int solution(int k, int[][] dungeons) {


        // 탐험 시작 최소 필요 피로도
        // 탐험 마친 후 소모 피로도

        visited = new boolean[dungeons.length];
        int depth = 0;

        dfs(depth, k, dungeons);

        return answer;
    }
}