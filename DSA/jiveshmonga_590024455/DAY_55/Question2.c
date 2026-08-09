#include <stdio.h>
#include <stdlib.h>
typedef struct 
{
    int beauty;
    int length;
} Song;
int cmp(const void *a, const void *b) 
{
    Song *x = (Song *)a;
    Song *y = (Song *)b;
    return y->beauty - x->beauty;   
}
void heapifyUp(int heap[], int *size, int val) {
    int i=(*size)++;
    heap[i]=val;
    while (i>0) 
    {
        int p=(i-1)/2;
        if (heap[p]<=heap[i])
            break;
        int t=heap[p];
        heap[p]=heap[i];
        heap[i]=t;
        i=p;
    }
}
int heapifyDown(int heap[],int *size) {
    int root=heap[0];
    heap[0]=heap[--(*size)];
    int i=0;
    while (1) 
    {
        int l=2*i+1;
        int r=2*i+2;
        int smallest=i;
        if (l< *size&&heap[l]<heap[smallest])
            smallest=l;
        if (r < *size && heap[r] < heap[smallest])
            smallest=r;
        if (smallest==i)
            break;
        int t=heap[i];
        heap[i]=heap[smallest];
        heap[smallest]=t;
        i=smallest;
    }
    return root;
}
long long maximumPleasure(int length[], int beauty[], int n, int k) {
    Song songs[100];
    for (int i=0;i<n;i++) {
        songs[i].length = length[i];
        songs[i].beauty = beauty[i];
    }
    qsort(songs, n, sizeof(Song), cmp);
    int heap[100];
    int heapSize = 0;
    long long sum = 0;
    long long ans = 0;
    for (int i = 0; i < n; i++) {
        heapifyUp(heap, &heapSize, songs[i].length);
        sum += songs[i].length;
        if (heapSize>k)
            sum-=heapifyDown(heap,&heapSize);
        long long pleasure=sum*(long long)songs[i].beauty;
        if (pleasure>ans)
            ans=pleasure;
    }
    return ans;
}
int main() 
{
    int length[]={4,15,3,6};
    int beauty[]={7,1,6,8};
    printf("%lld\n",maximumPleasure(length,beauty,4,3));
    return 0;
}