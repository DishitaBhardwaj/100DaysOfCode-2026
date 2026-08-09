nums=list(map(int, input("Enter elements: ").split()))
favindex=int(input("Enter favourite index: "))
k=int(input("Enter k: "))

favno=nums[favindex-1]
g,e=0,0
for i in nums:
  if i>favno:
    g+=1
  if i==favno:
    e+=1

if g>=k:
  print("NO")
elif g+e<=k:
  print("YES")
else:
  print("MAYBE")
