import java.util.concurrent.atomic.AtomicBoolean;

public class UselessToy {

    private AtomicBoolean switchKey = new AtomicBoolean(false);

    private int gameIteration;

    private int sleepTimeOut;

    public UselessToy(int gameIteration, int sleepTimeOut) {

        this.gameIteration = gameIteration;
        this.sleepTimeOut = sleepTimeOut;
    }

    protected void switched() {

        for (int i = 0; i < gameIteration; i++){
            try {
                Thread.sleep(sleepTimeOut);
                if (!switchKey.get()) {
                    switchKey.getAndSet(true);
                    System.out.printf("---Включил %s\n", Thread.currentThread().getName());
                } else {
                    switchKey.getAndSet(false);
                    System.out.printf("------Выключил %s\n", Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Thread.currentThread().interrupt();
    }
}
