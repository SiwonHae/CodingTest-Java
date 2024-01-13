class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];

        int maxX = board[0] / 2;
        int minX = -maxX;
        int maxY = board[1] / 2;
        int minY = -maxY;

        int curX = 0;
        int curY = 0;

        for (int i = 0; i < keyinput.length; i++) {

            if (keyinput[i].equals("left")) {
                curX--;
                if (curX <= minX) {
                    curX = minX;
                }
            } else if (keyinput[i].equals("right")) {
                curX++;
                if (curX >= maxX) {
                    curX = maxX;
                }
            } else if (keyinput[i].equals("up")) {
                curY++;
                if (curY >= maxY) {
                    curY = maxY;
                }
            } else { // down
                curY--;
                if (curY <= minY) {
                    curY = minY;
                }
            }
        }

        answer[0] = curX;
        answer[1] = curY;

        return answer;
    }
}