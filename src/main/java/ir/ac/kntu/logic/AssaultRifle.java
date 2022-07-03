package ir.ac.kntu.logic;

public class AssaultRifle extends Gun {

    public AssaultRifle() {
        super(10, 0.50);
    }

    @Override
    public String toString() {
        return "AssaultRifle" + super.toString();
    }

}
