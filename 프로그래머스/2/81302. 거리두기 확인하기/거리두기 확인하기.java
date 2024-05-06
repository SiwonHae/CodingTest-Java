import java.util.*;

class Solution {

    // x 변화량 (상, 좌, 우, 하)
    private static final int dx[] = {0, -1, 1, 0};
    // y 변화량 (상, 좌, 우, 하)
    private static final int dy[] = {-1, 0, 0, 1};

    // 거리두기 검사 메서드 (대기실)
    private boolean isDistanced(char[][] room) {
        for (int y = 0; y < room.length; y++) {
            for (int x = 0; x < room[0].length; x++) {
                if (room[y][x] != 'P') {
                    continue;
                }
                if (!isDistanced(room, x, y)) {
                    return false;
                }
            }
        }

        return true;
    }

    // 거리두기 검사 메서드 (대기실의 x, y 좌표에 있는 사람)
    private boolean isDistanced(char[][] room, int x, int y) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) {
                continue;
            }

            switch (room[ny][nx]) {
                case 'P':
                    return false;
                case 'O':
                    if (isNextToVolunteer(room, nx, ny, 3 - d)) {
                        return false;
                    }
                    break;
            }
        }

        return true;
    }

    private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude) {
        for (int d = 0; d < 4; d++) {
            if (d == exclude) {
                continue;
            }

            int nx = x + dx[d];
            int ny = y + dy[d];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) {
                continue;
            }
            if (room[ny][nx] == 'P') {
                return true;
            }
        }

        return false;
    }

    public int[] solution(String[][] places) {
        // 대기실은 5 x 5 크기.
        // 맨해튼 거리 |x1 - x2| + |y1 - y2|

        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            String[] place = places[i];
            char[][] room = new char[5][5];

            for (int j = 0; j < places[0].length; j++) {
                room[j] = place[j].toCharArray();
            }

            if (isDistanced(room)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }
}