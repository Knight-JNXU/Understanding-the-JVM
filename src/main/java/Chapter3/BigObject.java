package Chapter3;

/**
 * Created by Knight_JXNU on 2016/12/7.
 * jvm options:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728 -XX:+UseParNewGC
 * -verbose:gc  输出虚拟机中GC的情况，比如[Full GC xxxxxx]
 * -Xms    设置jvm的初始内存
 * -Xmx    设置jvm的最大内存
 * -Xmn    设置新生代大小
 * -XX:+PrintGCDetails 打印GC详细情况，比如 Heap PsYoungGen xxxxx
 * -XX:SurvivorRatio=8 设置 Edon:Survivor:Survivor = 8:1:1
 * -XX:PretenureSizeThreshold=3145728 设置对象多大（字节）时可以直接进入老年代，这里3145728是3M
 * -XX:+UseParNewGC 设置使用ParNew+Serial Old收集器，因为 PretenureSizeThreshold只对 ParNew 和 Serial有效
 */
public class BigObject {
    private static final int _1MB=1024*1024;
    public static void main(String[] args){
        byte[] allocation = new byte[4*_1MB]; //如果选用1就看不到这个对象直接进入老年代
    }
}
