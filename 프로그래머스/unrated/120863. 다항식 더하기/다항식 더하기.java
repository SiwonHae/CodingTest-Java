class Solution {
    public String solution(String polynomial) {
        String answer = "";

        String[] exprSplit = polynomial.split(" ");
        int coefficients = 0;
        int constant = 0;

        for (String expr : exprSplit) {
            if (expr.contains("x")) {
                if (expr.equals("x")) {
                    coefficients++;
                } else {
                    String parsing = expr.replace("x", "");
                    coefficients += Integer.parseInt(parsing);
                }
            } else if (!expr.equals("+")) {
                constant += Integer.parseInt(expr);
            }
        }
        
        if (coefficients == 1 && constant == 0) {
            answer += "x";
        } else if (coefficients == 0) {
            answer += String.valueOf(constant);
        } else {
            if (coefficients == 1) {
                answer += "x";
            } else {
                answer += String.valueOf(coefficients) + "x";
            }
            if (constant != 0) {
                answer += " + " + String.valueOf(constant);
            }
        }

        return answer;
    }
}