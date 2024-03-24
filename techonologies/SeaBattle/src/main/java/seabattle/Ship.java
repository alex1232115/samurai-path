package seabattle;

public abstract class Ship {
    private final int[] coords;
    private int health;

    public Ship(int health) {
        coords = new int[health * 2];
        this.health = health;
    }

    public abstract void initCoords(int[] coords);

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
