class Solution {
    public int[] solution(String s) {
        // 이진 변환의 횟수와 제거된 0의 개수 반환

        int[] answer = new int[2];
        int transferCnt = 0;
        int removeZeroCnt = 0;

        while (!s.equals("1")) {
            String[] str = s.split("");
            int removeZeroLength = str.length;
            String removeStr = "";

            for (int i = 0; i < removeZeroLength; i++) {
                if (str[i].equals("1")) {
                    removeStr += "1";
                } else if (str[i].equals("0")) {
                    removeZeroCnt++;
                }
            }

            transferCnt++;
            removeZeroLength = removeStr.length();
            s = Integer.toBinaryString(removeZeroLength);
        }

        answer[0] = transferCnt;
        answer[1] = removeZeroCnt;

        return answer;
    }
}