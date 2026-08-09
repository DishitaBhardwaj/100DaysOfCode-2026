def securityScanner(log, pattern):
    result = []
    p_len = len(pattern)
    l_len = len(log)
    
    p_count = [0] * 26
    w_count = [0] * 26
    
    for c in pattern:
        p_count[ord(c) - ord('a')] += 1
    
    for i in range(l_len):
        w_count[ord(log[i]) - ord('a')] += 1
        
        if i >= p_len:
            w_count[ord(log[i - p_len]) - ord('a')] -= 1
        
        if w_count == p_count:
            result.append(i - p_len + 1)
    
    return result

print(securityScanner("cbaebabacd", "abc"))
print(securityScanner("abab", "ab"))