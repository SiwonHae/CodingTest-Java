import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        List<Integer> bucket = new ArrayList<>();

        for (int i = 0; i < moves.length; i++) {
            int pos = moves[i] - 1; // 크레인 뽑을 자리

            for (int j = 0; j < board[0].length; j++) {
                if (board[j][pos] != 0) {
                    int doll = board[j][pos]; // 뽑기할 인형 번호
                    board[j][pos] = 0;

                    if (bucket.size() == 0) {
                        bucket.add(doll);
                    } else {
                        if (bucket.get(bucket.size() - 1) == doll) {
                            bucket.remove(bucket.size() - 1);
                            answer++;
                        } else {
                            bucket.add(doll);
                        }
                    }

                    break;
                }
            }
        }

        answer = answer * 2;

        return answer;
    }
}