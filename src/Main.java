import algorithm.PizzaSolver;
import manager.FileManager;
import manager.TimerManager;

public class Main {

    public static void main(String[] args) {
        TimerManager timerManager = TimerManager.getInstance();
        FileManager fileManager = new FileManager();
        timerManager.start();

        PizzaSolver pizzaSolver = new PizzaSolver(fileManager.getSmallInput());

        timerManager.end();
    }
}
