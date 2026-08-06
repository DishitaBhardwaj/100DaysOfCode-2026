#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_NAME_LEN 100

typedef struct {
    char name[MAX_NAME_LEN];
    int count;
} UserRecord;

void solve(char** requests, int num_requests) {
    UserRecord* records = (UserRecord*)malloc(num_requests * sizeof(UserRecord));
    int record_count = 0;

    for (int i = 0; i < num_requests; i++) {
        char* current_name = requests[i];
        int found_index = -1;

        // Search if the username has been registered before
        for (int j = 0; j < record_count; j++) {
            if (strcmp(records[j].name, current_name) == 0) {
                found_index = j;
                break;
            }
        }

        if (found_index == -1) {
            // First time seeing this username
            strcpy(records[record_count].name, current_name);
            records[record_count].count = 1;
            record_count++;
            
            printf("OK\n");
        } else {
            // Username already exists, format and print name + count
            int count = records[found_index].count;
            printf("%s%d\n", current_name, count);
            
            // Increment the count for future occurrences
            records[found_index].count++;
        }
    }

    free(records);
}

int main() {
    char* requests[] = {"abacaba", "acaba", "abacaba", "acab"};
    int num_requests = sizeof(requests) / sizeof(requests[0]);

    solve(requests, num_requests);

    return 0;
}