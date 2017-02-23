package data;

import java.util.List;

/**
 * Created by vchann on 23/02/2017.
 */
public class EndPoint {

    public int id;
    public int latencyWithDataCenter;
    public int numberOfCache;
    public List<Cache> cacheList;

    public EndPoint(int id, int latencyWithDataCenter, int numberOfCache, List<Cache> cacheList) {
        this.id = id;
        this.latencyWithDataCenter = latencyWithDataCenter;
        this.numberOfCache = numberOfCache;
        this.cacheList = cacheList;
    }
}
