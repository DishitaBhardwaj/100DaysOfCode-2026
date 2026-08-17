arr=list(map(int, input("Enter elements: ").split()))
a=[]
a.append(min(arr))
a.append(max(arr))
for i in arr:
  if i not in a:
    a.append(i)
count=0
for i in range(len(a)):
  b=a[:i+1]
  count=count+(max(b)-min(b))
print(count)
