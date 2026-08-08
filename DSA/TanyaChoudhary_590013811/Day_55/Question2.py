def maximumPlaylistPleasure(songs, k):
    songs.sort(key=lambda x: x[1])
    
    n = len(songs)
    max_pleasure = 0
    
    for i in range(n):
        min_beauty = songs[i][1]
        total_length = 0
        count = 0
        
        for j in range(n - 1, i - 1, -1):
            if count < k:
                total_length += songs[j][0]
                count += 1
        
        pleasure = total_length * min_beauty
        max_pleasure = max(max_pleasure, pleasure)
    
    return max_pleasure

print(maximumPlaylistPleasure([(3,4),(2,5),(5,3),(1,6)], 3))
print(maximumPlaylistPleasure([(4,2),(3,5),(2,4),(1,3)], 2))