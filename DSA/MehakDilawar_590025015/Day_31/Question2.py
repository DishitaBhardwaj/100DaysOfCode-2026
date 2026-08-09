#Given an array of integers, find the first greater element on the right for every element; 
#if no greater element exists, return -1.
#Input:arr[] = [1,3,2,4]. Output:[3,4,4,-1]
def next_greater_element(arr):
    n = len(arr)
    ans = [-1] * n
    stack = []
    for i in range(n - 1, -1, -1):
        while stack and stack[-1] <= arr[i]:
            stack.pop()
        if stack:
            ans[i] = stack[-1]
        stack.append(arr[i])
    return ans

n = int(input("Enter number of elements: "))
arr = list(map(int, input("Enter elements: ").split()))
result = next_greater_element(arr)
print("Next Greater Elements:", result)