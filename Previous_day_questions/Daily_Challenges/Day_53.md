<h2 align="center">Week 8 Day 4 (06/08/2026)</h2>

## 1. Substrings of Size Three with Distinct Characters

A problem that teaches sliding window techniques and string traversal by identifying substrings with unique characters.

A string is good if there are no repeated characters. Given a string `s`, return the number of good substrings of length three in `s`. Note that if there are multiple occurrences of the same substring, every occurrence should be counted. A substring is a contiguous sequence of characters in a string.

This problem is commonly asked in interviews and helps build concepts like:
- Sliding window technique
- String traversal
- Character frequency checks
- Optimization techniques

which are important for solving string-processing problems efficiently.

**Your task:** Return the number of good substrings of length three in `s`.

### Examples

**Input:**
```
s = "xyzzaz"
```
**Output:**
```
1
```
---
**Input:**
```
s = "aababcabc"
```
**Output:**
```
4
```

---

## 2. The Security Scanner

A problem that introduces sliding window and frequency-counting techniques by identifying anagram substrings within a larger string.

A company's security system records every badge swipe made at the main entrance throughout the day. The complete access history is stored as a string `log`, where each character represents a badge swipe. The security team has identified a suspicious badge sequence called `pattern`. They want to find every group of consecutive badge swipes in the log that contains exactly the same characters as `pattern`, regardless of their order. A substring is considered suspicious if it is an anagram of the pattern.

This problem appears frequently in interviews and real-world applications like intrusion detection, log analysis, and pattern matching systems. The challenge involves efficiently tracking character frequencies within a moving window.

This teaches:
- Sliding window technique
- Frequency map comparison
- Array/string traversal
- Optimization techniques

which are essential for efficient string processing and interview problem solving.

**Your task:** Return all starting indices of substrings in `log` that are anagrams of `pattern`.

### Examples

**Input:**
```
log = "cbaebabacd"
pattern = "abc"
```
**Output:**
```
[0, 6]
```
---
**Input:**
```
log = "abab"
pattern = "ab"
```
**Output:**
```
[0, 1, 2]
```
---
**Input:**
```
log = "af"
pattern = "be"
```
**Output:**
```
[]
```
