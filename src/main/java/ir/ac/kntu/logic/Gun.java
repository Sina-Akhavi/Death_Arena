package ir.ac.kntu.logic;

import ir.ac.kntu.util.RandomHelper;

//import ir.ac.kntu.logic.Calibr;

public class Gun {
    private final int amountOfDamage;
    
    private final double accuracy;

    private final Calibr calibr;

    public Gun(int amountOfDamage, double accuracy) {
        int randiomeNumber = RandomHelper.integerMaker(0, 3);
        if (randiomeNumber == 0) {
            this.calibr = Calibr.HIGH;
        } else if (randiomeNumber == 1) {
            this.calibr = Calibr.LOW;
        } else {
            this.calibr = Calibr.NONE;
        }
        this.amountOfDamage = amountOfDamage + calibr.getDamage();
        this.accuracy = accuracy + calibr.getAccuracy();
    }

    public int getAmountOfDamage() {
        return amountOfDamage;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public Calibr getCalibr() {
        return calibr;
    }

    public boolean shoot() {
        double accuracy = Math.random();
        
        if (this.accuracy > accuracy) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Gun: accuracy=" + accuracy + ", amountOfDamage=" + amountOfDamage + ", calibr=" + calibr;
    }

    
}
