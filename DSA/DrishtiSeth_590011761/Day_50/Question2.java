import heapq

def lastStoneWeight(rocks):
    # Max Heap using negative values
    heap = [-x for x in rocks]
    heapq.heapify(heap)

    while len(heap) > 1:
        first = -heapq.heappop(heap)
        second = -heapq.heappop(heap)

        if first != second:
            heapq.heappush(heap, -(first - second))

    return -heap[0] if heap else 0


# Example
rocks = [2, 7, 4, 1, 8, 1]
print(lastStoneWeight(rocks))
