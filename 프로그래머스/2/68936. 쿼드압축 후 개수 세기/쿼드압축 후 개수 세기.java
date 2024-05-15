class Solution {

    static int[] answer = new int[2];

    private boolean isValidCompress(int[][] arr, int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[x][y] != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void quad(int[][] arr, int offsetX, int offsetY, int size) {
        if (isValidCompress(arr, offsetX, offsetY, size)) {
            if (arr[offsetX][offsetY] == 1) {
                answer[1]++;
            } else {
                answer[0]++;
            }
            return;
        }

        quad(arr, offsetX, offsetY, size / 2);
        quad(arr, offsetX + size / 2, offsetY, size / 2);
        quad(arr, offsetX, offsetY + size / 2, size / 2);
        quad(arr, offsetX + size / 2, offsetY + size / 2, size / 2);
    }

    public int[] solution(int[][] arr) {
        quad(arr, 0, 0, arr.length);
        return answer;
    }
}