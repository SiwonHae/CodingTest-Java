import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // fees 요금표
        // 기본시간(분), 기본요금, 단위시간(분), 단위요금
        // 초과한 시간이 단위시간으로 나누어 떨어지지 않으면 "올림"한다.

        // 00:00 ~ 23:59 까지의 입/출차 내역
        // 출차 내역 없으면 23:59에 출차 한것으로 간주함.

        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        Map<String, String> enterMap = new HashMap<>();
        Map<String, Integer> feeMap = new HashMap<>();
        List<String> numberList = new ArrayList<>();

        for (int i = 0; i < records.length; i++) {
            String[] info = records[i].split(" ");
            String enterTime = "";
            String number = info[1];
            if (!numberList.contains(number)) {
                numberList.add(number);
            }
            String cmd = info[2];

            if (cmd.equals("IN")) {
                enterTime = info[0];
                enterMap.put(number, enterTime);
            } else if (cmd.equals("OUT")) {
                String[] prevEnterTimeStr = enterMap.get(number).split(":");
                int prevEnterTime = Integer.parseInt(prevEnterTimeStr[0]) * 60 + Integer.parseInt(prevEnterTimeStr[1]);
                String[] curOutTimeStr = info[0].split(":");
                int curOutTime = Integer.parseInt(curOutTimeStr[0]) * 60 + Integer.parseInt(curOutTimeStr[1]);
                enterMap.remove(number); // enterMap 에서 삭제

                int diff = curOutTime - prevEnterTime;
                if (!feeMap.containsKey(number)) {
                    feeMap.put(number, diff);
                } else {
                    int existingTime = feeMap.get(number);
                    feeMap.put(number, diff + existingTime);
                }
            }
        }

        for (String num : enterMap.keySet()) {
            // enterMap에 아직 남아있는 번호판들은 출차를 하지 않았음.
            // 23:59에 출차 한 것으로 간주함.

            String[] prevEnterTimeStr = enterMap.get(num).split(":");
            int prevEnterTime = Integer.parseInt(prevEnterTimeStr[0]) * 60 + Integer.parseInt(prevEnterTimeStr[1]);
            int lastTime = 23 * 60 + 59;
            int diff = lastTime - prevEnterTime;

            if (!feeMap.containsKey(num)) {
                feeMap.put(num, diff);
            } else {
                int existingTime = feeMap.get(num);
                feeMap.put(num, diff + existingTime);
            }
        }

        Collections.sort(numberList);

        int[] answer = new int[feeMap.size()];

        for (int i = 0; i < feeMap.size(); i++) {
            int totalFee = basicFee;
            int time = feeMap.get(numberList.get(i));

            if (time > basicTime) {
                int overTime = time - basicTime;
                totalFee += Math.ceil((double) overTime / (double) unitTime) * unitFee;
            }

            answer[i] = totalFee;
        }


        return answer;
    }
}