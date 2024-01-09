class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        
        int[][] newBoard = new int[board.length + 2][board.length + 2];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    newBoard[i + 1][j + 1] = 1;

                    newBoard[i][j] = 3;
                    newBoard[i + 1][j] = 3;
                    newBoard[i + 2][j] = 3;

                    newBoard[i][j + 1] = 3;
                    newBoard[i + 2][j + 1] = 3;

                    newBoard[i][j + 2] = 3;
                    newBoard[i + 1][j + 2] = 3;
                    newBoard[i + 2][j + 2] = 3;
                }
            }
        }

        for (int i = 1; i < board.length + 1; i++) {
            for (int j = 1; j < board.length + 1; j++) {
                if (newBoard[i][j] == 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}