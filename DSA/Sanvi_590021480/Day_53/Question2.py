log=input("Enter the string: ")
pattern=input("Enter pattern: ")
n=len(pattern)
ans=[]
for i in range(len(log)):
  a=log[i:i+n]
  if sorted(a)==sorted(pattern):
    ans.append(i)
print(ans)
