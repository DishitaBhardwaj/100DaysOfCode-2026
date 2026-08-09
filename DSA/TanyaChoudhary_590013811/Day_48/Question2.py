def assemblyViaMinimums(n, b):
    b.sort()
    
    result = [b[0]]
    step = n - 1
    i = step
    
    while len(result) < n:
        result.append(b[i])
        step -= 1
        i += step
    
    return result

print(assemblyViaMinimums(3, [4, 2, 2]))
print(assemblyViaMinimums(4, [1, 1, 1, 2, 2, 3]))