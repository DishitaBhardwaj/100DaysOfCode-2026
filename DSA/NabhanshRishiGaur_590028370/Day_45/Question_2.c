#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);

    long long inv = 0;
    int arr[n];

    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            if (arr[i] > arr[j])
                inv++;
        }
    }

    printf("%lld\n", inv);

    return 0;
}
