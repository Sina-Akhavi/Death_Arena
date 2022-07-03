package ir.ac.kntu.logic;

import java.util.ArrayList;
import java.util.List;
import ir.ac.kntu.util.RandomHelper;

public class Director {

    private List<Soldier> groupA;
    private List<Soldier> groupB;

    private List<Soldier> graveyardA;
    private List<Soldier> graveyardB;

    private GraphicsEngine graphicsEngine;

    private Soldier currentASoldier;
    private Soldier currentBSoldier;

    private VictoryState victoryState;

    public Director(GraphicsEngine graphicsEngine) {
        // TODO: Intialize soldiers

        groupA = new ArrayList<>();
        groupB = new ArrayList<>();

        graveyardA = new ArrayList<>();
        graveyardB = new ArrayList<>();

        this.graphicsEngine = graphicsEngine;
        victoryState = VictoryState.NOT_FINISHED;
    }

    

    public List<Soldier> getGroupA() {
        return groupA;
    }

    public List<Soldier> getGroupB() {
        return groupB;
    }

    public List<Soldier> getGraveyardA() {
        return graveyardA;
    }

    public List<Soldier> getGraveyardB() {
        return graveyardB;
    }

    public void startGameLoop() {
        // TODO: Add Game Logic Loop here - Graphics also go here

        graphicsEngine.initialize(groupA, groupB);

        while (groupA.size() != 0 && groupB.size() != 0) {
            currentASoldier = groupA.get(RandomHelper.integerMaker(0, groupA.size()));
            currentBSoldier = groupB.get(RandomHelper.integerMaker(0, groupB.size()));

            Soldier[] firstAndSecondToShoot = makeTurnToShoot(currentASoldier, currentBSoldier);
            Soldier firstToAttack = firstAndSecondToShoot[0];
            Soldier secondToAttack = firstAndSecondToShoot[1];

            graphicsEngine.introduceFighters(firstToAttack, secondToAttack);

            while (firstToAttack.isAlive() && secondToAttack.isAlive()) {
                graphicsEngine.visualizeFight(firstToAttack, secondToAttack);
            }

            handleAfterFight(firstToAttack, secondToAttack, currentASoldier, currentBSoldier);
            if (groupA.size() != 0 && groupB.size() != 0) {
                graphicsEngine.menue(this);
            }
        }
        graphicsEngine.visualizeEnding(groupA, groupB);

    }

    public void createSoldiersA(int noOfSoldiers) {
        int count = 1;
        for (int i = 0; i < noOfSoldiers; i++) {
            Soldier s = new Soldier();
            s.setName("A" + count);
            groupA.add(s);
            count++;
        }
    }

    public void createSoldiersB(int noOfSoldiers) {
        int count = 1;
        for (int i = 0; i < noOfSoldiers; i++) {
            Soldier s = new Soldier();
            s.setName("B" + count);
            groupB.add(s);
            count++;
        }
    }

    private Soldier[] makeTurnToShoot(Soldier currentASoldier, Soldier currentBSoldier) {
        Soldier[] firstAndSecond = new Soldier[2];
        if (RandomHelper.throwCoin()) {
            firstAndSecond[0] = currentASoldier;
            firstAndSecond[1] = currentBSoldier;
        } else {
            firstAndSecond[0] = currentBSoldier;
            firstAndSecond[1] = currentASoldier;
        }
        return firstAndSecond;
    }

    private void handleAfterFight(Soldier firstToAttack, Soldier secondToAttack, Soldier currentASoldier,
            Soldier currentBSoldier) {

        if (firstToAttack.isAlive()) {
            if (firstToAttack.equals(currentASoldier)) {
                handleWinnerAndLoser(firstToAttack, currentBSoldier);
            } else {
                handleWinnerAndLoser(firstToAttack, currentASoldier);
            }
        }
        if (secondToAttack.isAlive()) {
            if (secondToAttack.equals(currentASoldier)) {
                handleWinnerAndLoser(secondToAttack, currentBSoldier);
            } else {
                handleWinnerAndLoser(secondToAttack, currentASoldier);
            }
        }
    }

    private void handleWinnerAndLoser(Soldier winner, Soldier loser) {
        graphicsEngine.visualizeWinnerLoserSoldiers(winner, loser);

        if (groupA.contains(loser)) {
            graveyardA.add(loser);
            groupA.remove(loser);
        } else {
            graveyardB.add(loser);
            groupB.remove(loser);
        }
    }

    public enum VictoryState {
        WIN_A, WIN_B, NOT_FINISHED
    }
}
