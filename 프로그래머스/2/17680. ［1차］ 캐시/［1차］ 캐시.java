import java.util.LinkedList;
import java.util.List;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        // LRU 캐시 교체 알고리즘 사용 (연결리스트나 큐로 구현)
        // Cache Hit : CPU가 참조하고자 하는 메모리가 캐시에 존재하는 경우
        // 이때의 실행시간은 1
        // Cache Miss : CPU가 참조하고자 하는 메모가 캐시에 없는 경우
        // 이떄의 실행시간은 5

        // 캐시 사이즈가 없으므로 모두 다 Cache Miss 이다.
        if (cacheSize == 0) {
            answer = cities.length * 5;
            return answer;
        }

        List<String> cache = new LinkedList<>();
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();

            // Cache Miss 발생
            if (!cache.contains(city)) {
                answer += 5;

                // 캐시가 가득 찼다면
                if (cache.size() >= cacheSize) {
                    // 가장 앞 쪽에 있는 것이 오랫동안 사용하지 않은 캐시임.
                    cache.remove(0);
                }
                cache.add(city);
            } else {
                // Cache Hit 발생
                cache.remove(city);
                cache.add(city);
                answer++;
            }
        }

        return answer;
    }
}