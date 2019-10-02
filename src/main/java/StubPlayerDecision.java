public class StubPlayerDecision implements IPlayerDecision{

    private int doorToPick = 0;
    private boolean shouldSwitch = false;

    public StubPlayerDecision(int doorToPick, boolean shouldSwitch) {
        this.doorToPick = doorToPick;
        this.shouldSwitch = shouldSwitch;
    }

    @Override
    public int pickRandomDoorNumber(int numberOfDoors) {
        return this.doorToPick;
    }

    @Override
    public boolean isSwitching() {
        return this.shouldSwitch;
    }
}
