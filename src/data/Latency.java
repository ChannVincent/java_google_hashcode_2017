package data;

/**
 * Created by vchann on 23/02/2017.
 */
public class Latency {

    public int idCache;
    public int idEndPoint;
    public int value;

    public Latency(int idCache, int idEndPoint, int value) {
        this.idCache = idCache;
        this.idEndPoint = idEndPoint;
        this.value = value;
    }
}
