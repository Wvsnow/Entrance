package com.ins.spiration.test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author: wentaoli214022
 * @since: 2018/2/11 15:36
 * @Des: ...
 */
class HeapSort {

    public static void main(String[] args) {
        HeapSort hs = new HeapSort();
        long startMillisecond;
        long endMillisecond;
        int scale = 100 * 10000;
        Integer[] arrayFir = generateRandomArray(scale);
        Integer[] arraySec = Arrays.copyOf(arrayFir, scale);

        FirstHeapSort firstHeapSort = hs.new FirstHeapSort();
        startMillisecond = System.currentTimeMillis();
        hs.createHeap(arrayFir);
        firstHeapSort.sort(arrayFir);
        endMillisecond = System.currentTimeMillis();
        showPerformance("First HeapSort ", startMillisecond, endMillisecond);
        System.out.println(firstHeapSort.getPerformanceInfo());
        showArray(arrayFir, 100, 10, 20);

        SecondHeapSort secondHeapSort = hs.new SecondHeapSort();
        startMillisecond = System.currentTimeMillis();
        hs.createHeap(arraySec);
        secondHeapSort.sort(arraySec);
        endMillisecond = System.currentTimeMillis();
        showPerformance("Second HeapSort ", startMillisecond, endMillisecond);
        System.out.println(secondHeapSort.getPerformanceInfo());
        showArray(arraySec, 100, 10, 20);
    }

    public static Integer[] generateRandomArray(int size) {
        if (size < 1) {
            return null;
        }
        long seed = System.currentTimeMillis();
        Random random = new Random(seed);
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(Integer.MAX_VALUE);
        }
        return array;
    }

    public static void swap(Integer[] array, int m, int n) {
        array[n] ^= array[m];
        array[m] ^= array[n];
        array[n] ^= array[m];
    }

    public static void showPerformance(String desc, long startMille, long endMille) {
        System.out.println(" ****************************  ");
        System.out.println(" " + desc + "  ");
        System.out.println(" ****************************  ");
        System.out.println(" Start time: " + startMille + ", end time: " + endMille);
        System.out.println(" Consume " + (endMille - startMille) + " ms.");
    }

    public static void showArray(Integer[] array, int split, int startShow, int endShow) {
        System.out.println(" ****************************  ");
        System.out.println(" Show Array INFO  ");
        System.out.println(" ****************************  ");
        if (null == array || array.length < 1) {
            return;
        }
        if (split < 1) {
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
        } else {
            int batchWhole = array.length / split;
            int tailBatch2Show = batchWhole - endShow;
            if (tailBatch2Show < startShow) {
                tailBatch2Show = startShow;
            }
            int batchNo;
            for (int i = 0; i < array.length; i++) {
                batchNo = i / split;
                if (batchNo < startShow || batchNo >= tailBatch2Show) {
                    if (i % split == 0) {
                        System.out.println();
                    }
                    System.out.print(array[i] + " ");
                }
            }
        }
    }

    /**
     * 初始化堆
     */
    public static void createHeap(Integer[] array) {
        int n = array.length;
        for (int k = (n - 1) / 2; k >= 0; k--) {
            shiftDown(array, k, n - 1);
        }
    }

    /**
     * 调整堆顶
     */
    public static void shiftDown(Integer[] array, int parent, int end) {
        boolean flag = true;
        while (parent * 2 + 1 <= end && flag) { //如果存在左孩子就进行调整
            int lChild = parent * 2 + 1;
            int max = 0;
            if (lChild + 1 <= end) { //表示存在右孩子
                int rChild = lChild + 1;
                max = array[lChild] > array[rChild] ? lChild : rChild;
            } else {
                max = lChild;
            }
            if (array[max] > array[parent]) { //有子孩子比父亲大
                swap(array, max, parent);
                parent = max;
            } else {
                flag = false;//表示孩子都比父亲要小，不需要调整了
            }
        }
    }

    class FirstHeapSort {

        public long swapCount = 0;

        /**
         * 排序主过程
         */
        public void sort(Integer[] heap) {
            int n = heap.length;
            int rmd = n - 1;
            while (rmd > 0) {
                swap(heap, 0, rmd);
                shiftDown(heap, 0, rmd - 1);
                rmd--;
            }
        }

        /**
         * 将以parent为根节点的二叉树调整为堆
         */
        public void shiftDown(Integer[] array, int parent, int end) {
            boolean flag = true;
            while (parent * 2 + 1 <= end && flag) { //如果存在左孩子就进行调整
                int lChild = parent * 2 + 1;
                int max = 0;
                if (lChild + 1 <= end) { //表示存在右孩子
                    int rChild = lChild + 1;
                    max = array[lChild] > array[rChild] ? lChild : rChild;
                } else {
                    max = lChild;
                }
                if (array[max] > array[parent]) { //有子孩子比父亲大
                    swap(array, max, parent);
                    parent = max;
                } else {
                    flag = false;//表示孩子都比父亲要小，不需要调整了
                }
            }
        }

        public String getPerformanceInfo() {
            StringBuffer buffer = new StringBuffer();
            buffer.append("\n");
            buffer.append(" SwapCount = " + swapCount);
            buffer.append("\n");
            return buffer.toString();
        }

        public void swap(Integer[] array, int m, int n) {
            swapCount++;
            HeapSort.swap(array, m, n);
        }
    }

    class SecondHeapSort {

        public long swapCount = 0;

        /**
         * 排序主过程
         */
        public void sort(Integer[] array) {
            int n = array.length;
            int rmd = n - 1;
            while (rmd > 1) {
                swap(array, 0, rmd);
                if (array[1] > array[2]) {
                    swap(array, 1, rmd - 1);
                    shiftDown(array, 1, rmd - 2);
                } else {
                    swap(array, 2, rmd - 1);
                    shiftDown(array, 2, rmd - 2);
                }
                shiftDown(array, 0, rmd - 2);
                rmd -= 2;
            }
            if (n > 1) {
                swap(array, 0, 1);
            }
        }

        /**
         * 将以 parent 为根节点的二叉树调整为堆
         */
        public void shiftDown(Integer[] array, int parent, int end) {
            boolean flag = true;
            while (parent * 2 + 1 <= end && flag) { //如果存在左孩子就进行调整
                int lChild = parent * 2 + 1;
                int max = 0;
                if (lChild + 1 <= end) { //表示存在右孩子
                    int rChild = lChild + 1;
                    max = array[lChild] > array[rChild] ? lChild : rChild;
                } else {
                    max = lChild;
                }
                if (array[max] > array[parent]) { //有子孩子比父亲大
                    swap(array, max, parent);
                    parent = max;
                } else {
                    flag = false;//表示孩子都比父亲要小，不需要调整了
                }
            }
        }

        public String getPerformanceInfo() {
            StringBuffer buffer = new StringBuffer();
            buffer.append("\n");
            buffer.append(" SwapCount = " + swapCount);
            buffer.append("\n");
            return buffer.toString();
        }

        public void swap(Integer[] array, int m, int n) {
            swapCount++;
            HeapSort.swap(array, m, n);
        }

    }

}
