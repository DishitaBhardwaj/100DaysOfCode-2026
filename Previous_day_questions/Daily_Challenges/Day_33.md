<h2 align="center">Week 5 Day 33 (17/07/2026)</h2>

## 1. Remove Outermost Parentheses (LeetCode #1021)
A problem that teaches string parsing and depth tracking by stripping the outermost parentheses from every primitive decomposition of a valid parentheses string. A valid parentheses string is called primitive if it is non-empty and cannot be split into two non empty valid parentheses strings. Given a valid parentheses string s, decompose it into its primitive parts and remove the outermost parentheses of each part. Return the resulting string.

This problem is commonly asked in interviews and helps build concepts like:
- Stack simulation
- String building and character filtering

which are important for efficient stack and string manipulation problem solving.

**Your task:** Remove the outermost parentheses of every primitive part of the given valid parentheses string and return the resulting string.

### Examples

**Input:**
```
s = "(()())(())"
```
**Output:**
```
"()()()"
```

---

**Input:**
```
s = "(()())(())(()(()))"
```
**Output:**
```
"()()()()(())"
```

---

## 2. Postfix to Prefix Conversion
A problem that builds expertise in expression parsing and stack based transformations by directly converting a postfix expression into its equivalent prefix form. Before diving into the problem, it helps to understand the two expression notations: Postfix, where the operator appears after its operands in the form (operand1 operand2 operator), for example AB+CD-* which equals (A+B)*(C-D) in infix; and Prefix, where the operator appears before its operands in the form (operator operand1 operand2), for example *+AB-CD which equals (A+B)*(C-D) in infix. Given a valid postfix expression, convert it directly into its equivalent prefix expression. Rather than converting postfix to infix first and then to prefix, a single-pass stack-based approach allows an efficient and direct transformation.

This problem is commonly asked in interviews and helps build concepts like:
- Stack operations
- Operator and operand identification

which are important for efficient expression evaluation problems.

**Your task:** Convert the given postfix expression into its equivalent prefix expression using an optimized approach.

### Examples

**Input:**
```
s = "AB+CD-*"
```
**Output:**
```
"*+AB-CD"
```

---

**Input:**
```
s = "ABC/-AK/L-*"
```
**Output:**
```
"*-A/BC-/AKL"
```

---
