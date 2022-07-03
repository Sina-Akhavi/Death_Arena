package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Arrays;

import ir.ac.kntu.logic.AssaultRifle;
import ir.ac.kntu.logic.ConsoleGraphicsEngine;
import ir.ac.kntu.logic.Director;
import ir.ac.kntu.logic.GraphicsEngine;


public class Main {
    public static void main(String[] args) {
        GraphicsEngine engine = new ConsoleGraphicsEngine();
        Director director = new Director(engine);
        // TODO: Start your game from here

       director.createSoldiersA(3);
       director.createSoldiersB(3);

       director.startGameLoop();
    }

}
