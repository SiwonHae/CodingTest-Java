import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        Set<String> set = new HashSet<>();
        int x = 0;
        int y = 0;
        
        for (int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);
            
            int nx = x;
            int ny = y;
            
            String s = "";
            
            if (c == 'U') {
                ny++;
                s = x + " " + y + " " + nx + " " + ny;
            } else if (c == 'D') {
                ny--;
                s = nx + " " + ny + " " + x + " " + y;
            } else if (c == 'R') {
                nx++;
                s = x + " " + y + " " + nx + " " + ny;
            } else {
                nx--;
                s = nx + " " + ny + " " + x + " " + y;
            }
            
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) {
                continue;
            }
            
            set.add(s);
            
            x = nx;
            y = ny;
        }
        
        answer = set.size();
        return answer;
    }
}