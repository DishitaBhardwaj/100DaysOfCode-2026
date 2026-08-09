temperatures=list(map(int,input("Enter temperatures: ").split()))
k=int(input("Enter k: "))
a=[]
for i in range(len(temperatures)-k+1):
  b=[]
  for j in range(k):
    b.append(temperatures[i+j])
  a.append(max(b))

print(a)

    
  
