package ir.ac.kntu.util;

import java.util.Random;

/**
 *
 * @author hossein
 */
public final class RandomHelper {

    private static final Random RANDOM_GENERATOR = new Random(300);

    private RandomHelper() {

    }

    public static double nextDouble() {
        return RANDOM_GENERATOR.nextDouble();
    }

    public static boolean nextBoolean() {
        return RANDOM_GENERATOR.nextBoolean();
    }

    public static int nextInt() {
        return RANDOM_GENERATOR.nextInt();
    }

    public static int nextInt(int bound) {
        return RANDOM_GENERATOR.nextInt(bound);
    }

    public static boolean throwCoin() {
        if (Math.random() > 0.5) {
            return false;
        }
        return true;
    }

    public static int integerMaker(int from, int to) {
        return from + (int) (Math.random() * (to - from));
    }

    public static double doubleMaker(int from, int to) {
        return (from + (int) (Math.random() * (to - from))) / 100.0;
    }
}
