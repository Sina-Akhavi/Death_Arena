package ir.ac.kntu.logic;

import java.util.List;

public interface GraphicsEngine {

    public void initialize(List<Soldier> groupA, List<Soldier> groupB);

    public void visualizeFight(Soldier firstAttacker, Soldier secondAttacker);

    public void introduceFighters(Soldier firstAttacker, Soldier secondAttacker);

    public void menue(Director director);

    public void visualizeEnding(List<Soldier> groupA, List<Soldier> groupB);

    public void visualizeWinnerLoserSoldiers(Soldier winner, Soldier loser);

}
