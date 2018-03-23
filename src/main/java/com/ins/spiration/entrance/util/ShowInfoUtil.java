package com.ins.spiration.entrance.util;

import org.apache.commons.logging.Log;

/**
 * ShowInfoUtil
 *
 * @author rain
 * @Description: ...
 * @Version 1.0
 * @See
 * @time 13:11
 * @date 2016/1/23
 */
public class ShowInfoUtil {

    public static void showLog(Log log,String info){
        //////////////////////////////////////////////////////
        info = "\n"+info;
        log.info(info);
        System.out.println(info);
        //////////////////////////////////////////////////////
    }

    public static void showSeparationArea(int... argus) {
        int length = argus.length;
        if (0 == length) {
            System.out.println("");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("");
        } else if (1 == length) {
            System.out.println("");
            for (int i = 0; i < argus[0]; i++) {
                System.out.println("----------------------------------------------------------------------------------");
            }
            System.out.println("");
        } else if (2 == length) {
            for (int i = 0; i < argus[0]; i++) {
                System.out.println("");
            }
            for (int i = 0; i < argus[1]; i++) {
                System.out.println("----------------------------------------------------------------------------------");
            }
            for (int i = 0; i < argus[0]; i++) {
                System.out.println("");
            }
        } else if (3 == length) {
            for (int i = 0; i < argus[0]; i++) {
                System.out.println("");
            }
            for (int i = 0; i < argus[1]; i++) {
                System.out.println("----------------------------------------------------------------------------------");
            }
            for (int i = 0; i < argus[2]; i++) {
                System.out.println("");
            }
        } else {
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
        }
    }

}


