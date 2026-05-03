package Thread;
//   通过懒汉模式构造单例模式
class  SingletonLazy{
    //编译器优化是个复杂的事情，为了稳妥起见，将进程中会改变的量直接用volatile进行修饰，从根本上杜绝内存可见性问题
    //同时用volatile还能避免指令重排序带来的线程安全问题，volatile不仅能确保每次的读取操作都是读内存，而且还能让关于该变量的读取和修改操作不会触发重排序
    volatile private static SingletonLazy instance = null;
    private static  Object locker = new Object();

    //懒汉模式下，创建实例的时机，是在第一次使用的时候，而不是在程序启动的时候
    public static SingletonLazy getInstance(){
        if(instance == null){
            synchronized (locker){
                if (instance == null){
                    instance = new SingletonLazy();
                }
            }
        }
        return  instance;
    }
    private SingletonLazy(){

    }

}
public class Demo3 {
    public static void main(String[] args) {
        SingletonLazy S1 = SingletonLazy.getInstance();
        SingletonLazy S2 = SingletonLazy.getInstance();
        System.out.println(S1 == S2);
    }
}
