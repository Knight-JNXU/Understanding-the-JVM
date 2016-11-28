package Chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Knight_JXNU on 2016/11/28.
 * -XX:PermSize=2M -XX:MaxPermSize=2M
 * -XX:PermSize=10M 设置jvm初始分配的非堆（方法区）大小
 * -XX:MaxPermSize=10M 设置jvm最大允许分配的非堆内存
 * String是存在运行时常量池中的，如果创建过多的String就会导致方法区和运行时常量池溢出
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args){
        //使用List保持常量池的引用，避免 full GC 回收常量池行为
        List<String> list = new ArrayList<String>();
        int i=0;
        while (true){
            //String.intern() 是一个native方法，
            // 作用：如果字符串常量池中已经包含一个等于此String对象的字符串，则返回代表池中这个字符串的String对象
            //否则，将此String对象包含的字符串添加到常量池中，并返回此对象的引用
            list.add(String.valueOf(i++).intern());
        }
    }
}
