#Convert a valid postfix expression consisting of uppercase letters (A–Z) as operands and the operators
#+,-,*,/ (no parentheses, whitespace, or invalid characters) into its equivalent prefix expression using a stack based approach.
#Input:s = "ABC/-AK/L-*". Output:"*-A/BC-/AKL"
postfix = input("Enter a valid postfix expression: ")
stack = []
operators = {'+', '-', '*', '/'}
for ch in postfix:
    if ch.isalpha() and ch.isupper():   
        stack.append(ch)
    elif ch in operators:               
        op2 = stack.pop()
        op1 = stack.pop()
        temp = ch + op1 + op2
        stack.append(temp)
print("Prefix Expression:", stack.pop())