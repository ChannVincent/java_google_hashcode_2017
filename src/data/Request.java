package data;

/**
 * Created by vchann on 23/02/2017.
 */
public class Request {

    public int videoId;
    public int endpointId;
    public int requestNumber;

    public Request(int videoId, int endpointId, int requestNumber) {
        this.videoId = videoId;
        this.endpointId = endpointId;
        this.requestNumber = requestNumber;
    }
}
