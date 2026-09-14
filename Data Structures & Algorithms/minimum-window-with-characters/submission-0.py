class Solution(object):
    def minWindow(self, s, t):
        from collections import Counter

        need = Counter(t)
        window = {}

        left = 0
        have = 0
        need_count = len(need)

        result = ""
        result_len = float("inf")

        for right in range(len(s)):
            ch = s[right]

            # Character window mein add karo
            window[ch] = window.get(ch, 0) + 1

            # Required character ki sufficient quantity mil gayi
            if ch in need and window[ch] == need[ch]:
                have += 1

            # Window valid hai
            while have == need_count:

                # Smallest answer save karo
                if right - left + 1 < result_len:
                    result_len = right - left + 1
                    result = s[left:right + 1]

                # Left character remove karo
                left_ch = s[left]
                window[left_ch] -= 1

                if left_ch in need and window[left_ch] < need[left_ch]:
                    have -= 1

                left += 1

        return result
