class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String previous = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 0; i < previous.length(); i++) {
            if (i + 1 < previous.length() && previous.charAt(i) == previous.charAt(i + 1)) {
                count++;
            } else {
                result.append(count).append(previous.charAt(i));
                count = 1;
            }
        }
        return result.toString();
    }
}