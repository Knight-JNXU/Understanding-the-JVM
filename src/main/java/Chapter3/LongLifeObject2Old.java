package Chapter3;

/**
 * Created by Knight_JXNU on 2016/12/7.
 * jvm options:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:+PrintTenuringDistribution -XX:+UseConcMarkSweepGC
 * -XX:+UseConcMarkSweepGC  使用 ParNew+CMS+Serial Old收集器
 */
public class LongLifeObject2Old {
    private static final int _1MB = 1024*1024;
    public static void main(String[] args){
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB/4];
        //什么时候进入老年代取决于 MaxTenuringThreshold 设置
        allocation2=new byte[4*_1MB];
        allocation3=new byte[4*_1MB];
        allocation3=null;
        allocation3=new byte[4*_1MB];
    }
}
