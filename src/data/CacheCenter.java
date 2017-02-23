package data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vchann on 23/02/2017.
 */
public class CacheCenter {

    public int id;
    public int capacity;
    public List<Integer> idVideoList = new ArrayList<>();
    //public int[] endPointList;

    public CacheCenter(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public void addVideo(int idx) {
        if (!idVideoList.contains(idx)) {
            idVideoList.add(idx);
        }
    }

    public String getVideostringList() {
        String result = "";
        for (int videoIdx : idVideoList) {
            result += videoIdx + " ";
        }
        return result;
    }

}
