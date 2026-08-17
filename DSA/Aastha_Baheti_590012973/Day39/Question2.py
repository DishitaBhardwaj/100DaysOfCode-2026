import heapq

def minMeetingRooms(intervals):
    if not intervals:
        return 0

    # Sort meetings by start time
    intervals.sort(key=lambda x: x[0])

    # Min-heap to store end times
    heap = []

    # Add the end time of the first meeting
    heapq.heappush(heap, intervals[0][1])

    # Process remaining meetings
    for start, end in intervals[1:]:
        # If the earliest meeting has ended, reuse that room
        if start >= heap[0]:
            heapq.heappop(heap)

        # Allocate current meeting
        heapq.heappush(heap, end)

    return len(heap)


# Example Usage
intervals = [[0, 30], [5, 10], [15, 20]]
print(minMeetingRooms(intervals))