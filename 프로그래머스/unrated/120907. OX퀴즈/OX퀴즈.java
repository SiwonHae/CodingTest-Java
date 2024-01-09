class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];

        int index = 0;

        for (String expr : quiz) {
            String[] exprSplit = expr.split(" ");
            int x = Integer.parseInt(exprSplit[0]);
            String symbol = exprSplit[1];
            int y = Integer.parseInt(exprSplit[2]);
            int result = Integer.parseInt(exprSplit[4]);

            if (symbol.equals("+")) {
                if (x + y == result) {
                    answer[index++] = "O";
                } else {
                    answer[index++] = "X";
                }
            } else {
                if (x - y == result) {
                    answer[index++] = "O";
                } else {
                    answer[index++] = "X";
                }
            }
        }

        return answer;
    }
}