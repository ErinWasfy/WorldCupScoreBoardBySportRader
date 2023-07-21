package footballscoreboard.scoreboardgame;

import footballscoreboard.entity.Team;

import java.util.ArrayList;
import java.util.List;

public interface IScoreBoard {
    boolean matchUpdated(Team homeTeam, Team awayTeam);
    boolean matchFinished(List<Team> matchTeam);
    List<String> summarizedMatch();
}
