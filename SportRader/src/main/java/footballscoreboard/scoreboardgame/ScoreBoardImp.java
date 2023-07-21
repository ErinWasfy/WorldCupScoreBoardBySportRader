package footballscoreboard.scoreboardgame;

import footballscoreboard.entity.Team;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ScoreBoardImp implements IScoreBoard {

    public Team homeTeam,awayTeam;
    private  List<List<Team>> listOfPairTeam;
    private  List<Team> matchTeam;

    public ScoreBoardImp(Team hTeam, Team awyTeam) {
     this.homeTeam=hTeam;
     this.awayTeam=awyTeam;
        matchTeam=new ArrayList<>();
     matchTeam.add(this.homeTeam);
     matchTeam.add(this.awayTeam);
     listOfPairTeam=new ArrayList<>();
     listOfPairTeam.add(matchTeam);
     listOfPairTeam.stream().sorted((a,b)->b.get(0).getScore()+b.get(1).getScore()>a.get(0).getScore()+a.get(1).getScore()?1:0);
    }
    /*
    Update score when a new score added to a team.
     */
    @Override
    public synchronized boolean matchUpdated(Team homeTeam, Team awayTeam) {
        if(homeTeam!=null && awayTeam!=null)
        {
            this.homeTeam=homeTeam;
            this.awayTeam=awayTeam;
            matchTeam.add(this.homeTeam);
            matchTeam.add(this.awayTeam);
            listOfPairTeam.add(matchTeam);
            return true;
        }
        return false;
    }
    /*
    When the match finishes,it should be removed from the board list
    */
    @Override
    public synchronized boolean  matchFinished(List<Team> matchTeam) {
        for(List<Team> team:listOfPairTeam)
        {
            if(team.get(0).getTeamName().equals(matchTeam.get(0).getTeamName()) && team.get(1).getTeamName().equals(matchTeam.get(1).getTeamName())) {
                listOfPairTeam.remove(matchTeam);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<String> summarizedMatch() {
       return listOfPairTeam.stream().map(t->t.get(0).getTeamName()+" "+t.get(0).getScore()+":"+t.get(1).getTeamName().name()+" "+t.get(1).getScore()).collect(Collectors.toList());
    }
}
