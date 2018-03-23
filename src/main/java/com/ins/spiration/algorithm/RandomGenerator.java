package com.ins.spiration.algorithm;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author: rain
 * @since: 2018/3/23 10:23
 * @Des: ...
 */
public class RandomGenerator {


    public static void main(String[] args) {

        System.out.println(findAscendUniqueOnes(100, 30));

    }

    /**
     * 获取 [1,N] N个整数中随机不重复的 M 大小升序序列 （M<=N）
     *
     * @param whole       边界值
     * @param targetCount 目标值个数
     * @return 目标列表（升序排列）
     */
    public static List<Integer> findAscendUniqueOnes(int whole, int targetCount) {
        if (targetCount < 1 || targetCount > whole) {
            return null;
        }
        List<Integer> result = new LinkedList<Integer>();
        Random random = new Random(System.currentTimeMillis());
        int filledCount = 0;
        int candidate;
        for (int count = 0; count < targetCount; count++) {
            candidate = random.nextInt(Integer.MAX_VALUE) % (whole - filledCount);
            Iterator<Integer> iterator = result.iterator();
            int indexCandidate = 0;
            while (iterator.hasNext()) {
                if (candidate < iterator.next()) {
                    break;
                } else {
                    candidate++;
                }
                indexCandidate++;
            }
            result.add(indexCandidate, candidate);
            filledCount++;
        }
        return result;
    }

}
