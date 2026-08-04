import heapq
def last_stone_weight(rocks):
    
    max_heap = [-rock for rock in rocks]
    heapq.heapify(max_heap)

    while len(max_heap) > 1:
        first = -heapq.heappop(max_heap)   
        second = -heapq.heappop(max_heap)  

        if first != second:
            heapq.heappush(max_heap, -(first - second))

    return -max_heap[0] if max_heap else 0

rocks = list(map(int, input("Enter rock weights: ").split()))

print("Last stone weight:", last_stone_weight(rocks))