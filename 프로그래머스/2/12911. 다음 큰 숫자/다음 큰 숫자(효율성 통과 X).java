class Solution {
    public int solution(int n) {
        int answer = 0;

        String binaryN = Integer.toBinaryString(n);
        String[] strN = binaryN.split("");
        int sumN = 0;
        for (String s : strN) {
            if (s.equals("1")) {
                sumN++;
            }
        }

        int num = n + 1;
        while (true) {
            String binaryNum = Integer.toBinaryString(num);
            String[] strNum = binaryNum.split("");
            int sumNum = 0;
            for (String s : strNum) {
                if (s.equals("1")) {
                    sumNum++;
                }
            }

            if (sumN != sumNum) {
                num++;
            } else {
                answer = num;
                break;
            }
        }

        return answer;
    }
}
