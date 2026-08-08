# Football Championship Winner

def football_championship_winner(goals):
    goal_count = {}

    for team in goals:
        if team in goal_count:
            goal_count[team] += 1
        else:
            goal_count[team] = 1

    winner = ""
    max_goals = 0

    for team, count in goal_count.items():
        if count > max_goals:
            max_goals = count
            winner = team

    return winner


goals = input("Enter team goals : ").split()

print(football_championship_winner(goals))