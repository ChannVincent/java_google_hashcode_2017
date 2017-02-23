import algorithm.PizzaSolver;
import algorithm.YoutubeCachingSolver;
import manager.FileManager;
import manager.TimerManager;

public class Main {

    public static void main(String[] args) {
        TimerManager timerManager = TimerManager.getInstance();
        FileManager fileManager = new FileManager();
        timerManager.start();

        //YoutubeCachingSolver solverSmall = new YoutubeCachingSolver(fileManager.getSmallInput());
        //fileManager.writeSmallOutput(solverSmall.solveA());


        //YoutubeCachingSolver solverMedium = new YoutubeCachingSolver(fileManager.getMediumInput());
        //fileManager.writeMediumOutput(solverMedium.solveA());

/*
        YoutubeCachingSolver solverBig = new YoutubeCachingSolver(fileManager.getBigInput());
        fileManager.writeBigOutput(solverBig.solveA());
*/

        YoutubeCachingSolver solverExemple = new YoutubeCachingSolver(fileManager.getExempleInput());
        fileManager.writeExempleOutput(solverExemple.solveA());


        timerManager.end();
    }
}
