package footballscoreboard.scoreboardgame;

import footballscoreboard.entity.Team;
import footballscoreboard.enums.MatchTeam;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.Verifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreBoardImpTest extends TestCase {

   IScoreBoard scoreBoard;
    @Override
    @Before
    public void setUp() throws Exception {
       // scoreBoard=new ScoreBoardImp(new Team(MatchTeam.Mexico,0),new Team(MatchTeam.CANADA,5));
       scoreBoard=new ScoreBoardImp(new Team(MatchTeam.URUGUAY,6),new Team(MatchTeam.ITALY,5));

    }

    @Test
    public void testMatchUpdated() {
        IScoreBoard matchBoardInprogress=new ScoreBoardImp(new Team(MatchTeam.ITALY,3),new Team(MatchTeam.AUSTRALIA,5));

        Assert.assertNotNull(matchBoardInprogress.matchUpdated(new Team(MatchTeam.ITALY,3),new Team(MatchTeam.AUSTRALIA,6)));
        Assert.assertEquals(true,matchBoardInprogress.matchUpdated(new Team(MatchTeam.ITALY,3),new Team(MatchTeam.AUSTRALIA,6)));

    }
    @Test
    public void testMatchFinished() {
       Assert.assertEquals(true,scoreBoard.matchFinished(List.of(new Team(MatchTeam.URUGUAY,6),new Team(MatchTeam.ITALY,5))));
    }
    @Test
    public void testSummarizedMatch() {
        List<Team> matchTeam=new ArrayList<>();
        matchTeam.add(new Team(MatchTeam.URUGUAY,6));
        matchTeam.add(new Team(MatchTeam.ITALY,5));
        List<List<Team>> allScoreBoardMatches=new ArrayList<>();
        allScoreBoardMatches.add(matchTeam);
        List<String> summarizedScoreBoardMatches=allScoreBoardMatches.stream().map(t->t.get(0).getTeamName()+" "+t.get(0).getScore()+":"+t.get(1).getTeamName().name()+" "+t.get(1).getScore()).collect(Collectors.toList());

        Assert.assertEquals(summarizedScoreBoardMatches,scoreBoard.summarizedMatch());
    }
}