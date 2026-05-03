package Thread;

//饿汉方式的单例模式
class Singleton{
    private  static  Singleton instance = new Singleton();
    private int age;
    public static Singleton getInstance(){
        return  instance;
    }
    public static Singleton getInstance(int age){
        instance.age = age;
        return instance;
    }
    private  Singleton(){

    }

}
public class Demo2 {
    public static void main(String[] args) {
        Singleton t1 = Singleton.getInstance();
        Singleton t2 = Singleton.getInstance();
        System.out.println(t1 == t2);

    }

}
