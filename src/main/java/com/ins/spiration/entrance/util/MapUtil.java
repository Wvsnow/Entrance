package com.ins.spiration.entrance.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * MapUtil
 *
 * @author liwentao1
 * @Description: ...
 * @Version 1.0
 * @See
 * @time 16:36
 * @date 2016/2/15
 */
public class MapUtil {
    public static void main(String[] args){
        mapTest();
    }

    public static void mapTest(){
        Random random = new Random(System.currentTimeMillis());
        Map<String,HashMap> map = new HashMap<String, HashMap>();
        HashMap<String,String> map_inner;
        String key_string = "";
        String value_string = "";
        int map_inner_count = 5;
        String map_inner_name;
        for (int iter_count = 0; iter_count < map_inner_count; iter_count++) {
            map_inner = new HashMap<String, String>();
            for (int i = 0; i < 10; i++) {
                key_string = "key"+i+"";
                value_string = random.nextDouble()+"";
                map_inner.put(key_string, value_string);
            }
            map_inner_name = "map_inner-"+iter_count;
            map.put(map_inner_name, map_inner);
        }
        HashMap<String,String> map_iter;
        for(String iter_string : map.keySet()){
            map_iter = map.get(iter_string);
            System.out.println("====================================================");
            System.out.println(iter_string);
            System.out.println(map_iter);
            System.out.println(map_iter.keySet());
            System.out.println("----------------------------------------------------");
        }
        for(String iter_string : map.keySet()){
            map_iter = map.get(iter_string);
            System.out.println("====================================================");
            System.out.println("====================================================");
            System.out.println(iter_string);
            System.out.println(map_iter.keySet());
            System.out.println("----------------------------------------------------");
        }
    }

}


