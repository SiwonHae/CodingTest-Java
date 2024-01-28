class Solution {

    public int searchIdNumber(String[] id_list, String name) {
        // muzi : 0
        // frodo : 1
        // apeach : 2
        // neo : 3

        for (int i = 0; i < id_list.length; i++) {
            if (id_list[i].equals(name)) {
                return i;
            }
        }

        // 실패하지 않음.
        return 0;
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        int[][] reportMatrix = new int[id_list.length][id_list.length];
        for (int i = 0; i < report.length; i++) {
            String reporter = report[i].split(" ")[0];
            String target = report[i].split(" ")[1];
            int reporterNum = searchIdNumber(id_list, reporter);
            int targetNum = searchIdNumber(id_list, target);
            reportMatrix[reporterNum][targetNum]++;
        }

        int[] reportedNum = new int[id_list.length]; // 신고 당한 횟수
        for (int i = 0; i < reportMatrix.length; i++) {
            for (int j = 0; j < reportMatrix.length; j++) {
                if (reportMatrix[i][j] > 0) {
                    reportedNum[j]++;
                }
            }
        }

        int[] bannedNum = new int[id_list.length]; // 정지 당한 아이디 번호
        for (int i = 0; i < reportedNum.length; i++) {
            if (reportedNum[i] >= k) {
                bannedNum[i] = 1;
            }
        }

        for (int i = 0; i < reportMatrix.length; i++) {
            int cnt = 0; // 결과 메일 수
            for (int j = 0; j < reportMatrix.length; j++) {
                if (reportMatrix[i][j] > 0) {
                    // 내가 신고한 사람이 정지 되었는지 확인
                    if (bannedNum[j] == 1) {
                        cnt++; // 정지 되었다면 메일을 받자.
                    }
                }
            }
            answer[i] = cnt;
        }


        return answer;
    }
}