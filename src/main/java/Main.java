import java.util.Random;

public class Main {

    private static final int MIN_ITER = 10;

    private static final int MAX_ITER = 20;

    private static final int MIN_SLEEP_TIMEOUT = 1000;

    private static final int MAX_SLEEP_TIMEOUT = 2000;

    private static final int SLEEP_TIMEOUT = new Random().nextInt(MAX_SLEEP_TIMEOUT - MIN_SLEEP_TIMEOUT) + MIN_SLEEP_TIMEOUT;

    private static final int GAME_ITERATION = new Random().nextInt(MAX_ITER - MIN_ITER) + MIN_ITER;

    private static UselessToy toy = new UselessToy(GAME_ITERATION, SLEEP_TIMEOUT);

    public static void main(String[] args) throws InterruptedException {

        Thread user = new Thread(toy::switchOn, "User");
        Thread box = new Thread(toy::switchOff, "Box");

        user.start();
        box.start();
    }
}
