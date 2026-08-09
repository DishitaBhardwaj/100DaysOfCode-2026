# Postfix to Prefix Conversion

def postfix_to_prefix(postfix):
    stack = []

    for ch in postfix:
        if ch.isalpha():
            stack.append(ch)
        else:
            operand2 = stack.pop()
            operand1 = stack.pop()
            stack.append(ch + operand1 + operand2)

    return stack[-1]


postfix = input("Enter the postfix expression: ")

print("Prefix expression:", postfix_to_prefix(postfix))