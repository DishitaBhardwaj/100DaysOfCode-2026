#Question 2: Write an efficient function that returns all starting indices of substrings in a string log that are anagrams 
#of a given string pattern.
#Input: log = "cbaebabacd", pattern = "abc". Output: [0, 6].
from collections import Counter

def find_anagrams(log, pattern):
    if len(pattern) > len(log):
        return []
    result = []
    p_count = Counter(pattern)
    window_count = Counter()
    left = 0
    for right in range(len(log)):
        window_count[log[right]] += 1
        if right - left + 1 > len(pattern):
            window_count[log[left]] -= 1
            if window_count[log[left]] == 0:
                del window_count[log[left]]
            left += 1
        if window_count == p_count:
            result.append(left)
    return result

log = input("Enter log string: ")
pattern = input("Enter pattern string: ")
print("Output:", find_anagrams(log, pattern))
