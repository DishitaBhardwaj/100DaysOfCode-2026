l=[]
ans=[]
n=int(input("Enter size: "))
for i in range (n):
    a=int(input("Enter temp: "))
    l.append(a)
k=int(input("Enter k: "))
for i in range(n+1-k):
    m=[]
    for j in range (k):
        m.append(l[i+j])
    ans.append(max(m))
print(f"output: {ans}")    
