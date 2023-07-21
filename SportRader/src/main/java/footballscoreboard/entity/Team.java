package footballscoreboard.entity;

import footballscoreboard.enums.MatchTeam;

public class Team {
  protected final MatchTeam teamName;
  protected final int score;

    public Team(MatchTeam teamName,int initialScore) {
        this.teamName = teamName;
        this.score=initialScore;
    }

    public MatchTeam getTeamName() {
        return teamName;
    }

    public int getScore() {
        return score;
    }


}
