package com.ins.spiration.test;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * @author: rain
 * @since: 2018/2/11 18:04
 * @Des: ...
 */
public class DecompileTest {

    public static void main(String[] args) {

        int result = getDay();

        System.out.println("result=" + result);

    }


    public static int getDay() {
        try {
            Date date = DateUtils.parseDate("20180909", "yyyyMMdd");
            return fetchInt(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return 22222222;
        } finally {
            return 33333333;
        }
    }

    public static int fetchInt(Date date) {
        System.out.println("Call fetchInt method...");
        return 1000 + date.getDate();
    }

}
