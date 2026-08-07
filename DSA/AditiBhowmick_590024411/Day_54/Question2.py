def winning_team(goals):
    count = {}

    for team in goals:
        count[team] = count.get(team, 0) + 1

    winner = max(count, key=count.get)

    return winner

n = int(input("Enter number of goals: "))

goals = []
for _ in range(n):
    goals.append(input())

print(winning_team(goals))