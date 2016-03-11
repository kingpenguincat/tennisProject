package util;

import bean.Game;

import java.util.Comparator;

/**
 * Created by liupeng on 16/3/9.
 */
public class DistanceCompare implements Comparator<Object> {

    public int compare(Object o1, Object o2) {

        Game h1=(Game)o1;
        Game h2=(Game)o2;

        return h1.getDistance()-h2.getDistance() > 0? 1 : h1.getDistance()-h2.getDistance()==0? 0 : -1;
    }
}
