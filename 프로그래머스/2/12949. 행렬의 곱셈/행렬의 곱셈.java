class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        // 2 x 2 행렬과 2 x 3 행렬의 곱셈은 2 x 3 행렬이 된다.
        // A행렬의 열의 개수와 B행렬의 행의 개수가 같아야 곱셈이 된다.
        // arr1.length = 2
        // arr1[0].length = 2
        // arr2.length = 2
        // arr2[0].length = 3

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                int tmp = 0;
                for (int k = 0; k < arr2.length; k++) {
                    tmp += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = tmp;
            }
        }

        return answer;
    }
}