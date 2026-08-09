s = input()

stack = []

for ch in s:
    if ch.isalpha():
        stack.append(ch)
    else:
        op2 = stack.pop()
        op1 = stack.pop()
        exp = ch + op1 + op2
        stack.append(exp)

print(stack.pop())