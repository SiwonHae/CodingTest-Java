class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        int width = park.length;
        int height = park[0].length();

        int[][] p = new int[width][height];

        int currentX = 0;
        int currentY = 0;
        // 지나갈 수 있는 지점 = 0, 시작 지점 = 1, 장애물 = 2
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (park[i].charAt(j) == 'O') {
                    p[i][j] = 0;
                } else if (park[i].charAt(j) == 'S') {
                    p[i][j] = 1;
                    currentX = i;
                    currentY = j;
                } else {
                    p[i][j] = 2;
                }
            }
        }

        System.out.println("시작 좌표 : " + currentX + " " + currentY);

        for (int i = 0; i < routes.length; i++) {
            String command = routes[i];
            String dir = command.split(" ")[0];
            int move = Integer.parseInt((command.split(" ")[1]));

            System.out.println(dir + " " + move);

            if (dir.equals("E")) {
                System.out.println("현재 좌표 : " + currentX + " " + currentY);

                int tempY = currentY;
                if (currentY + move >= height) {
                    System.out.println("공원 탈출");
                    continue;
                }
                for (int j = 0; j < move; j++) {
                    currentY++;
                    if (p[currentX][currentY] == 2) {
                        System.out.println("장애물 충돌");
                        currentY = tempY;
                        break;
                    }
                }
            } else if (dir.equals("W")) {
                System.out.println("현재 좌표 : " + currentX + " " + currentY);

                int tempY = currentY;
                if (currentY - move < 0) {
                    System.out.println("공원 탈출");
                    continue;
                }
                for (int j = 0; j < move; j++) {
                    currentY--;
                    if (p[currentX][currentY] == 2) {
                        System.out.println("장애물 충돌");
                        currentY = tempY;
                        break;
                    }
                }
            } else if (dir.equals("S")) {
                System.out.println("현재 좌표 : " + currentX + " " + currentY);

                int tempX = currentX;
                if (currentX + move >= width) {
                    System.out.println("공원 탈출");
                    continue;
                }
                for (int j = 0; j < move; j++) {
                    currentX++;
                    if (p[currentX][currentY] == 2) {
                        System.out.println("장애물 충돌");
                        currentX = tempX;
                        break;
                    }
                }
            } else {
                System.out.println("현재 좌표 : " + currentX + " " + currentY);

                int tempX = currentX;
                if (currentX - move < 0) {
                    System.out.println("공원 탈출");
                    continue;
                }
                for (int j = 0; j < move; j++) {
                    currentX--;
                    if (p[currentX][currentY] == 2) {
                        System.out.println("장애물 충돌");
                        currentX = tempX;
                        break;
                    }
                }
            }
        }

        answer[0] = currentX;
        answer[1] = currentY;

        return answer;
    }
}