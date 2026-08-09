goals=list(map(str,input("Enter team names: ").split()))
maxi=0
for i in goals:
  if goals.count(i)>maxi:
    maxi=goals.count(i)
    ans=i
print(ans)
