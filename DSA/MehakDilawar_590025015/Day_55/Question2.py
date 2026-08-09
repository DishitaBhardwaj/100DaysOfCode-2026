#Write an efficient function that selects at most k songs (each with a length and beauty value) to maximize pleasure, 
#defined as (sum of selected lengths) × (minimum beauty among selected songs).
#Input: length = [4, 15, 3, 6], beauty = [7, 1, 6, 8], k = 3. Output: 78.
def max_pleasure(length, beauty, k):
    songs = sorted(zip(beauty, length), reverse=True)
    selected = []
    total_length = 0
    best = 0
    for b, l in songs:
        selected.append(l)
        total_length += l
        if len(selected) > k:
            selected.sort()
            removed = selected.pop(0)
            total_length -= removed
        best = max(best, total_length * b)
    return best

n = int(input("Enter number of songs: "))
length = list(map(int, input("Enter song lengths: ").split()))
beauty = list(map(int, input("Enter beauty values: ").split()))
k = int(input("Enter k: "))
print(max_pleasure(length, beauty, k))