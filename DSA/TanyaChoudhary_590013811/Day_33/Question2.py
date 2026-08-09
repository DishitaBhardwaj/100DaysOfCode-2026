def postfixToPrefix(expression):
    stack = []
    operators = set(['+', '-', '*', '/'])
    
    for c in expression:
        if c not in operators:
            stack.append(c)
        else:
            op1 = stack.pop()
            op2 = stack.pop()
            prefix = c + op2 + op1
            stack.append(prefix)
    
    return stack[0]

print(postfixToPrefix("AB+C*"))
print(postfixToPrefix("ABC*+D/"))