package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo14 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //此处 Callable只是定义了一个“带有返回值”的任务
        //并没有真的在执行，执行还是需要搭配Thread对象
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = 0;
                for (int i = 0; i < 100; i++) {
                    result += i;
                }
                return  result;
            }
        };
        //Thread的构造方法没有提供传入Callable的版本
//        Thread t = new Thread(callable);
        //所以要用futureTask拿到callable的返回值
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread t = new Thread(futureTask);
        t.start();
        System.out.println(futureTask.get());

    }
}
