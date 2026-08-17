rocks=list(map(int,input("Enter elements: ").split()))
while len(rocks)>1:
  a=max(rocks)
  rocks.remove(a)
  b=max(rocks)
  rocks.remove(b)
  if a!=b:
    rocks.append(a-b)
if len(rocks)==1:
  print(rocks[0])
else:
  print(0)
