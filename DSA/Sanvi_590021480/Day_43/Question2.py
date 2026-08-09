arr=list(map(int,input("Enter array: ").split()))
arr.sort()
ans=0
for i in range(0,len(arr),2):
  ans=ans+arr[i]
print(ans)
    
  
