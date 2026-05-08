package Thread;

//用CAS来实现原子类自增
class AtomicInteger{
    private int value;
    
    public int getAndIncrement(){
        int oldValue = value;
        while (CAS(value,oldValue,oldValue + 1) != true){
            oldValue = value;
        }
        return oldValue;
    }

    //以下是CAS的逻辑层面的模拟实现，其中三种参数其实为引用类型（或指针）
    private boolean CAS(int address, int expectValue, int swapValue) {
        if(address == expectValue){
            address = swapValue;
            return true;
        }
        return false;
    }
}
//还可以基于CAS实现自旋锁
class  SpinLock{
    private  Thread owner = null;

    public void lock(){
        // 通过CAS看当前锁是否被某个线程持有
        // 如果这个锁已经被别的线程持有，那么就自旋等待
        //如果这个锁没有被别的线程持有，那就把 owner设为当前尝试加锁的线程
        while (!CAS(this.owner,null,Thread.currentThread())){
        }
    }
    public void unlock(){
        this.owner = null;
    }
    private boolean CAS(Thread address, Object expectValue, Thread swapValue) {
        if(address == expectValue){
            address = swapValue;
            return true;
        }
        return false;
    }
}
public class Demo13 {


}
