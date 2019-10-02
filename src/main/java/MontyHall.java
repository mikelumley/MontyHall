import java.util.ArrayList;

public class MontyHall {

    private ArrayList<Door> doors;
    private IPlayerDecision playerDecision;

    public MontyHall(ArrayList<Door> doors, IPlayerDecision playerDecision) {
        this.doors = doors;
        this.playerDecision = playerDecision;
    }

    public boolean playGame() {
        int playerDoorNumber = playerDecision.pickRandomDoorNumber(doors.size());
        Door playerDoor = this.playerPicksDoor(playerDoorNumber);
        Door montyDoor = this.montyPicksDoor(playerDoor);

        if(playerDecision.isSwitching())
            playerDoor = this.playerSwitch(playerDoor, montyDoor);

        return this.hasPlayerWon(playerDoor);
    }

    private Door playerPicksDoor(int doorNumber) {
        int doorArrayIndex = doorNumber - 1;
        return doors.get(doorArrayIndex);
    }

    private Door montyPicksDoor(Door playersDoor) {
        for(Door door : doors) {
            if (!door.equals(playersDoor) && !door.hasPrize()) {
                return door;
            }
        }
        throw new RuntimeException("Error: No doors free that the player hasn't chosen or doesn't have a prize");
    }

    private Door playerSwitch(Door playersDoor, Door montysDoor) {
        for(Door door : doors) {
            if (!door.equals(playersDoor) && !door.equals(montysDoor)) {
                return door;
            }
        }
        throw new RuntimeException("Error: No doors that haven't been picked to switch to");
    }

    private boolean hasPlayerWon(Door door) {
        return door.hasPrize();
    }
}
