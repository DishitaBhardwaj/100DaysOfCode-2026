<h2 align="center">Week 8 Day 3 (05/08/2026)</h2>

## 1. Check if All Characters Have Equal Number of Occurrences (LeetCode #1941)
A problem that teaches hashing and frequency counting techniques by verifying whether every character in a string occurs the same number of times. Given a string s, return true if s is a good string, or false otherwise. A string s is good if all the characters that appear in s have the same number of occurrences (i.e., the same frequency).

This problem is commonly asked in interviews and helps build concepts like:
- Hash maps
- Frequency counting
- String traversal

which are important for solving character-distribution and frequency-validation problems.

**Your task:** Return true if s is a good string, or false otherwise.

### Input
A string `s`, as described above.

**Constraints:**
- `1 <= s.length <= 1000`
- s consists of lowercase English letters.

### Output
Return true if s is a good string, otherwise return false.

### Examples

**Input:**
```
s = "abacbc"
```
**Output:**
```
true
```

---

**Input:**
```
s = "aaabb"
```
**Output:**
```
false
```

---

## 2. Username Registration System
A hash table and string processing problem that requires generating unique usernames during registration. A new website is launching its user registration system. When a user tries to register with a username, the system follows these rules: if the username has never been used before, register it and return OK. If the username already exists, create a new username by appending a number to the end of it. The system should use the smallest positive integer that makes the username unique.

This problem is commonly asked in interviews and helps build concepts like:
- Hash maps
- String concatenation
- Collision resolution

which are important for solving problems involving generating unique identifiers under naming conflicts.

**Your task:** For each registration request, output OK if the username is available. Otherwise, output the new unique username assigned by the system.

### Input
A list of registration requests `requests`, as described above.

**Constraints:**
- `1 <= n <= 100000`
- Each username contains only lowercase English letters and has length between 1 and 32 characters.

### Output
For each request, output OK or the newly assigned unique username, in order.

### Examples

**Input:**
```
requests = ["abacaba", "acaba", "abacaba", "acab"]
```
**Output:**
```
OK
OK
abacaba1
OK
```

---

**Input:**
```
requests = ["first", "first", "second", "second", "third", "third"]
```
**Output:**
```
OK
first1
OK
second1
OK
third1
```

---

**Input:**
```
requests = ["john", "john", "john", "john"]
```
**Output:**
```
OK
john1
john2
john3
```

---
