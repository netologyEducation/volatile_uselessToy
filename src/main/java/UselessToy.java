import java.util.concurrent.atomic.AtomicBoolean;

public class UselessToy {

    private volatile boolean switchKey = false;

    private int gameIteration;

    private int sleepTimeOut;

    public UselessToy(int gameIteration, int sleepTimeOut) {

        this.gameIteration = gameIteration;
        this.sleepTimeOut = sleepTimeOut;
    }

    protected void switchOn() {
        while (Thread.currentThread().isAlive() && gameIteration >= 0) {
            try {
                Thread.sleep(sleepTimeOut);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!switchKey) {
                System.out.printf("---Включил %s\n", Thread.currentThread().getName());
                switchKey = true;
                gameIteration--;
            }
        }
        Thread.currentThread().interrupt();
    }

    protected void switchOff() {
        while (Thread.currentThread().isAlive() && gameIteration >= 0) {
            if (switchKey) {
                System.out.printf("------Выключил %s\n", Thread.currentThread().getName());
                switchKey = false;
            }
        }
    }
}
