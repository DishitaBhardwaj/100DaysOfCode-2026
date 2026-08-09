class Solution(object):
    def minLength(self, s):

        abcd = []

        for char in s:
            if abcd and ((abcd[-1] == 'A' and char == 'B') or abcd[-1] == 'C' and char == 'D'):
                abcd.pop()

            else:
                abcd.append(char)

        return len(abcd)