package Chapter3;

/**
 * Created by Knight_JXNU on 2016/11/28.
 * 引用计数算法的缺陷
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024*1024;
    //使用bigSize占用内存，以便能在GC日志中看清楚是否被回收过
    private byte[] bigSize = new byte[2*_1MB];

    public static void testGC(){
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;
        objA=null;
        objB=null;
        //这里主动GC
        System.gc();
    }

    public static void main(String[] args){
        testGC();
    }
}
