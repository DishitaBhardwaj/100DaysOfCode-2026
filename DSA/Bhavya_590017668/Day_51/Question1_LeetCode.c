typedef struct {
    int key;
    int count;
    int used;
} HashNode;

int mostFrequentEven(int* nums, int numsSize) {
    if (numsSize == 0) return -1;

    int size = numsSize * 2 + 1;
    HashNode* table = (HashNode*)calloc(size, sizeof(HashNode));

    int ans = -1;
    int maxFreq = 0;

    for (int i = 0; i < numsSize; i++) {
        if (nums[i] % 2 != 0)
            continue;

        int key = nums[i];
        int idx = ((key % size) + size) % size;

        while (table[idx].used && table[idx].key != key)
            idx = (idx + 1) % size;

        if (!table[idx].used) {
            table[idx].used = 1;
            table[idx].key = key;
            table[idx].count = 1;
        } else {
            table[idx].count++;
        }

        if (table[idx].count > maxFreq ||
            (table[idx].count == maxFreq &&
             (ans == -1 || key < ans))) {
            maxFreq = table[idx].count;
            ans = key;
        }
    }
    free(table);
    return ans;
}