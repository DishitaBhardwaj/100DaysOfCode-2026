# Problem 2 
# Football Championship Winner

goals = input("Enter goals (separated by spaces): ").split()
count = {}
for team in goals:
    if team in count:
        count[team] += 1
    else:
        count[team] = 1
teams = list(count)
if len(teams) == 1:
    winner = teams[0]
else:
    if count[teams[0]] > count[teams[1]]:
        winner = teams[0]
    else:
        winner = teams[1]
print("Winning team:", winner)