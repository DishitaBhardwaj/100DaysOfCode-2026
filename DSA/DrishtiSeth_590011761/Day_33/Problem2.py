stack = []

postfix = input()

operators = "+-*/"

for ch in postfix:
    if ch not in operators:
        stack.append(ch)
    else:
        op2 = stack.pop()
        op1 = stack.pop()
        stack.append(ch + op1 + op2)

print(stack[-1])
