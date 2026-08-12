"""   Q1:  Write an efficient function that determines the winning team's name given a list of team 
names representing every goal scored in a match (the team with more goals wins).

Example:
Input: ["A", "ABA", "ABA", "A", "A"]; Output: "A".    """



def winning_team(goals):

    goal_count = 0

    team_name = ""

    for team in goals:
        if team == team_name:
            goal_count += 1

        else:
            if goal_count == 0:
                team_name = team
                goal_count =1

            else:
                goal_count -= 1

    return team_name



# Example usage:
goals = ["A", "ABA", "ABA", "A", "A"]

print(winning_team(goals))