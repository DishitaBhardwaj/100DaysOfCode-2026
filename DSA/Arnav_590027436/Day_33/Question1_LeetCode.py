class Solution(object):
    def removeOuterParentheses(self, s):
        """
        :type s: str
        :rtype: str
        """
        r = []
        o = 0

        for c in s:
            if c == '(':
                if o > 0:
                    r.append(c)
                o += 1
            elif c == ')':
                if o > 1:
                    r.append(c)
                o -= 1
                
        return ''.join(r)