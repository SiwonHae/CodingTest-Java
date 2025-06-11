import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String dirs) {
        Set<String> set = new HashSet<>();
        int x = 0;
        int y = 0;

        for (char dir : dirs.toCharArray()) {
            int nx = x;
            int ny = y;

            if (dir == 'U') {
                ny++;
            } else if (dir == 'D') {
                ny--;
            } else if (dir == 'L') {
                nx--;
            } else if (dir == 'R') {
                nx++;
            }

            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) {
                continue;
            }

            String path = x + " " + y + " " + nx + " " + ny;
            String reversePath = nx + " " + ny + " " + x + " " + y;

            set.add(path);
            set.add(reversePath);

            x = nx;
            y = ny;
        }

        return set.size() / 2;
    }
}