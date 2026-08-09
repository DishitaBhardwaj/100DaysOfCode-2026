def postfix_to_prefix(s):
    stack = []
    operators = {"+", "-", "*", "/"}

    for c in s:
        if c.isupper():
            stack.append(c)
        elif c in operators:
            op2 = stack.pop()
            op1 = stack.pop()
            stack.append(c + op1 + op2)
    return stack[0]