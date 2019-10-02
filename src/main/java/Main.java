import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        final int NUMBER_OF_GAMES_TO_PLAY = 1000;

        PlayerDecision playerStays = new PlayerDecision(false);
        PlayerDecision playerSwitches = new PlayerDecision(true);

        int stayWins = Main.playGames(NUMBER_OF_GAMES_TO_PLAY, playerStays);
        int switchWins = Main.playGames(NUMBER_OF_GAMES_TO_PLAY, playerSwitches);

        float staysWinsPercentage = (float) stayWins / NUMBER_OF_GAMES_TO_PLAY * 100;
        float switchWinsPercentage = (float) switchWins / NUMBER_OF_GAMES_TO_PLAY * 100;

        System.out.println("Player Stays Wins: " + staysWinsPercentage + "%");
        System.out.println("Player Switch Wins: " + switchWinsPercentage + "%");
    }

    public static int playGames(int numberOfGamesToPlay, IPlayerDecision playerDecision) {
        int timesPlayerWins = 0;

        ArrayList<Door> doors = new ArrayList<>();
        doors.add(new Door(true));
        doors.add(new Door(false));
        doors.add(new Door(false));

        MontyHall montyHall = new MontyHall(doors, playerDecision);

        for(int i = 0; i < numberOfGamesToPlay; i++) {
            boolean won = montyHall.playGame();
            if(won)
                timesPlayerWins++;
        }
        return timesPlayerWins;
    }
}
