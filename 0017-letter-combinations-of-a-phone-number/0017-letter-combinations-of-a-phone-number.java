class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtrack(digits, map, new StringBuilder(), result);
        return result;
    }
    private void backtrack(String digits, Map<Character, String> map, StringBuilder sb, List<String> result) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String letters = map.get(digits.charAt(sb.length()));
        for (char c : letters.toCharArray()) {
            sb.append(c);
            backtrack(digits, map, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}