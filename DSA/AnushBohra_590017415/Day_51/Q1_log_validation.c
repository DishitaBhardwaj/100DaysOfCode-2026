#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Structure to define a delivery record
typedef struct {
    char vendor_id[64];
    char lot_number[64];
    char cert_code[64];
} Record;

// Structure to store unique (vendor_id, lot_number) -> cert_code mappings
typedef struct {
    char vendor_id[64];
    char lot_number[64];
    char cert_code[64];
} MapEntry;

int validate_receiving_logs(Record records[], int n) {
    MapEntry *seen = malloc(n * sizeof(MapEntry));
    if (!seen) return -1; // Allocation failure check

    int seen_count = 0;
    int invalid_index = -1;

    for (int i = 0; i < n; i++) {
        int found = 0;

        // Check if the (vendor_id, lot_number) pair has already been seen
        for (int j = 0; j < seen_count; j++) {
            if (strcmp(seen[j].vendor_id, records[i].vendor_id) == 0 &&
                strcmp(seen[j].lot_number, records[i].lot_number) == 0) {
                found = 1;
                // If cert_code differs from previously recorded one, record index
                if (strcmp(seen[j].cert_code, records[i].cert_code) != 0) {
                    invalid_index = i;
                }
                break;
            }
        }

        if (invalid_index != -1) {
            break; // Mismatch found
        }

        // Store new (vendor_id, lot_number) pair
        if (!found) {
            strcpy(seen[seen_count].vendor_id, records[i].vendor_id);
            strcpy(seen[seen_count].lot_number, records[i].lot_number);
            strcpy(seen[seen_count].cert_code, records[i].cert_code);
            seen_count++;
        }
    }

    free(seen);
    return invalid_index;
}

int main() {
    // Test dataset
    Record records[] = {
        {"V1", "L100", "CERT_A"},
        {"V2", "L200", "CERT_B"},
        {"V1", "L100", "CERT_A"}, // Valid duplicate
        {"V1", "L100", "CERT_X"}, // Invalid: different cert_code for same (V1, L100)
        {"V2", "L200", "CERT_B"}
    };

    int n = sizeof(records) / sizeof(records[0]);
    int result = validate_receiving_logs(records, n);

    if (result != -1) {
        printf("First invalid record found at index: %d\n", result);
    } else {
        printf("All records are valid (-1)\n");
    }

    return 0;
}