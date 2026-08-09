postfix=input("Enter expression: ")
stack=[]
for i in postfix:
  if i.isalnum():
    stack.append(i)
  else:
    op2=stack.pop()
    op1=stack.pop()
    stack.append(i+op1+op2)

print(stack[-1]) 
