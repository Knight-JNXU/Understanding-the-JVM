package Chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Knigh on 2016/11/21.
 * -Xms2m -Xmx2m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
    static class OOMObject{
    }

    public static void main(String[] args){
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
