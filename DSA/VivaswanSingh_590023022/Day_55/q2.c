#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int length;
    int beauty;
} Song;

int compare(const void *a, const void *b)
{
    Song *x = (Song *)a;
    Song *y = (Song *)b;

    return y->beauty - x->beauty;
}

int main()
{
    int length[] = {4, 15, 3, 6};
    int beauty[] = {7, 1, 6, 8};

    int n = 4;
    int k = 3;

    Song songs[4];

    for (int i = 0; i < n; i++)
    {
        songs[i].length = length[i];
        songs[i].beauty = beauty[i];
    }

    qsort(songs, n, sizeof(Song), compare);

    long long best = 0;

    // Try every possible minimum beauty
    for (int i = 0; i < n; i++)
    {
        int selected = 0;
        int sum = 0;

        // Pick the k largest lengths among songs
        // having beauty >= songs[i].beauty
        for (int j = 0; j <= i; j++)
        {
            int largest = -1;

            for (int x = j; x <= i; x++)
            {
                if (songs[x].length > largest)
                    largest = songs[x].length;
            }

            sum += largest;
            selected++;
        }

        if (selected > k)
            continue;

        long long pleasure = (long long)sum * songs[i].beauty;

        if (pleasure > best)
            best = pleasure;
    }

    printf("Maximum Playlist Pleasure: %lld\n", best);

    return 0;
}