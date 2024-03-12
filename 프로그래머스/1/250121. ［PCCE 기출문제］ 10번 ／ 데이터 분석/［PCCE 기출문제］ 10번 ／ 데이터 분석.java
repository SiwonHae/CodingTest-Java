import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // code, date, maximum, remain 순서대로 data에 저장됨.
        // data 에서 ext 값이 val_ext 보다 작은 데이터를 추출
        // sort_by 값을 기준으로 오름차순 정렬

        String[] dataType = {"code", "date", "maximum", "remain"};
        List<int[]> list = new ArrayList<>();

        int extIdx = 0;
        int sortIdx = 0;
        for (int i = 0; i < 4; i++) {
            if (dataType[i].equals(ext)) {
                extIdx = i;
            }
            if (dataType[i].equals(sort_by)) {
                sortIdx = i;
            }
        }

        for (int[] datum : data) {
            if (datum[extIdx] < val_ext) {
                list.add(datum);
            }
        }

        final int finalSortIdx = sortIdx;
        Collections.sort(list, Comparator.comparingInt(o -> o[finalSortIdx]));

        int[][] answer = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
