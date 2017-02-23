package algorithm;

import manager.InputManager;

/**
 * Created by vchann on 23/02/2017.
 */
public class YoutubeCachingSolver {

    /*
    Attributes
     */
    int numberOfVideos; // V
    int numberOfEndPoints; // E
    int numberOfRequestDescriptions; // R
    int numberOfCacheServers; // C
    int capacityOfEachCacheServer; // X
    int[] videoSizeList;

    protected InputManager inputManager;

    /*
    Constructor
     */
    public YoutubeCachingSolver(String input) {
        this.inputManager = new InputManager(input);
        initInputs();

    }

    protected void initInputs() {
        videoSizeList = inputManager.getLineInput(1);
        int[] initInputs = inputManager.getLineInput(0);
        numberOfVideos = initInputs[0];
        numberOfEndPoints = initInputs[1];
        numberOfRequestDescriptions = initInputs[2];
        numberOfCacheServers = initInputs[3];
        capacityOfEachCacheServer = initInputs[4];

    }

    /*
    Solver
     */
    public String solveA() {
        String result = "";
        result += numberOfVideos + " " + numberOfEndPoints + " " + numberOfRequestDescriptions + " " + numberOfCacheServers + " " + capacityOfEachCacheServer;
        return result;
    }
}
