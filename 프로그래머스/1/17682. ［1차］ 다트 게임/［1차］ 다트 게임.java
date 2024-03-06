class Solution {
    public int solution(String dartResult) {
        int answer = 0;

        String[] s = dartResult.split("");

        int cnt = 0; // 기회 체크(1, 2, 3)
        String s1 = "";
        String s2 = "";
        String s3 = "";
        int firstScore = 0;
        int secondScore = 0;
        int thirdScore = 0;
        String firstBonus = "";
        String secondBonus = "";
        String thirdBonus = "";

        for (int i = 0; i < s.length; i++) {
            if (Character.isDigit(s[i].charAt(0))) {
                cnt++;
                if (cnt == 1) {
                    s1 += s[i]; // 점수
                    if (Character.isDigit(s[i + 1].charAt(0))) {
                        s1 += s[i + 1];
                        i++;
                    }
                    firstScore = Integer.parseInt(s1);
                    s1 += s[i + 1]; // 보너스
                    firstBonus = s[i + 1];
                }

                if (cnt == 2) {
                    s2 += s[i]; // 점수
                    if (Character.isDigit(s[i + 1].charAt(0))) {
                        s2 += s[i + 1];
                        i++;
                    }
                    secondScore = Integer.parseInt(s2);
                    s2 += s[i + 1]; // 보너스
                    secondBonus = s[i + 1];
                }

                if (cnt == 3) {
                    s3 += s[i]; // 점수
                    if (Character.isDigit(s[i + 1].charAt(0))) {
                        s3 += s[i + 1];
                        i++;
                    }
                    thirdScore = Integer.parseInt(s3);
                    s3 += s[i + 1]; // 보너스
                    thirdBonus = s[i + 1];
                }
            }

            if (s[i].equals("*")) {
                if (cnt == 1) {
                    s1 += "*";
                }
                if (cnt == 2) {
                    s2 += "*";
                }
                if (cnt == 3) {
                    s3 += "*";
                }
            }

            if (s[i].equals("#")) {
                if (cnt == 1) {
                    s1 += "#";
                }
                if (cnt == 2) {
                    s2 += "#";
                }
                if (cnt == 3) {
                    s3 += "#";
                }
            }
        }

        if (firstBonus.equals("D")) {
            firstScore *= firstScore;
        } else if (firstBonus.equals("T")) {
            firstScore *= firstScore * firstScore;
        }
        if (secondBonus.equals("D")) {
            secondScore *= secondScore;
        } else if (secondBonus.equals("T")) {
            secondScore *= secondScore * secondScore;
        }
        if (thirdBonus.equals("D")) {
            thirdScore *= thirdScore;
        } else if (thirdBonus.equals("T")) {
            thirdScore *= thirdScore * thirdScore;
        }

        if (s1.contains("*")) {
            firstScore *= 2;
        }
        if (s1.contains("#")) {
            firstScore *= -1;
        }

        if (s2.contains("*")) {
            firstScore *= 2;
            secondScore *= 2;
        }
        if (s2.contains("#")) {
            secondScore *= -1;
        }

        if (s3.contains("*")) {
            secondScore *= 2;
            thirdScore *= 2;
        }
        if (s3.contains("#")) {
            thirdScore *= -1;
        }

        answer = firstScore + secondScore + thirdScore;

        return answer;
    }
}