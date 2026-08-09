class Solution:
    def countGoodSubstrings(self, s):
        count = 0

        for i in range(len(s) - 2):
            if len(set(s[i:i+3])) == 3:
                count += 1

        return count


# For VS Code testing
if __name__ == "__main__":
    s = "xyzzaz"

    sol = Solution()
    print(sol.countGoodSubstrings(s))