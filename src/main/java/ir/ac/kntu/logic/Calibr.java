package ir.ac.kntu.logic;

public enum Calibr {
    HIGH(10, -0.10), LOW(0, 0.15), NONE(0, 0.0);

    private final int damage;

    private final double accuracy;

    private Calibr(int damage, double accuracy) {
        this.damage = damage;
        this.accuracy = accuracy;
    }

    public int getDamage() {
        return damage;
    }

    public double getAccuracy() {
        return accuracy;
    }

    
}