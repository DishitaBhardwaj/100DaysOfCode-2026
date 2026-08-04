#include <stdlib.h>

typedef struct {
    int vendor;
    int lot;
    int cert;
    int used;
} HashNode;

int firstInvalidRecord(int records[][3], int recordsSize) {
    if (recordsSize == 0)
        return -1;

    int size = recordsSize * 2 + 1;
    HashNode *table = (HashNode *)calloc(size, sizeof(HashNode));

    for (int i = 0; i < recordsSize; i++) {
        int vendor = records[i][0];
        int lot = records[i][1];
        int cert = records[i][2];

        unsigned int hash = ((unsigned int)vendor * 1000003u +
                             (unsigned int)lot) % size;

        while (table[hash].used &&
               !(table[hash].vendor == vendor &&
                 table[hash].lot == lot)) {
            hash = (hash + 1) % size;
        }

        if (!table[hash].used) {
            table[hash].used = 1;
            table[hash].vendor = vendor;
            table[hash].lot = lot;
            table[hash].cert = cert;
        } else {
            if (table[hash].cert != cert) {
                free(table);
                return i;
            }
        }
    }

    free(table);
    return -1;
}