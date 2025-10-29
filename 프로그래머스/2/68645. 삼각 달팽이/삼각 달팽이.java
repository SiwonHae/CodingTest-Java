class Solution {
    public int[] solution(int n) {
        int num = 0;
        for (int i = 1; i <= n; i++) {
            num += i;
        }
        
        int[][] arr = new int[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[i + 1];
        }
        
        int y = 0;
        int x = 0;
        int cur = 1;
        while (cur <= num) {
            // 아래로 채우기
            while (y < n) {
                if (arr[y][x] != 0) {
                    break;
                }
                arr[y][x] = cur++;
                y++;
            }
            y--;
            x++;
            
            // 오른쪽으로 채우기
            while (x < arr[y].length) {
                if (arr[y][x] != 0) {
                    break;
                }
                arr[y][x] = cur++;
                x++;
            }
            x -= 2;
            y--;
            
            // 왼쪽 위 대각선으로 채우기
            while (y >= 0 && x >= 0) {
                if (arr[y][x] != 0) {
                    break;
                }
                arr[y][x] = cur++;
                y--;
                x--;
            }
            y += 2;
            x++;
        }
        
        int[] answer = new int[num];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                answer[idx++] = arr[i][j];
            }
        }
        
        return answer;
    }
}