class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 단어에 포함된 알파벳이 순서와 관계없이 동일하면 애너그램이다.

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();

            Arrays.sort(chars);

            String word = String.valueOf(chars);

            if (!map.containsKey(word)) {
                map.put(word, new ArrayList<>());
            }

            map.get(word).add(s);
        }

        return new ArrayList<>(map.values());
    }
}