class Solution {
    static int[] dy = {1, 0, -1};
    static int[] dx = {0, 1, -1};
    
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
        int dir = 0;
        
        for (int i = 1; i <= num; i++) {
            arr[y][x] = i;
            
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            
            if (ny < 0 || ny >= n || nx < 0 || nx >= arr[ny].length || arr[ny][nx] != 0) {
                dir = (dir + 1) % 3;
                ny = y + dy[dir];
                nx = x + dx[dir];
            }
            
            y = ny;
            x = nx;
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