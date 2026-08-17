#include <stdlib.h>

char* predictWinner(char* jobs) {
    int n = 0;
    while (jobs[n] != '\0')
        n++;

    char *queue = (char *)malloc(2 * n * sizeof(char));

    int front = 0, rear = 0;
    int sales = 0, marketing = 0;

    for (int i = 0; i < n; i++) {
        queue[rear++] = jobs[i];
        if (jobs[i] == 'S')
            sales++;
        else
            marketing++;
    }

    int banSales = 0;
    int banMarketing = 0;

    while (sales > 0 && marketing > 0) {

        char cur = queue[front++];

        if (cur == 'S') {

            if (banSales > 0) {
                banSales--;
                sales--;
            } else {
                banMarketing++;
                queue[rear++] = 'S';
            }

        } else {

            if (banMarketing > 0) {
                banMarketing--;
                marketing--;
            } else {
                banSales++;
                queue[rear++] = 'M';
            }

        }
    }

    free(queue);

    return (sales > 0) ? "Sales" : "Marketing";
}
