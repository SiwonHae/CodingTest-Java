import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Deque<Integer> basket = new ArrayDeque<>();
        
        for (int i = 0; i < moves.length; i++) {
            int move = moves[i] - 1;
            
            for (int j = 0; j < board.length; j++) {
                if (board[j][move] != 0) {
                    // 바구니 최상단과 같은 인형이면 터트린다.
                    if (!basket.isEmpty() && basket.peek() == board[j][move]) {
                        basket.pop();
                        answer += 2;
                    } else {
                        basket.push(board[j][move]);
                    }
                    
                    board[j][move] = 0;
                    break;
                }
            }
        }
        
        return answer;
    }
}