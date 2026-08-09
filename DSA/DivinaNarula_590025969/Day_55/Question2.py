# Maximum Playlist Pleasure

import heapq

def max_playlist_pleasure(length, beauty, k):
    songs = sorted(zip(beauty, length), reverse=True)

    total_length = 0
    max_pleasure = 0
    min_heap = []

    for b, l in songs:
        heapq.heappush(min_heap, l)
        total_length += l

        if len(min_heap) > k:
            total_length -= heapq.heappop(min_heap)

        if len(min_heap) == k:
            max_pleasure = max(max_pleasure, total_length * b)

    return max_pleasure


length = list(map(int, input("Enter song lengths: ").split()))
beauty = list(map(int, input("Enter beauty values: ").split()))
k = int(input("Enter k: "))

print(max_playlist_pleasure(length, beauty, k))