package ir.ac.kntu.logic;

import ir.ac.kntu.util.RandomHelper;

public class Soldier {
    private final int id;

    private int lifeLength;

    private final Gun gun;

    private boolean isAlive;

    private String name;

    public Soldier() {
        this.id = RandomHelper.integerMaker(0, 1000);
        this.lifeLength = RandomHelper.integerMaker(5, 100);
        this.isAlive = true;
        this.gun = (RandomHelper.throwCoin()) ? (new SniperRifle()) : new AssaultRifle();
    }

    public boolean shoot(Soldier enemy) {
        boolean attackresult = this.getGun().shoot();
        if (attackresult) {
            enemy.reduceLife(this.getGun().getAmountOfDamage());
        }
        return attackresult;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void reduceLife(int amountOfDamage) {
        setLifeLength(lifeLength - amountOfDamage);
    }

    private void setLifeLength(int lifeLength) {
        if (lifeLength <= 0) {
            this.lifeLength = 0;
            setAlive(false);
        } else {
            this.lifeLength = lifeLength;
        }
    }

    public int getId() {
        return id;
    }

    public int getLifeLength() {
        return lifeLength;
    }

    public Gun getGun() {
        return gun;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    @Override
    public String toString() {
        return "name:" + getName() + ", id=" + id + ", lifeLength=" + lifeLength + ", gun=" + gun + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Soldier other = (Soldier) obj;
        if (id != other.id)
            return false;
        if (!other.getName().equals(getName())) {
            return false;
        }
        return true;
    }

}
