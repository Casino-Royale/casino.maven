import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.GameScoreboardInterface;
import com.github.zipcodewilmington.utils.GameScoreBoard;
import com.github.zipcodewilmington.utils.Scoreboard;
import org.junit.Assert;
import org.junit.Test;

public class GameScoreBoardTest {

    @Test
    public void constructorTest(){
        Scoreboard scoreboard = new Scoreboard();
        GameScoreboardInterface[] boards = new GameScoreboardInterface[5];
        boards[0] = scoreboard.getBeetleScores();
        boards[1] = scoreboard.getBlackJackScores();
        boards[2] = scoreboard.getNumberGuessScores();
        boards[3] = scoreboard.getKenoScores();
        boards[4] = scoreboard.getPlinkoScores();
        Boolean isScoreboard = false;

        for(int i = 0; i < boards.length; i++){
            if(boards[i] instanceof GameScoreboardInterface){
                isScoreboard = true;
            } else {
                isScoreboard = false;
                break;
            }
        }

        Assert.assertTrue(isScoreboard);
    }

    @Test
    public void lifetimeBetsTest(){
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.getPlinkoScores().incrementLifetimeBets();

        Integer actual = scoreboard.getPlinkoScores().getLifetimeBets();
        Integer expected = 1;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void lifetimeWinningsTest(){
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.getPlinkoScores().addToLifetimeWinnings(400);

        Integer actual = scoreboard.getPlinkoScores().getLifetimeWinnings();
        Integer expected = 400;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void lifetimeLossesTest(){
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.getPlinkoScores().addToLifetimeLosses(400);

        Integer actual = scoreboard.getPlinkoScores().getLifetimeLosses();
        Integer expected = 400;

        Assert.assertEquals(expected, actual);
    }

}
