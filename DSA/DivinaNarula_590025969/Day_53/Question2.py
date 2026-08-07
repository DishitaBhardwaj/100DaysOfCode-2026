# The Security Scanner

def find_anagrams(log, pattern):
    if len(pattern) > len(log):
        return []

    result = []

    pattern_count = [0] * 26
    window_count = [0] * 26

    for ch in pattern:
        pattern_count[ord(ch) - ord('a')] += 1

    for i in range(len(pattern)):
        window_count[ord(log[i]) - ord('a')] += 1

    if pattern_count == window_count:
        result.append(0)

    for i in range(len(pattern), len(log)):
        window_count[ord(log[i]) - ord('a')] += 1
        window_count[ord(log[i - len(pattern)]) - ord('a')] -= 1

        if pattern_count == window_count:
            result.append(i - len(pattern) + 1)

    return result


log = input("Enter log string: ")
pattern = input("Enter pattern: ")

print(find_anagrams(log, pattern))