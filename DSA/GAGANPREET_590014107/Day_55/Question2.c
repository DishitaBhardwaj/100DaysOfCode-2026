#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int length;
    int beauty;
} Song;

// Sort by beauty in descending order
int compareBeauty(const void *a, const void *b) {
    Song *s1 = (Song *)a;
    Song *s2 = (Song *)b;

    return s2->beauty - s1->beauty;
}

// Find maximum pleasure
long long maxPlaylistPleasure(int length[], int beauty[], int n, int k) {

    Song songs[n];

    // Store length and beauty
    for (int i = 0; i < n; i++) {
        songs[i].length = length[i];
        songs[i].beauty = beauty[i];
    }

    // Sort songs by beauty (largest first)
    qsort(songs, n, sizeof(Song), compareBeauty);

    long long maxPleasure = 0;

    // Try each beauty as the minimum beauty
    for (int i = 0; i < n; i++) {

        // Store lengths of available songs
        int selected[n];

        int count = i + 1;

        for (int j = 0; j <= i; j++) {
            selected[j] = songs[j].length;
        }

        // Sort lengths in descending order
        for (int a = 0; a < count - 1; a++) {
            for (int b = a + 1; b < count; b++) {

                if (selected[a] < selected[b]) {
                    int temp = selected[a];
                    selected[a] = selected[b];
                    selected[b] = temp;
                }
            }
        }

        // Take at most k songs
        int take = count < k ? count : k;

        long long sum = 0;

        for (int j = 0; j < take; j++) {
            sum += selected[j];
        }

        // Current beauty is the minimum beauty
        long long pleasure = sum * songs[i].beauty;

        if (pleasure > maxPleasure) {
            maxPleasure = pleasure;
        }
    }

    return maxPleasure;
}

int main() {

    int length[] = {4, 15, 3, 6};
    int beauty[] = {7, 1, 6, 8};

    int n = 4;
    int k = 3;

    long long result = maxPlaylistPleasure(length, beauty, n, k);

    printf("Maximum Playlist Pleasure = %lld\n", result);

    return 0;
}
