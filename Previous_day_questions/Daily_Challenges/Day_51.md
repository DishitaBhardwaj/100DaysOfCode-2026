<h2 align="center">Week 8 Day 2 (04/08/2026)</h2>

## 1. Most Frequent Even Element (LeetCode #2404)
A problem that teaches hashing and frequency counting techniques by finding the most common even number in an array. Given an integer array nums, return the most frequent even element. If there is a tie, return the smallest one. If there is no such element, return -1.

This problem is commonly asked in interviews and helps build concepts like:
- Hash maps
- Frequency counting
- Tie-breaking logic

which are important for solving counting and frequency-based array problems.

**Your task:** Return the most frequent even element in nums, breaking ties by returning the smallest, or -1 if no even element exists.

### Input
An integer array `nums`, as described above.

**Constraints:**
- `1 <= nums.length <= 2000`
- `0 <= nums[i] <= 10^5`

### Output
Return the most frequent even element in nums, or -1 if none exists.

### Examples

**Input:**
```
nums = [0,1,2,2,4,4,1]
```
**Output:**
```
2
```

---

**Input:**
```
nums = [4,4,4,9,2,4]
```
**Output:**
```
4
```

---

**Input:**
```
nums = [29,47,21,41,13,37,25,7]
```
**Output:**
```
-1
```

---

## 2. Receiving Log Validation
A manufacturing plant receives shipments from multiple vendors. Each shipment record contains three pieces of information: vendor_id, lot_number, and cert_code. The compliance team follows an important rule: if the same vendor delivers the same lot number more than once, every shipment for that (vendor_id, lot_number) pair must have the same certification code. If a shipment appears with a different certification code than previously recorded for that vendor and lot number, the shipment is considered invalid.

This problem is commonly asked in interviews and helps build concepts like:
- Hash maps
- Composite key tracking
- Sequential validation

which are important for solving consistency-checking and log-validation problems.

**Your task:** Process the delivery records in order and return the index of the first invalid record. If all records follow the rule, return -1.

### Input
A list of delivery records `deliveries`, where each record is `[vendor_id, lot_number, cert_code]`, as described above.

**Constraints:**
- `1 <= deliveries.length <= 100000`
- `1 <= vendor_id.length <= 20`
- `1 <= lot_number.length <= 20`
- `1 <= cert_code.length <= 20`
- vendor_id, lot_number, and cert_code contain only uppercase letters and digits.

### Output
Return the index of the first invalid record, or -1 if all records are valid.

### Examples

**Input:**
```
deliveries = [["V1", "L100", "A"], ["V2", "L200", "B"], ["V1", "L100", "A"], ["V1", "L100", "C"]]
```
**Output:**
```
3
```

---

**Input:**
```
deliveries = [["V1", "L100", "A"], ["V1", "L101", "A"], ["V2", "L100", "A"]]
```
**Output:**
```
-1
```

---

**Input:**
```
deliveries = [["V3", "L500", "X"], ["V3", "L500", "Y"]]
```
**Output:**
```
1
```

---
