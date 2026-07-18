def postfixToPrefix(s):
    stack = []
    operators = {'+', '-', '*', '/'}
    for ch in s:
        if ch not in operators:
            stack.append(ch)
        else:
            op2 = stack.pop()
            op1 = stack.pop()
            stack.append(ch + op1 + op2)
    return stack[-1]
s = input()
print(postfixToPrefix(s))