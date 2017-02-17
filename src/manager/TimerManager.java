package manager;

/**
 * Created by vchann on 17/02/2017.
 */
public class TimerManager {

    protected long startTimer;
    protected int checkIteration = 0;
    static protected TimerManager singleInstance = null;

    static public TimerManager getInstance() {
        if (singleInstance == null) {
            singleInstance = new TimerManager();
        }
        return singleInstance;
    }

    protected TimerManager() {
    }

    public void start() {
        startTimer = System.currentTimeMillis();
        System.out.println("start timer algorithm");
    }

    public void checkPoint() {
        checkIteration++;
        long result = System.currentTimeMillis() - startTimer;
        System.out.println("check n°" + checkIteration + " timer : " + result + " ms");
    }

    public void end() {
        long resultInMilliSeconds = System.currentTimeMillis() - startTimer;
        long resultInSeconds = resultInMilliSeconds / 1000;
        System.out.println("finish algorithm in " + resultInMilliSeconds + " ms or " + resultInSeconds + " seconds");
    }
}
