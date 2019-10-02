import java.util.Random;

public class PlayerDecision implements IPlayerDecision {

    private Random random = new Random();
    private boolean shouldSwitch = false;

    public PlayerDecision(boolean shouldSwitch) {
        this.shouldSwitch = shouldSwitch;
    }

    @Override
    public int pickRandomDoorNumber(int numberOfDoors) {
        return this.random.nextInt(numberOfDoors) + 1;
    }

    @Override
    public boolean isSwitching() {
        return this.shouldSwitch;
    }
}
