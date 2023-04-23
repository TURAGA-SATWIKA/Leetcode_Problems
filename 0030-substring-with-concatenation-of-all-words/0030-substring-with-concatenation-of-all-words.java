class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        int wordLen = words[0].length();
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        int windowSize = wordLen * words.length;
        int n = s.length();
        for (int i = 0; i <= n - windowSize; i++) {
            Map<String, Integer> substringCount = new HashMap<>();
            for (int j = 0; j < windowSize; j += wordLen) {
                String substring = s.substring(i + j, i + j + wordLen);
                substringCount.put(substring, substringCount.getOrDefault(substring, 0) + 1);
            }
            if (substringCount.equals(wordCount)) {
                result.add(i);
            }
        }
        return result;
 
    }
}