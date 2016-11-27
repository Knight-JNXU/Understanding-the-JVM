package Chapter2;

/**
 * Created by Knigh on 2016/11/27.
 * -Xss2m(可以将每个线程的堆栈大小设大一点，这样可容纳的线程数就少了)
 * 由于在 windows 平台的虚拟机中，java的线程是映射到操作系统的内核线程上的，这段代码有很大的
 * 风险导致死机，请勿轻易尝试，本人试过两次都死机了
 */
public class JavaVMStackOOM {
    private void dontStop(){
        while (true){}
    }
    public void stackLeakByThread(){
        while (true){
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }
    public static void main(String[] args) throws Exception{
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
