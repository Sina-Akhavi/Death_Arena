package ir.ac.kntu.logic;

import java.util.List;
import java.util.Scanner;

public class ConsoleGraphicsEngine implements GraphicsEngine {

    //TODO: Implement Graphics Options


    @Override
    public void initialize(List<Soldier> groupA, List<Soldier> groupB) {
        System.out.println("War Between ArmyA and ArmyB Begins: ");
        

        System.out.println("**Soldiers of ArmyA: ");
        int counter = 0;
        for (Soldier aSoldier : groupA) {
            System.out.println(++counter + "- " + aSoldier);
        }
        System.out.println("\n-------------\n");
        System.out.println("**Soldiers of ArmyB: ");
        counter = 0;
        for (Soldier bSoldier : groupB) {
            System.out.println(++counter + "- " + bSoldier);
        }
        System.out.println("######################################\n");
    }

    @Override
    public void visualizeFight(Soldier firstToAttack, Soldier secondToAttack) {
        
        if (firstToAttack.shoot(secondToAttack)) {
            System.out.println("---------------");
            System.out.println(firstToAttack.getName() + " attacks: ");
            System.out.println("successfully hit!! ---->  " + secondToAttack.getName() + " life: "
                    + secondToAttack.getLifeLength());
        } else {
            System.out.println("---------------");
            System.out.println(firstToAttack.getName() + " attacks: ");
            System.out.println("NOT hit!!");
        }
        if (secondToAttack.isAlive()) {
            System.out.println("---------------");
            if (secondToAttack.shoot(firstToAttack)) {
                System.out.println(secondToAttack.getName() + " attacks: ");
                System.out.println("successfully hit!! ---->  " + firstToAttack.getName() + " life: "
                        + firstToAttack.getLifeLength());
            } else {
                System.out.println(secondToAttack.getName() + " attacks: ");
                System.out.println("NOT hit!!");
            }
        }
    }

    @Override
    public void introduceFighters(Soldier firstAttacker, Soldier secondAttacker) {
        System.out.println("first attacker: ");
        System.out.println("--" + firstAttacker);
        System.out.println();
        System.out.println("second attacker: ");
        System.out.println("--" + secondAttacker);
    }

    @Override
    public void menue(Director director) {
        
        Scanner scanner = new Scanner(System.in);
        printMenue();
        int input = scanner.nextInt();
        System.out.println();
        Option[] options = Option.values();
        input--;
        Option curOption = options[input];

        while (curOption != Option.CONTINUE) {
            handleOption(curOption, director);
            printMenue();
            input = scanner.nextInt();
            System.out.println();
            input--;
            curOption = options[input];
        }        
    }
    
    @Override
    public void visualizeEnding(List<Soldier> groupA, List<Soldier> groupB) {
        System.out.println("*********************************");
        System.out.println("WAR ENDED ...");
        System.out.println("\nRESULT: ");
        if (groupA.size() != 0) {
            System.out.println("ArmyA defeated ArmyB.");
        } else {
            System.out.println("ArmyB defeated ArmyA.");
        }
    }

    

    @Override
    public void visualizeWinnerLoserSoldiers(Soldier winner, Soldier loser) {
        System.out.println("\nRESULT:");
        System.out.println(winner.getName() + " killed " + loser.getName());
    }

    private static void handleOption(Option option, Director director) {
        switch (option) {
            case MAPE_OF_BATTLE_FIELD:
                printMapOfBattleField(director);
                break;
            case DETAILS_OF_ARMIES:
                printDetailsOfArmies(director);
                break;
            case GRAVEYARD:
                printGraveyard(director);
                break;
            default:
                break;

        }
    }

    private static void printGraveyard(Director director) {
        System.out.println("GRAVEYARD:\n");
        System.out.print("-dead soldiers of armyA: ");
        for (Soldier aSoldier : director.getGraveyardA()) {
            System.out.print(aSoldier.getName() + " ");
        }
        System.out.println();
        System.out.print("-dead soldiers of armyB: ");
        for (Soldier bSoldier : director.getGraveyardB()) {
            System.out.print(bSoldier.getName() + " ");
        }
        if (director.getGraveyardB().size() == 0) {
            System.out.println();
        }
        System.out.println();

    }

    private static void printDetailsOfArmies(Director director) {
        System.out.println("Soldiers of armyA: ");
        int counter = 0;
        for (Soldier aSoldier : director.getGroupA()) {
            System.out.println(++counter + "- " + aSoldier);
        }
        System.out.println("\n-------------\n");
        System.out.println("Soldiers of armyB: ");
        counter = 0;
        for (Soldier bSoldier : director.getGroupB()) {
            System.out.println(++counter + "- " + bSoldier);
        }
    }

    private static void printMenue() {
        System.out.println("\n*******************************");
        System.out.println("1- Map of battle field.");
        System.out.println("2- Details of armies.");
        System.out.println("3- Graveyard(dead soldiers of each army).");
        System.out.println("4- Continue");
        System.out.print("-- choose your number: ");
        
    }

    private static void printMapOfBattleField(Director director) {
        
        System.out.println("BATTLE FIELD MAP: ");
        String string = "";
        for (Soldier aSoldier : director.getGroupA()) {
            string += aSoldier.getName() + "-";
        }
        string = string.substring(0, string.length() - 1);

        string += " ################ ";

        for (Soldier bSoldier : director.getGroupB()) {
            string += bSoldier.getName() + "-";
        }
        string = string.substring(0, string.length() - 1);
        System.out.println(string);

    }

}
