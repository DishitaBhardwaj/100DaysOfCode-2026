#include <stdio.h>
#include <string.h>

#define MAX 100000
#define LEN 21

typedef struct {
    char vendor[LEN];
    char lot[LEN];
    char cert[LEN];
} Record;

int main() {

    int n;

    printf("Enter number of deliveries: ");
    scanf("%d", &n);

    Record deliveries[n];

    printf("Enter vendor_id, lot_number and cert_code:\n");

    for (int i = 0; i < n; i++) {
        scanf("%s %s %s",
              deliveries[i].vendor,
              deliveries[i].lot,
              deliveries[i].cert);
    }

    int invalidIndex = -1;
    for (int i = 0; i < n; i++) {

        for (int j = 0; j < i; j++) {

            if (strcmp(deliveries[i].vendor, deliveries[j].vendor) == 0 &&
                strcmp(deliveries[i].lot, deliveries[j].lot) == 0) {

                if (strcmp(deliveries[i].cert, deliveries[j].cert) != 0) {
                    invalidIndex = i;
                    break;
                }
            }
        }
        if (invalidIndex != -1) {
            break;
        }
    }

    printf("First invalid record index: %d\n", invalidIndex);
    return 0;
}