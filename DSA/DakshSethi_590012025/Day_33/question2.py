class Solution:
    def postToPre(self, s):
        stack = []

        for ch in s:
            if ch.isalpha():
                stack.append(ch)
            else:
                op2 = stack.pop()
                op1 = stack.pop()
                stack.append(ch + op1 + op2)

        return stack[-1]