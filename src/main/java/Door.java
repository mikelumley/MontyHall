public class Door {
    private boolean isPrizeDoor;

    public Door(boolean isPrizeDoor) {
        this.isPrizeDoor = isPrizeDoor;
    }

    public boolean hasPrize() {
        return this.isPrizeDoor;
    }
}
