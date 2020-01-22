package com.ins.spiration.algorithm;

import java.util.*;

/**
 * @author: rain
 * @since: 2018/3/23 10:23
 * @Des: ...
 */
public class MinLenSumSeq {


    public static void main(String[] args) {

        long[] arr = new long[100000];
        long targetSum = 1000;
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 200 - random.nextInt(500);
        }
        System.out.println("【数组】" + Arrays.toString(findMinLenSubSeq4TargetSum(arr, targetSum)));

        System.out.println("【数组】" + Arrays.toString(findFirstSubSeq4TargetSum(arr, targetSum)));

        System.out.println("【数组】" + Arrays.toString(findMaxSumSubSeq(arr)));

    }

    /**
     * 获取和为目标值的最短子序列
     *
     * @param arr       数组
     * @param targetSum 最小子序列和
     * @return 目标列表（不小于指定和的最端子序列）
     */
    public static long[] findMinLenSubSeq4TargetSum(long[] arr, long targetSum) {

        System.out.println("\n****************************");
        System.out.println("【获取和为目标值的最短子序列】");
        System.out.println("****************************\n");
        if (arr == null) {
            return null;
        }
        int arr_size = arr.length;
        if (arr_size < 1) {
            return null;
        }
        if (arr_size < 100) {
            System.out.println("入参1：" + Arrays.toString(arr));

        }
        System.out.println("入参2：" + String.valueOf(targetSum));

        int s_i = 0, t_i = 0;
        long sum = 0;
        boolean flag = false;
        for (int i = 0; i < arr_size; i++) {
            t_i = i;
            sum += arr[i];
            if (sum >= targetSum) {
                flag = true;

                System.out.println("\n---");
                System.out.println(String.format("首个区间范围 [%d, %d]; 长度 %d; 总和 %d", s_i, t_i, (t_i - s_i + 1), sum));
                System.out.println("对应数组：" + Arrays.toString(arraySub(arr, s_i, t_i)));
                System.out.println("---\n");

                break;
            }
            if (arr[s_i] < 0) {
                sum -= arr[s_i];
                s_i++;
            }
            if (sum < 0) {
                sum = 0;
                s_i = i + 1;
            }
        }
        if (!flag) {
            return null;
        }
        int min_len = t_i - s_i + 1;
        int ps_i = s_i;
        int pt_i = t_i;
        for (int i = s_i; t_i < arr_size && i < arr_size; i++) {
            while (sum - arr[i] >= targetSum) {
                s_i++;
                sum -= arr[i];
                i++;
                min_len--;

                ps_i = s_i;
                pt_i = t_i;

                System.out.println(String.format("更新区间范围 [%d, %d]; 长度 %d 即 %d; 总和 %d；对应数组 SUM=%d, %s ", ps_i, pt_i, (pt_i - ps_i + 1), min_len, sum, sum_arr(arr, ps_i, pt_i), Arrays.toString(arraySub(arr, ps_i, pt_i))));
            }
            t_i++;
            if (t_i < arr_size) {
                sum += arr[t_i] - arr[s_i];
            }
            s_i++;
        }

        long[] result = arraySub(arr, ps_i, pt_i);
        System.out.println("\n---");
        System.out.println(String.format("最终区间范围 [%d, %d]; 长度 %d 即 %d; 总和 %d", ps_i, pt_i, (pt_i - ps_i + 1), min_len, sum));
        System.out.println(String.format("对应数组 SUM=%d , %s", sum_arr(arr, ps_i, pt_i), Arrays.toString(result)));
        System.out.println("---\n");

        return result;
    }


    /**
     * 获取首个和为目标值的子序列
     *
     * @param arr       数组
     * @param targetSum 最小子序列和
     * @return 目标列表（不小于指定和的最端子序列）
     */
    public static long[] findFirstSubSeq4TargetSum(long[] arr, long targetSum) {

        System.out.println("\n****************************");
        System.out.println("【获取首个和为目标值的子序列】");
        System.out.println("****************************\n");
        if (arr.length < 100) {
            System.out.println("入参1：" + Arrays.toString(arr));

        }
        System.out.println("入参2：" + String.valueOf(targetSum));

        if (arr == null || arr.length < 1) {
            return null;
        }

        int s_i = 0, t_i = 0;
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            t_i = i;
            sum += arr[i];
            if (sum >= targetSum) {

                long[] result = arraySub(arr, s_i, t_i);
                System.out.println("\n---");
                System.out.println(String.format("区间范围 [%d, %d]; 长度 %d; 总和 %d", s_i, t_i, (t_i - s_i + 1), sum));
                System.out.println("对应数组：" + Arrays.toString(result));
                System.out.println("---\n");

                return result;
            }
            if (arr[s_i] < 0) {
                sum -= arr[s_i];
                s_i++;
            }
            if (sum < 0) {
                sum = 0;
                s_i = i + 1;
            }
        }

        return null;
    }

    /**
     * 获取和最大的子序列
     *
     * @param arr 数组
     * @return 目标列表（不小于指定和的最端子序列）
     */
    public static long[] findMaxSumSubSeq(long[] arr) {

        System.out.println("\n****************************");
        System.out.println("【获取和最大的子序列】");
        System.out.println("****************************\n");
        if (arr.length < 100) {
            System.out.println("入参1：" + Arrays.toString(arr));

        }

        System.out.println("入参1长度：" + arr.length);

        if (arr == null || arr.length < 1) {
            return null;
        }

        int s_i = 0, t_i = 0;
        long prime_sum = 0;
        int ps_i = 0, pt_i = 0;
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            t_i = i;
            sum += arr[i];

            if (sum >= prime_sum) {
                prime_sum = sum;
                ps_i = s_i;
                pt_i = t_i;
                System.out.println(String.format("更新最大值，区间范围 [%d, %d]; 长度 %d; 总和 %d；对应数组 %s", ps_i, pt_i, (pt_i - ps_i + 1), prime_sum, Arrays.toString(arraySub(arr, ps_i, pt_i))));
            }

            if (arr[s_i] < 0) {
                sum -= arr[s_i];
                s_i++;
            }
            if (sum < 0) {
                sum = 0;
                s_i = i + 1;
            }
        }

        long[] result = arraySub(arr, ps_i, pt_i);
        System.out.println("\n---");
        System.out.println(String.format("区间范围 [%d, %d]; 长度 %d; 总和 %d", ps_i, pt_i, (pt_i - ps_i + 1), prime_sum));
        System.out.println("对应数组：" + Arrays.toString(result));
        System.out.println("---\n");

        return result;
    }

    public static int[] arraySub(int[] data, int start, int end) {
        int[] C = new int[end - start + 1];
        int j = 0;
        for (int i = start; i <= end; i++) {
            C[j] = data[i];
            j++;
        }
        return C;
    }


    public static long[] arraySub(long[] data, int start, int end) {
        long[] C = new long[end - start + 1];
        int j = 0;
        for (int i = start; i <= end; i++) {
            C[j] = data[i];
            j++;
        }
        return C;
    }

    public static long sum_arr(long[] data, int start, int end) {
        long C = 0;
        for (int i = start; i <= end; i++) {
            C += data[i];
        }
        return C;
    }

}
