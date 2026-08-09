postfix = input("Enter the postfix expression: ")

stack = []

operators = ['+', '-', '*', '/']

for ch in postfix:
    if ch in operators:
        op2 = stack.pop()
        op1 = stack.pop()

        expr = ch + op1 + op2
        stack.append(expr)
    else:
        stack.append(ch)

print("Prefix expression:", stack[-1])