package Chapter2;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by Knight_JXNU on 2016/11/28.
 * -Xmx20ZM -XX:MaxDirectMemorySize=10M
 * -Xmx 设置最大堆大小
 * -XX:MaxDirectMemorySize 设置 DirectMemory 大小
 * 通过反射获取Unsafe实例进行分配引起内存溢出
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024*1024;
    public static void main(String[] args) throws Exception{
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe)unsafeField.get(null);
        while (true){
            unsafe.allocateMemory(_1MB);  //申请分配内存
        }
    }
}
