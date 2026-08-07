def find_anagrams(log, pattern):
    if len(pattern) > len(log):
        return []

    p_count = [0] * 26
    window = [0] * 26

    for ch in pattern:
        p_count[ord(ch) - ord('a')] += 1

    k = len(pattern)

    for i in range(k):
        window[ord(log[i]) - ord('a')] += 1

    result = []

    if window == p_count:
        result.append(0)

    for i in range(k, len(log)):
        window[ord(log[i]) - ord('a')] += 1
        window[ord(log[i - k]) - ord('a')] -= 1

        if window == p_count:
            result.append(i - k + 1)

    return result

log = input("Enter log string: ")
pattern = input("Enter pattern: ")

print(find_anagrams(log, pattern))