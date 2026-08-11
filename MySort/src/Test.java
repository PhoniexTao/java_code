import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int[] arr1 = disorderSort();
        int[] arr2 = Arrays.copyOf(arr1,arr1.length);
        int[] arr3 = Arrays.copyOf(arr1,arr1.length);
        int[] arr4 = Arrays.copyOf(arr1,arr1.length);
        int[] arr5 = Arrays.copyOf(arr1,arr1.length);
        int[] arr6 = Arrays.copyOf(arr1,arr1.length);
        int[] arr7 = Arrays.copyOf(arr1,arr1.length);
        int[] arr8 = Arrays.copyOf(arr1,arr1.length);
        int[] arr9 = Arrays.copyOf(arr1,arr1.length);
        int[] arr10 = Arrays.copyOf(arr1,arr1.length);
        int[] arr11 = Arrays.copyOf(arr1,arr1.length);
        int[] arr12 = Arrays.copyOf(arr1,arr1.length);
        int[] arr13 = Arrays.copyOf(arr1,arr1.length);


        insertTest(arr1);
        shellTest(arr2);
        selectTest(arr3);
        selectProTest(arr4);
        heapSortTest(arr5);
        bubbleSortTest(arr6);
//        quickSortTest1(arr7);
//        quickSortTest2(arr8);
//        quickSortTest3(arr9);
        quickNorSortTest(arr10);
        mergeSortTest(arr11);
        mergeNorSortTest(arr12);
//        countSortTest(arr13);
    }



    public static void insertTest(int[] arr){
//        System.out.println("排序前："+ Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        Sort.insertSort(arr);
        long endTime = System.currentTimeMillis();
//        System.out.println("排序后" + Arrays.toString(arr));
        System.out.println("直接插入排序耗时 ：" + (endTime - startTime));
    }
    public static void shellTest(int[] arr){
//        System.out.println("排序前："+ Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        Sort.shellSort(arr);
        long endTime = System.currentTimeMillis();
//        System.out.println("排序后" + Arrays.toString(arr));
        System.out.println("希尔排序排序耗时 ：" + (endTime - startTime));
    }
    public static void selectTest(int[] arr){
//        System.out.println("排序前" + Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        Sort.selectSort(arr);
        long endTime = System.currentTimeMillis();
//        System.out.println("排序后" + Arrays.toString(arr));
        System.out.println("直接选择基础版排序耗时：" + (endTime - startTime));
    }
    public static void selectProTest(int[] arr){
//        System.out.println("排序前" + Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        Sort.selectSortPro(arr);
        long endTime = System.currentTimeMillis();
//        System.out.println("排序后" + Arrays.toString(arr));
        System.out.println("直接选择排序进阶版耗时：" + (endTime - startTime));
    }
    public static void heapSortTest(int[] arr){
//        System.out.println("排序前" + Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        Sort.HeapSort(arr);
        long endTime = System.currentTimeMillis();
//        System.out.println("排序后" + Arrays.toString(arr));
        System.out.println("堆排序耗时：" + (endTime - startTime));
    }
    public static void bubbleSortTest(int[] arr){
//        System.out.println("排序前" + Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        Sort.bubbleSort(arr);
        long endTime = System.currentTimeMillis();
//        System.out.println("排序后" + Arrays.toString(arr));
        System.out.println("冒泡排序进阶版耗时：" + (endTime - startTime));
    }
    public static void quickSortTest1(int[] arr){
//        System.out.println("排序前" + Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        Sort.quickSort1(arr);
        long endTime = System.currentTimeMillis();
//        System.out.println("排序后" + Arrays.toString(arr));
        System.out.println("霍尔版快速排序耗时: " + (endTime - startTime));
    }
    public static void quickSortTest2(int[] arr){
//        System.out.println("排序前" + Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        Sort.quickSort2(arr);
        long endTime = System.currentTimeMillis();
//        System.out.println("排序后" + Arrays.toString(arr));
        System.out.println("挖坑版快速排序耗时: " + (endTime - startTime));
    }

    private static void quickSortTest3(int[] arr) {
//        System.out.println("排序前" + Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        Sort.quickSort3(arr);
        long endTime = System.currentTimeMillis();
//        System.out.println("排序后" + Arrays.toString(arr));
        System.out.println("前后指针版快速排序耗时: " + (endTime - startTime));
    }
    private static void quickNorSortTest(int[] arr) {
//        System.out.println("排序前" + Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        Sort.quickNorSort(arr);
        long endTime = System.currentTimeMillis();
//        System.out.println("排序后" + Arrays.toString(arr));
        System.out.println("非递归版版快速排序耗时: " + (endTime - startTime));
    }
    private static void mergeSortTest(int[] arr) {
//        System.out.println("排序前" + Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        Sort.mergeSort(arr);
        long endTime = System.currentTimeMillis();
//        System.out.println("排序后" + Arrays.toString(arr));
        System.out.println("归并排序耗时: " + (endTime - startTime));
    }
    private static void mergeNorSortTest(int[] arr) {
//        System.out.println("排序前" + Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        Sort.mergeNorSort(arr);
        long endTime = System.currentTimeMillis();
//        System.out.println("排序后" + Arrays.toString(arr));
        System.out.println("非递归版归并排序耗时: " + (endTime - startTime));
    }
    private static void countSortTest(int[] arr) {
//        System.out.println("排序前" + Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        Sort.countSort(arr);
        long endTime = System.currentTimeMillis();
//        System.out.println("排序后" + Arrays.toString(arr));
        System.out.println("计数排序排序耗时: " + (endTime - startTime));
    }
    public static int[] disorderSort() {
        Random random = new Random();
        int[] arr = new int[100000];
        for (int i = 0; i < 10; i++) {
            arr[i] = random.nextInt(100000);
        }
        return arr;
    }


}
