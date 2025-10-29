import java.util.*;

class Solution {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static char[][] arr;
    static boolean[][] visited;
    static Deque<Point> queue = new ArrayDeque<>();
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (int i = 0; i < 5; i++) {
            arr = new char[5][5];
            
            for (int j = 0; j < 5; j++) {
                arr[j] = places[i][j].toCharArray();
            }
            
            answer[i] = 1;
            
            for (int y = 0; y < 5; y++) {
                for (int x = 0; x < 5; x++) {
                    if (arr[y][x] == 'P') {
                        if (bfs(y, x) == 0) {
                            answer[i] = 0;
                            break;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
    
    public static int bfs(int startY, int startX) {
        visited = new boolean[5][5];
        queue.clear();

        queue.offer(new Point(startY, startX, 0));
        visited[startY][startX] = true;
        
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int y = current.y;
            int x = current.x;
            int dist = current.dist;
            
            if (dist > 0 && arr[y][x] == 'P') {
                return 0;
            }
            
            if (dist >= 2) {
                continue;
            }
            
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if (ny < 0 || ny >= 5 || nx < 0 || nx >= 5) {
                    continue;
                }
                if (visited[ny][nx]) {
                    continue;
                }
                if (arr[ny][nx] == 'X') {
                    continue;
                }
                
                visited[ny][nx] = true;
                queue.offer(new Point(ny, nx, dist + 1));
            }
        }
        
        return 1;
    }
    
    static class Point {
        int y;
        int x;
        int dist;
        
        public Point(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }
}