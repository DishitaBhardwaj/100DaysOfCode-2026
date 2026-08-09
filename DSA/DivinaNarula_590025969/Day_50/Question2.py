# The Quarry Smasher

import heapq

def lastStoneWeight(rocks):
    heap = [-rock for rock in rocks]
    heapq.heapify(heap)

    while len(heap) > 1:
        first = -heapq.heappop(heap)
        second = -heapq.heappop(heap)

        if first != second:
            heapq.heappush(heap, -(first - second))

    if heap:
        return -heap[0]

    return 0


n = int(input("Enter number of rocks: "))
rocks = list(map(int, input("Enter rock weights: ").split()))

print(lastStoneWeight(rocks))