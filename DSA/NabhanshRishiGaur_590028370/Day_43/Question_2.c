#include <stdio.h>

#define OFFSET 10000
#define RANGE 20001

int arrayPairSum(int nums[], int size) {
    int count[RANGE] = {0};

    for (int i = 0; i < size; i++) {
        count[nums[i] + OFFSET]++;
    }

    int sum = 0;
    int take = 1;
    for (int i = 0; i < RANGE; i++) {
        while (count[i] > 0) {
            if (take)
                sum += (i - OFFSET);

            take = !take;
            count[i]--;
        }
    }

    return sum;
}

int main() {
    int size;
    scanf("%d", &size);

    int nums[size];

    for (int i = 0; i < size; i++)
        scanf("%d", &nums[i]);

    printf("%d\n", arrayPairSum(nums, size));

    return 0;
}
