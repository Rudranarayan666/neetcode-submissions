
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        int windowSize = s1.length();

        for (int i = 0; i < windowSize; i++) {
            windowCount[s2.charAt(i) - 'a']++;
        }

        if (matches(s1Count, windowCount)) {
            return true;
        }

        for (int right = windowSize; right < s2.length(); right++) {
            // Add right character
            windowCount[s2.charAt(right) - 'a']++;

            // Remove left character
            int left = right - windowSize;
            windowCount[s2.charAt(left) - 'a']--;

            if (matches(s1Count, windowCount)) {
                return true;
            }
        }

        return false;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }
}
