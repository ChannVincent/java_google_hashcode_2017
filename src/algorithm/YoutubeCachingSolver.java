package algorithm;

import data.*;
import manager.InputManager;

import java.util.ArrayList;
import java.util.List;

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
    List<EndPoint> endPointList;
    List<Request> requestList;
    List<Latency> latencyList = new ArrayList<>();
    List<CacheCenter> cacheCenterList = new ArrayList<>();

    protected InputManager inputManager;
    String input;
    protected int endInpuEndpointtLine = 0;

    /*
    Constructor
     */
    public YoutubeCachingSolver(String input) {
        this.input = input;
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
        endPointList = getEndPoints();
        requestList = getRequests();
        populateData();
    }

    /*
    Solver
     */
    public String solveA() {
        String result = "";

        for (EndPoint endPoint : endPointList) {
            int videoId = getTopViewVideo(endPoint.id);
            int bestCacheId = getBestCache(endPoint.id);

            for (CacheCenter cacheCenter : cacheCenterList) {


                if (cacheCenter.id == bestCacheId) {
                    if ((bestCacheId != -1) && (videoId != -1) && ((cacheCenter.capacity + videoSizeList[videoId]) <= capacityOfEachCacheServer)) {
                        cacheCenter.addVideo(videoId);
                        cacheCenter.capacity += videoSizeList[videoId];
                    }
                }
            }
        }

        int numberOfCacheUsed = 0;
        for (CacheCenter cacheCenter : cacheCenterList) {
            if (cacheCenter.idVideoList.size() > 0) {
                result += cacheCenter.id + " " + cacheCenter.getVideostringList() + "\n";
                numberOfCacheUsed++;
            }
        }
        result = numberOfCacheUsed + "\n" + result;

        return result;
    }

    /*
    Methods
     */
    public List<EndPoint> getEndPoints() {
        List<EndPoint> result = new ArrayList<>();

        String matrixString = input.split("\n", 3)[2];
        String[] lines = matrixString.split("\n");

        int idEndPoint = 0;
        for (int y = 0; idEndPoint < numberOfEndPoints; y++) {


            String line = lines[y];
            String[] splitLine = line.split(" ");
            int latency = Integer.parseInt(splitLine[0]);
            int numberOfCaches = Integer.parseInt(splitLine[1]);
            List<Cache> caches = new ArrayList<>();

            for (int x = 1; x < numberOfCaches + 1; x++) {

                String lineCache = lines[y + 1];
                String splitLineCacheList[] = lineCache.split(" ");
                int idCache = Integer.parseInt(splitLineCacheList[0]);
                int latencyCache = Integer.parseInt(splitLineCacheList[1]);
                caches.add(new Cache(idCache, latencyCache));
                y++;
                endInpuEndpointtLine++;
            }

            EndPoint endPoint = new EndPoint(idEndPoint, latency, numberOfCaches, caches);
            result.add(endPoint);
            idEndPoint++;
            endInpuEndpointtLine++;

        }

        return result;
    }

    public List<Request> getRequests() {
        List<Request> result = new ArrayList<>();
        int startLine = endInpuEndpointtLine + 2;
        String[] lines = input.split("\n");

        for (int y = startLine; y < numberOfRequestDescriptions; y++) {
            String line = lines[y];
            String splitLineList[] = line.split(" ");
            int videoId = Integer.parseInt(splitLineList[0]);
            int endpointId = Integer.parseInt(splitLineList[1]);
            int requestNumber = Integer.parseInt(splitLineList[2]);
            result.add(new Request(videoId, endpointId, requestNumber));

        }

        return result;
    }

    public void populateData() {
        for (EndPoint endPoint : endPointList) {
            for (Cache cache : endPoint.cacheList) {

                if (cacheCenterList.size() == 0) {
                    cacheCenterList.add(new CacheCenter(cache.id, 0));
                }
                else {
                    boolean toAdd = true;
                    for (CacheCenter cacheCenter : cacheCenterList) {
                        if (cacheCenter.id == cache.id) {
                            toAdd = false;
                        }
                    }
                    if (toAdd) {
                        cacheCenterList.add(new CacheCenter(cache.id, 0));
                    }
                }

                latencyList.add(new Latency(cache.id, endPoint.id, cache.latency));
            }
        }
    }

    public int getBestCache(int endPointId) {
        int bestValue = 1000000;
        int bestCache = -1;
        for (Latency latency : latencyList) {
            if (endPointId == latency.idEndPoint) {
                if (latency.value < bestValue) {
                    bestValue = latency.value;
                    bestCache = latency.idCache;
                }
            }
        }
        return bestCache;
    }

    public int getTopViewVideo(int endPointId) {
        int bestValue = 0;
        int bestVideo = -1;
        for (Request request : requestList) {
            if (endPointId == request.endpointId) {
                if (request.requestNumber > bestValue) {
                    bestValue = request.requestNumber;
                    bestVideo = request.videoId;
                }
            }
        }
        return bestVideo;
    }
}
