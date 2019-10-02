import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MontyHallTest {

    private ArrayList<Door> doors;

    @Before
    public void setup() {
        doors = new ArrayList<>();
        doors.add(new Door(true));
        doors.add(new Door(false));
        doors.add(new Door(false));
    }

    @Test
    public void Given_PlayerPicksFirstDoorAndStays_When_MontyHallRuns_Then_PlayerWins() {
        IPlayerDecision playerDecision = new StubPlayerDecision(1, false);
        MontyHall montyHall = new MontyHall(this.doors, playerDecision);
        boolean won = montyHall.playGame();
        assertTrue(won);
    }

    @Test
    public void Given_PlayerPicksFirstDoorAndSwitches_When_MontyHallRuns_Then_PlayerLoses() {
        IPlayerDecision playerDecision = new StubPlayerDecision(1, true);
        MontyHall montyHall = new MontyHall(this.doors, playerDecision);
        boolean won = montyHall.playGame();
        assertFalse(won);
    }

    @Test
    public void Given_PlayerPicksThirdDoorAndStays_When_MontyHallRuns_Then_PlayerLoses() {
        IPlayerDecision playerDecision = new StubPlayerDecision(3, false);
        MontyHall montyHall = new MontyHall(this.doors, playerDecision);
        boolean won = montyHall.playGame();
        assertFalse(won);
    }

    @Test
    public void Given_PlayerPicksThirdDoorAndSwitches_When_MontyHallRuns_Then_PlayerWins() {
        IPlayerDecision playerDecision = new StubPlayerDecision(3, true);
        MontyHall montyHall = new MontyHall(this.doors, playerDecision);
        boolean won = montyHall.playGame();
        assertTrue(won);
    }

    @Test (expected = RuntimeException.class)
    public void Given_TwoDoorsAndPlayerPicksSecondDoorWithNoPrizeAndStays_When_MontyHallRuns_Then_ThrowRuntimeException() {
        doors.remove(1);
        IPlayerDecision playerDecision = new StubPlayerDecision(2, false);
        MontyHall montyHall = new MontyHall(this.doors, playerDecision);
        montyHall.playGame();
    }

    @Test (expected = RuntimeException.class)
    public void Given_TwoDoorsAndPlayerPicksFirstDoorWithPrizeAndSwitches_When_MontyHallRuns_Then_ThrowRuntimeException() {
        doors.remove(2);
        IPlayerDecision playerDecision = new StubPlayerDecision(1, true);
        MontyHall montyHall = new MontyHall(this.doors, playerDecision);
        montyHall.playGame();
    }

    @Test
    public void Given_ThreeDoorsAndPlayerPicksFirstDoorWithPrizeAndStays_When_RunningMontyHallTwoTimes_Then_PlayerWinsTwoTimes() {
        IPlayerDecision playerDecision = new StubPlayerDecision(1, false);
        int timesWon = Main.playGames(2, playerDecision);
        assertEquals(2, timesWon);
    }

    @Test
    public void Given_ThreeDoorsAndPlayerPicksFirstDoorWithPrizeAndStays_When_RunningMontyHallZeroTimes_Then_PlayerWinsZeroTimes() {
        IPlayerDecision playerDecision = new StubPlayerDecision(1, false);
        int timesWon = Main.playGames(0, playerDecision);
        assertEquals(0, timesWon);
    }
}
