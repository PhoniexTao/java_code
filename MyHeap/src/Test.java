import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Test {
   public int[] smallestK(int[] arr,int k){
       PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k,new IntegerCP());
       for (int i = 0; i < k; i++) {
           priorityQueue.offer(arr[i]);
       }

       for (int i = k; i < arr.length; i++) {
           int peekVal = priorityQueue.peek();
           if (arr[i] < peekVal){
               priorityQueue.poll();
               priorityQueue.offer(peekVal);
           }
       }

       int[] ret = new int[k];
       for (int i = 0; i < k; i++) {
           ret[i] = priorityQueue.poll();
       }
       return ret;


   }
}
