#include <stdio.h>

int main() {

    int n;

    printf("Enter the number of rocks: ");
    scanf("%d", &n);

    int rocks[n];

    printf("Enter the weights of the rocks: ");

    for (int i = 0; i < n; i++) {
        scanf("%d", &rocks[i]);
    }

    int remaining = n;

    while (remaining > 1) {

        int max1 = -1, max2 = -1;
        int idx1 = -1, idx2 = -1;

        // Find the heaviest rock
        for (int i = 0; i < n; i++) {
            if (rocks[i] > max1) {
                max1 = rocks[i];
                idx1 = i;
            }
        }

        // Remove the heaviest temporarily
        rocks[idx1] = -1;

        // Find the second heaviest rock
        for (int i = 0; i < n; i++) {
            if (rocks[i] > max2) {
                max2 = rocks[i];
                idx2 = i;
            }
        }

        if (max1 == max2) {

            rocks[idx2] = -1;
            remaining -= 2;

        } else {

            rocks[idx1] = max1 - max2;
            rocks[idx2] = -1;
            remaining--;
        }
    }

    int answer = 0;

    for (int i = 0; i < n; i++) {
        if (rocks[i] != -1) {
            answer = rocks[i];
            break;
        }
    }

    printf("Last remaining rock: %d\n", answer);

    return 0;
}