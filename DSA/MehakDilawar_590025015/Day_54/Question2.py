#Write an efficient function that determines the winning team's name given a list of team names representing 
#every goal scored in a match (the team with more goals wins).
#Input: ["A", "ABA", "ABA", "A", "A"]. Output: "A"
def winning_team(goals):
    score = {}
    for team in goals:
        score[team] = score.get(team, 0) + 1
    winner = max(score, key=score.get)
    return winner

goals = input("Enter team names separated by spaces: ").split()
print("Winning team:", winning_team(goals))