package com.ins.spiration.test;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        System.out.println("  ---------  start");
        test001();

        System.out.println("  ---------  end");
    }


    public static void test001() {
        IdentityHashMap idenmap = new IdentityHashMap();
        String first = new String("语文");
        String second = new String("语文");
        idenmap.put(first, 80);
        idenmap.put(second, 89);
        idenmap.put("java", 80);
        idenmap.put("java", 80);
        System.out.println(idenmap);
        //{语文=80, java=80, 语文=89}
    }

    public static void test002() {

        Long sumTarget = 100L;
        Long[] arr = new Long[]{10L, 22L, 30L, 50L, 60L};
        int count = 5;
        List<Long> result = compute(sumTarget, arr, count);
        System.out.println(result);


        sumTarget = 80L;
        arr = new Long[]{1L, 2L, 3L, 13L, 67L};
        count = 5;
        result = compute(sumTarget, arr, count);
        System.out.println(result);


        sumTarget = 8990L;
        arr = new Long[]{1L, 2L, 3L, 13L, 67L};
        count = 5;
        result = compute(sumTarget, arr, count);
        System.out.println(result);


        sumTarget = 100L;
        arr = new Long[]{1L, 2L, 3L, 3L, 69L, 6L, 15L, 9L, 8L, 23L, 3L, 43L};
        count = arr.length;
        result = compute(sumTarget, arr, count);
        System.out.println(result);
    }

    public static List<Long> compute(Long sumTarget, Long[] arr, int count) {
        if (null == sumTarget || null == arr || count < 1 || arr.length != count) {
            return null;
        }
        long top = 1 << count;
        long currSum;
        List<Long> result = null;
        int tmpIndex;
        for (long flag = 1; flag < top; flag++) {
            currSum = 0;
            tmpIndex = 0;
            for (int k = 1; k < top; ) {
                if ((flag & k) > 0) {
                    currSum += arr[tmpIndex];
                }
                tmpIndex++;
                k = (k << 1);
            }
            if (currSum == sumTarget) {
                result = new LinkedList<Long>();
                tmpIndex = 0;
                for (int k = 1; k < top; ) {
                    if ((flag & k) > 0) {
                        result.add(arr[tmpIndex]);
                    }
                    tmpIndex++;
                    k = (k << 1);
                }
            }
        }
        return result;
    }

}

