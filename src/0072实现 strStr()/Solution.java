class Solution {
    public int strStr(String haystack, String needle) {
        if (0 == needle.length()) {
            return 0;
        }
        return this.search(haystack, needle);
    }

    private int[] generateNextArr(String needle) {
        int[] next = new int[needle.length()];
        int maxLength = 0;
        for (int i = 0; i < needle.length(); i++) {
            while (maxLength > 0 && needle.charAt(i) != needle.charAt(maxLength)) {
                maxLength = next[maxLength - 1];
            }
            if (needle.charAt(maxLength) == needle.charAt(i)) {
                maxLength++;
            }
            next[i] = maxLength;
        }
        return next;
    }

    private int search(String haystack, String needle) {
        int count = 0;
        int[] next = this.generateNextArr(needle);
        for (int i = 0; i < haystack.length(); i++) {
            while (count > 0 && haystack.charAt(i) != needle.charAt(count)) {
                count = next[count - 1];
            }
            if (haystack.charAt(i) == needle.charAt(count)) {
                count++;
            }
            if (count == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }
}
