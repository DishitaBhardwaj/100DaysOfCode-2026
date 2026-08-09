<h2 align="center">Week 8 Day 54 (07/08/2026)</h2>

## 1. Count Elements With Maximum Frequency (LeetCode #3005)

### Solution

```c
#include <stdio.h>

int maxFrequencyElements(int *nums, int n) {
    int count[101] = {0}; // values are 1..100

    for (int i = 0; i < n; i++) {
        count[nums[i]]++;
    }

    int maxFreq = 0;
    for (int v = 1; v <= 100; v++) {
        if (count[v] > maxFreq) maxFreq = count[v];
    }

    int total = 0;
    for (int v = 1; v <= 100; v++) {
        if (count[v] == maxFreq) total += count[v];
    }

    return total;
}

int main(void) {
    int n1[] = {1, 2, 2, 3, 1, 4};
    printf("%d\n", maxFrequencyElements(n1, 6)); // 4

    int n2[] = {1, 2, 3, 4, 5};
    printf("%d\n", maxFrequencyElements(n2, 5)); // 5

    return 0;
}
```

How it works: since values are bounded to `1..100`, a simple counting array replaces a hash map. First pass tallies each value's frequency, second pass finds the maximum frequency, and a third pass sums the frequencies of every value that hits that maximum (not just the count of *distinct* values — the total number of occurrences among them).

Complexity: O(n) time, O(1) extra space (the counting array is a fixed 101-size buffer regardless of `n`).

---

## 2. Football Championship Winner

### Solution

```c
#include <stdio.h>
#include <string.h>

const char* footballChampion(char goals[][11], int n) {
    static char team1[11], team2[11];
    int count1 = 0, count2 = 0;
    int haveTeam2 = 0;

    strcpy(team1, goals[0]);

    for (int i = 0; i < n; i++) {
        if (strcmp(goals[i], team1) == 0) {
            count1++;
        } else if (!haveTeam2) {
            strcpy(team2, goals[i]);
            haveTeam2 = 1;
            count2++;
        } else if (strcmp(goals[i], team2) == 0) {
            count2++;
        }
    }

    return (count1 > count2) ? team1 : team2;
}

int main(void) {
    char g1[][11] = {"ABC"};
    printf("%s\n", footballChampion(g1, 1)); // ABC

    char g2[][11] = {"A", "ABA", "ABA", "A", "A"};
    printf("%s\n", footballChampion(g2, 5)); // A

    char g3[][11] = {"LIONS", "TIGERS", "LIONS", "LIONS"};
    printf("%s\n", footballChampion(g3, 4)); // LIONS

    return 0;
}
```

How it works: since the goal list contains at most two distinct team names, there's no need for a hash map at all. `team1` is fixed as whichever team scored the first goal. The first goal that doesn't belong to `team1` fixes `team2`. From there, every subsequent goal only ever matches `team1` or `team2`, so a single pass with two counters is enough. The team with the higher final count wins — the problem guarantees no draw.

Complexity: O(n · L) time, where `L` is the bounded team-name length (≤ 10) used in string comparisons — effectively O(n). O(1) extra space.
