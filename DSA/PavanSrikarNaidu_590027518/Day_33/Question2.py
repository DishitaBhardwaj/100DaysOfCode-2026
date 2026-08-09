def postfix_to_prefix(s):
    stack = []
    operators = set("+-*/")

    for ch in s:
        # Operand
        if 'A' <= ch <= 'Z':
            stack.append(ch)
        
        # Operator
        elif ch in operators:
            op2 = stack.pop()
            op1 = stack.pop()

            expr = ch + op1 + op2
            stack.append(expr)

    return stack[-1]


# Example
s = "ABC/-AK/L-*"
print(postfix_to_prefix(s))