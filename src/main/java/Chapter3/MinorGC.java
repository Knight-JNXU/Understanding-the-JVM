package Chapter3;

/**
 * Created by Knight_JXNU on 2016/12/6.
 * jvm options:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 */
public class MinorGC {
    private static final int _1MB = 1024*1024;

    public static void main(String[] args){
        testAllocation();
    }

    public static void testAllocation(){
        byte[] allocation1, allocation2, allocaiton3, allocation4;
        allocation1 = new byte[2*_1MB];
        allocation2 = new byte[2*_1MB];
        allocaiton3 = new byte[2*_1MB];
        allocation4 = new byte[2*_1MB];  //出现一次 Minor GC
        System.out.println("end");
    }
}
