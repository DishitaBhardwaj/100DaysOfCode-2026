class Solution:
    def findAnagrams(self, log, pattern):
        if len(pattern) > len(log):
            return []

        result = []
        p_count = [0] * 26
        w_count = [0] * 26

        # Frequency count for pattern and first window
        for i in range(len(pattern)):
            p_count[ord(pattern[i]) - ord('a')] += 1
            w_count[ord(log[i]) - ord('a')] += 1

        # Check first window
        if p_count == w_count:
            result.append(0)

        # Slide the window
        for i in range(len(pattern), len(log)):
            w_count[ord(log[i]) - ord('a')] += 1
            w_count[ord(log[i - len(pattern)]) - ord('a')] -= 1

            if p_count == w_count:
                result.append(i - len(pattern) + 1)

        return result


# For VS Code testing
if __name__ == "__main__":
    log = "cbaebabacd"
    pattern = "abc"

    sol = Solution()
    print(sol.findAnagrams(log, pattern))