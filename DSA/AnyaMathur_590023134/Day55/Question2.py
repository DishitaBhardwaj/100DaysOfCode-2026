# Problem 2 
# Maximum Playlist Pleasure 

length = list(map(int, input("Enter song lengths: ").split()))
beauty = list(map(int, input("Enter beauty ratings: ").split()))
k = int(input("Enter k: "))

songs = []

for i in range(len(length)):
    songs.append((beauty[i], length[i]))

songs.sort(reverse=True)

selected = []
total_length = 0
answer = 0

for b, l in songs:
    selected.append(l)
    total_length += l
    if len(selected) > k:
        selected.sort()
        removed = selected.pop(0)
        total_length -= removed

    pleasure = total_length * b

    if pleasure > answer:
        answer = pleasure
print("Maximum pleasure:", answer)