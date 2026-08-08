def footballChampionshipWinner(goals):
    count = {}
    
    for team in goals:
        count[team] = count.get(team, 0) + 1
    
    winner = ""
    max_goals = 0
    
    for team in count:
        if count[team] > max_goals:
            max_goals = count[team]
            winner = team
    
    if list(count.values()).count(max_goals) > 1:
        return "Draw!"
    
    return winner

print(footballChampionshipWinner(["TeamA","TeamB","TeamA","TeamB"]))