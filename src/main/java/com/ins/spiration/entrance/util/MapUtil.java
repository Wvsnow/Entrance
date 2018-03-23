package com.ins.spiration.entrance.util;

import java.util.*;

/**
 * MapUtil
 *
 * @author rain
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


    /**
     * 获取Map的镜像 - 当且仅当一一映射时可获得完整镜像
     * @param source_map 源Map
     * @return 目Map
     */
    public static Map<String,String> generateMirrorMap(Map<String,String> source_map){
        if(null == source_map){
            return null;
        }
        Iterator<String> iterator = source_map.keySet().iterator();
        String key;
        Map<String,String> target_map = new HashMap<String,String>();
        while (iterator.hasNext()){
            key = iterator.next();
            target_map.put(source_map.get(key),key);
        }
        return target_map;
    }

    /**
     *  获得排序的 Map
     * @param oldMap Map源
     * @param asc 排序规则
     * @return 新的排序map
     */
    public static Map sortMap(Map oldMap,final boolean asc) {
        if(null == oldMap){
            return null;
        }
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(oldMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> arg0,
                               Map.Entry<String, Integer> arg1) {
                if (asc) {
                    return arg0.getValue() - arg1.getValue();
                } else {
                    return arg1.getValue() - arg0.getValue();
                }

            }
        });
        Map newMap = new LinkedHashMap();
        for (int i = 0; i < list.size(); i++) {
            newMap.put(list.get(i).getKey(), list.get(i).getValue());
        }
        return newMap;
    }

    /**
     * 显示Map信息到控制台
     * @param source_map 源Map
     */
    public static void showMapInfo(Map source_map){
        if(null == source_map){
            System.out.println(" Input Parameter is NULL.");
            return;
        }
        Iterator<Object>iterator = source_map.keySet().iterator();
        Object key;
        Object value;
        int count = 0;
        ShowInfoUtil.showSeparationArea(1,3,1);
        while (iterator.hasNext()){
            key = iterator.next();
            value = source_map.get(key);
            count++;
            System.out.println("  Key-Value "+count+"  【 "+key+":"+value+" 】");
        }
        System.out.println("=================");
        System.out.println();
        System.out.println("=================");
        System.out.println("  **  ** Map 大小 ： "+count);
        System.out.println("=================");
    }

    /**
     * 显示Set信息到控制台
     * @param source_set 源Set
     */
    public static void showSetInfo(Set source_set){
        if(null == source_set){
            System.out.println(" Input Parameter is NULL.");
            return;
        }
        Iterator<Object>iterator = source_set.iterator();
        Object key;
        int count = 0;
        ShowInfoUtil.showSeparationArea(1,3,1);
        while (iterator.hasNext()){
            key = iterator.next();
            count++;
            System.out.println();
            System.out.println("=================");
            System.out.println("  Set Key "+count+"  【 "+key+" 】");
            System.out.println("=================");
        }
        System.out.println();
        System.out.println("=================");
        System.out.println("  **  ** Set 大小 ： "+count);
        System.out.println("=================");
    }

    /**
     * 显示 List 信息到控制台
     * @param source_list 源 List
     */
    public static void showListInfo(List source_list){
        if(null == source_list){
            System.out.println(" Input Parameter is NULL.");
            return;
        }
        Iterator<Object>iterator = source_list.iterator();
        Object key;
        int count = 0;
        ShowInfoUtil.showSeparationArea(1,3,1);
        while (iterator.hasNext()){
            key = iterator.next();
            count++;
            System.out.println();
            System.out.println("=================");
            System.out.println("  List Key "+count+"  【 "+key+" 】");
            System.out.println("=================");
        }
        System.out.println();
        System.out.println("=================");
        System.out.println("  **  ** List 大小 ： "+count);
        System.out.println("=================");
    }



}


