package ir.ac.kntu.logic;

import ir.ac.kntu.util.RandomHelper;

public class SniperRifle extends Gun {

    private boolean isZoom;

    public SniperRifle() {
        super(20, 0.60);
    }

    @Override
    public boolean shoot() {
        // TODO Auto-generated method stub
        if (RandomHelper.throwCoin()) {
            isZoom = true;
        } else {
            isZoom = false;
        }

        if (!isZoom) {

            return super.shoot();

        } else {

            
            double acuuracyAffect = RandomHelper.doubleMaker(5, 15);
    
            double newAccuracy = acuuracyAffect + getAccuracy();

            double test = Math.random();
            if (test < newAccuracy) {
                return true;
            }
            return false;
        }
    }

    @Override
    public String toString() {
        return "SniperRifle" + super.toString();
    }

}
