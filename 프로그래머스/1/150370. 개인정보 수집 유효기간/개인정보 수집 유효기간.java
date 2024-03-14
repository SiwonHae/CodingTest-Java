import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String type = terms[i].substring(0, 1);
            int validMonth = Integer.parseInt(terms[i].substring(2));

            map.put(type,validMonth);
        }
        List<String> list = new ArrayList<>(map.keySet());

        String[] todayDate = today.substring(0, 10).split("\\.");
        int todayYear = Integer.parseInt(todayDate[0]);
        int todayMonth = Integer.parseInt(todayDate[1]);
        int todayDay = Integer.parseInt(todayDate[2]);
        long todayTotalDay = ((long) todayYear * 12 + todayMonth) * 28 + todayDay;

        for (int i = 0; i < privacies.length; i++) {
            String tmpDate = privacies[i].substring(0, 10);
            String type = privacies[i].substring(11);

            String[] date = tmpDate.split("\\.");
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]);
            long totalDay = ((long) year * 12 + month) * 28 + day;
            long diff = todayTotalDay - totalDay;

            for (int j = 0; j < list.size(); j++) {
                if (type.equals(list.get(j))) {
                    int validMonth = map.get(type) * 28;

                    if (diff >= validMonth) {
                        result.add(i + 1);
                    }
                    break;
                }
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}