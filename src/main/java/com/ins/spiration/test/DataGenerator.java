package com.ins.spiration.test;

import java.util.Random;

/**
 * @author: rain
 * @since: 2018/2/11 18:05
 * @Des: ...
 */
public class DataGenerator {


    public static Long[] generateRandomLongArray(int size, long seed) {
        if (size < 1) {
            return null;
        }
        Random random = new Random(seed);
        Long[] array = new Long[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextLong();
        }
        return array;
    }

}
