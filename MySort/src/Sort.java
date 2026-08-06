import javax.print.DocFlavor;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayDeque;
import java.util.Deque;

public class Sort {
    /**
     * 时间复杂度：O(N^2)
     * 空间复杂度:O(1)
     * 稳定性：稳定
     * @param arr
     */
    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {  // 从第二个元素开始排
            int tmp = arr[i]; //将需要排序的元素抽出
            int j = i - 1;
            for (; j >= 0; j--) {  // 从该元素的前一个元素开始比较
                if (tmp < arr[j]){      //要排升序，如果抽出的元素比前面的元素小，则把前面的元素移到后一位
                    arr[j + 1] = arr[j];
                }else{                     //如果抽出的元素比前面的元素大，则直接放到前面元素的后面一位。
                    break;
                }
            }
            arr[j + 1] = tmp;      //比较结束应将抽出的元素放到被比较元素的后一位。
        }
    }
    public static void shellSort(int[] arr){
        //先对预排续的gap进行控制
        int gap = arr.length;
        while (gap > 0){  //保证gap可退出且进行完gap == 1时的插入排序
            gap /= 2;  //这里的gap必然有 == 1的情况
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                int j = i - gap;
                for (; j >= 0; j -= gap) {
                    if(tmp < arr[j]){
                        arr[j + gap] = arr[j];
                    }else{
                        break;
                    }
                }
                arr[j + gap] = tmp;
            }
        }
    }

    public static void selectSort(int[] arr) {
        int left = 0;
        while (left < arr.length - 1){
            int minIndex = left;
            for (int i = left + 1; i < arr.length; i++) {
                if(arr[minIndex] > arr[i]){
                    minIndex = i;
                }
            }
            int tmp = arr[left];
            arr[left] = arr[minIndex];
            arr[minIndex] = tmp;
            left++;
        }
    }

    public static void selectSortPro(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        while (left < right){
            int minIndex = left;
            int maxIndex = left;
            for (int i = left + 1; i <= right; i++) {
                if(arr[i] < arr[minIndex]){
                    minIndex = i;
                }
                if(arr[i] > arr[maxIndex]){
                    maxIndex = i;
                }
            }
            int tmp = arr[left];
            arr[left] = arr[minIndex];
            arr[minIndex] = tmp;

            //如果原来的left的位置就是找到的max那么现在真正的max在minIndex处
            if (left == maxIndex){
                maxIndex = minIndex;
            }
            tmp = arr[right];
            arr[right]  = arr[maxIndex];
            arr[maxIndex] = tmp;

            left++;
            right--;
        }
    }
    public static void HeapSort(int[] arr){
        //排升序建大堆
        createHeap(arr);
        int end = arr.length - 1;

        while (end > 0){
            //因为是大堆，堆顶一定最大所以和最后一位元素进行交换
            int tmp = arr[0];
            arr[0] = arr[end];
            arr[end] = tmp;
            //交换完之后将堆的最后一位不考虑在内，之后对置换后的堆顶进行调整，让堆顶重新变成当前堆的最大堆顶
            end--;
            adjustDown(arr,0,end);
        }
    }

    private static void createHeap(int[] arr) {
        for (int parent = (arr.length - 1 - 1) / 2; parent >= 0; parent--) {
            adjustDown(arr,parent,arr.length);
        }
    }

    /**
     * @param arr
     * @param parent : 要调整的元素位置
     * @param length ： 该数组的长度
     */
    private static void adjustDown(int[] arr, int parent, int length) {
        int child = parent * 2 + 1;
        while (child < length){
            //找最大孩子
            if(child + 1 < length && arr[child + 1] > arr[child]){
                child++;
            }
            if(arr[parent] < arr[child]){
                int tmp = arr[parent];
                arr[parent] = arr[child];
                arr[child] = tmp;

                parent = child;
                child = child * 2 + 1;
            }else{
                break;
            }
        }
    }
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j + 1]){
                    flag = false;
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            if(flag){
                break;
            }
        }
    }

    public static void quickSort1(int[] arr){
        quick1(arr,0,arr.length - 1);
    }
    private static int getMidNum(int[] arr, int begin, int end) {
        int mid = (begin + end)/2;
        if(arr[begin] > arr[end]){
            if(arr[mid] > arr[begin]){
                return begin;
            }else if(arr[mid] < arr[end]){
                return end;
            }else{
                return mid;
            }
        }else {    // arr[begin] < arr[end]
            if (arr[mid] < arr[begin]){
                return begin;
            }else if(arr[mid] > arr[end]){
                return end;
            }else {
                return mid;
            }
        }
    }
    public static void quick1(int[] arr, int begin, int end) {
        if (begin >= end) {
            return;
        }
        if (end - begin - 1 < 10){
             insertSortRange(arr,begin,end);
             return;
        }
        // 三数取中优化：选三个下标位置，并比较其元素大小，选取其中的一个中位数与begin位置进行交换当基准值
        int midNum = getMidNum(arr,begin,end);
        //与begin进行交换
        int tmp = arr[begin];
        arr[begin] = arr[midNum];
        arr[midNum] = tmp;
        //选取基准值
        int target = begin;
        //开始遍历寻找
        int left = begin;
        int right = end;
        int mid = 0;
        while (left < right) {
            while (left < right && arr[right] >= arr[target]) {
                right--;
            }
            while (left < right && arr[left] <= arr[target]) {
                left++;
            }

            tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }
        //找到基准值的位置
        tmp = arr[target];
        arr[target] = arr[right];
        arr[right] = tmp;
        mid = right;

        //进行递归
        quick1(arr, begin, mid - 1);
        quick1(arr, mid + 1, end);
    }

    private static void insertSortRange(int[] arr, int begin, int end) {
        for (int i = begin + 1; i <= end; i++) {
            int tmp = arr[i];
            int j = i - 1;
            for (; j >= begin; j--) {
                if (arr[j] > tmp){
                    arr[j + 1] = arr[j];
                }else {
                    arr[j + 1] = tmp;
                    break;
                }
            }
            arr[j + 1] = tmp;
        }
    }


    public static void quickSort2(int[] arr){
        quick2(arr,0,arr.length - 1);
    }
    public static void quick2(int[] arr,int begin, int end){
        if(begin >= end){
            return;
        }
        //将基准值进行保存
        int target = arr[begin];
        //将坑位进行标记
        int hole = begin;
        //开始遍历
        int left = begin;
        int right = end;
        while (left < right){
            while (left < right && arr[right] >= target){
                right--;
            }
            //找到小于基准值的元素
            arr[hole] = arr[right];
            hole = right;
            while (left < right && arr[left] <= target){
                left++;
            }
            //找到大于基准值的元素
            arr[hole] = arr[left];
            hole = left;
        }
        //left和right相遇,此时的hole也一定在此位置
        arr[hole] = target;

        quick2(arr, begin, hole - 1);
        quick2(arr, hole + 1,end);
    }
    public static void quickSort3(int[] arr){
        quick3(arr,0,arr.length - 1);
    }

    private static void quick3(int[] arr, int begin, int end) {
        if(begin >= end){
            return;
        }
        int key = begin;
        int prev = begin;
        int cur = prev + 1;
        while (cur <= end){
            if(arr[cur] < arr[key] && prev != cur){
                prev++;
                int tmp = arr[cur];
                arr[cur] = arr[prev];
                arr[prev] = tmp;
            }
            cur++;
        }
        int tmp = arr[key];
        arr[key] = arr[prev];
        arr[prev] = tmp;
        key = prev;

        quick3(arr,begin,key - 1);
        quick3(arr, key + 1, end);

    }
    public static void quickNorSort(int[] arr){
        quickNor(arr,0,arr.length - 1);
    }
    public static void quickNor(int[] arr,int begin ,int end){
        Deque<Integer> stack = new ArrayDeque<>();
        int mid = partition(arr,begin,end);    //基准值下标
        //先对其进行第一次入栈才能开始循环处理
        if(mid > begin + 1){  //满足基准值分割线在左区间至少有两个元素
            stack.push(begin);
            stack.push(mid);
        }
        if(mid < end - 1){
            stack.push(end);
            stack.push(mid);
        }
        //接下来的递归换成循环
        while (!stack.isEmpty()){
            //接下来每次操作都是通过栈来取更新后的数据
            end = stack.pop();
            begin = stack.pop();
            mid = partition(arr,begin,end);
            if(mid > begin + 1){
                stack.push(begin);
                stack.push(mid);
            }
            if(mid < end - 1){
                stack.push(end);
                stack.push(mid);
            }
        }
    }

    /**
     * 这里将寻找基准值位置的逻辑提出来方便写非递归代码
     * @param arr
     * @param begin
     * @param end
     * @return
     */
    private static int partition(int[] arr, int begin,int end){
        // 三数取中优化：选三个下标位置，并比较其元素大小，选取其中的一个中位数与begin位置进行交换当基准值
        int midNum = getMidNum(arr,begin,end);
        //与begin进行交换
        swap(arr,begin,midNum);
        //选取基准值
        int target = begin;
        //开始遍历寻找
        int left = begin;
        int right = end;
        int mid = 0;
        while (left < right) {
            while (left < right && arr[right] >= arr[target]) {
                right--;
            }
            while (left < right && arr[left] <= arr[target]) {
                left++;
            }

           swap(arr,left,right);
        }
        //找到基准值的位置
       swap(arr,right,mid);
        mid = right;
        return mid;
    }
    public static void swap(int[] arr,int x,int y){
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    public static void mergeSort(int[] arr) {
        mergeThread(arr,0,arr.length - 1);
    }

    private static void mergeThread(int[] arr, int begin, int end) {
        if(begin >= end){
            return;
        }
        //直接分割进行递归：
        int mid = (begin + end) / 2;
        mergeThread(arr, begin, mid);
        mergeThread(arr, mid + 1, end);
        //回溯时要进行两个有序数组的排序
        merge(arr,begin,mid,end);
    }
    private static void merge(int[] arr,int begin,int mid,int end){
        //定义好两段有序数组的下标
        int begin1 = begin;
        int end1 = mid;
        int begin2 = mid + 1;
        int end2 = end;
        int k = 0;
        int[] tmp = new int[end - begin + 1];
        while (begin1 <= end1 && begin2 <= end2){
            if(arr[begin1] < arr[begin2]){
                tmp[k++] = arr[begin1];
                begin1++;
            }else{
                tmp[k++] = arr[begin2];
                begin2++;
            }
        }
        //走到这里说明至少一组已经全部进入tmp中
        while (begin1 <= end1){
            tmp[k++] = arr[begin1++];
        }
        while (begin2 <= end2){
            tmp[k++] = arr[begin2++];
        }
        for (int i = 0; i < k; i++) {
            arr[i + begin] = tmp[i];
        }
    }
    public static void mergeNorSort(int[] arr){
        mergeNor(arr,0,arr.length - 1);
    }

    private static void mergeNor(int[] arr, int begin, int end) {
        if(end < 2 || arr == null){
            return;
        }
        //因为知道分割后的结果都是一个元素，那么从gap = 1 开始归并
        int gap = 1;
        while (gap < arr.length){
            for (int left = 0; left < arr.length; left += 2 * gap) {
                int mid = left + gap - 1;
                int right = left + 2 * gap - 1;
                //这里要分情况讨论，针对于最后一组区间是否完整，根据mid和right分割
                if(mid > arr.length - 1){
                    mid = arr.length - 1;
                }
                if(right > arr.length - 1){
                    right = arr.length - 1;
                }
                //将合并所需的下标 left  mid   right 找好后即可开始两组有序数组的合并
                merge(arr,left,mid,right);
            }
            gap *= 2;
        }
    }

    public static void countSort(int[] arr){
        //找原数组元素的最大最小值的差来确定大小范围
        int minVal = arr[0];
        int maxVal = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < minVal){
                minVal = arr[i];
            }
            if (arr[i] > maxVal){
                maxVal = arr[i];
            }
        }
        int length = maxVal - minVal + 1;
        //根据大小范围创建新的数组来进行统计
        int[] count = new int[length];
        for (int i = 0; i < arr.length; i++) {
            //这里记得arr数组中最小的元素是和count中下标为0的位置映射的，以此类推
            int index = arr[i];
            count[index - minVal]++;
        }
        //统计完之后根据统计来重新赋值给arr
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            //因为映射到相同位置的元素不一定只有一个，所以要根据数量全部放置后才能继续遍历count数组
            int valCount = count[i];
            while (valCount != 0){
                arr[k] = i + minVal;
                k++;
                valCount--;
            }
        }
    }
}
