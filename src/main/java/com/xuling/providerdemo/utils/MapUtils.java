package com.xuling.providerdemo.utils;

import java.util.HashMap;
import java.util.Map;

public class MapUtils {
    public static Map<Object,Object> buildKeyValueMap(Object... objects){
        Map<Object,Object> map = new HashMap<Object,Object>();
        if(null == objects || 0 == objects.length){
            return map;
        }
        if(objects.length%2 != 0){
            throw new RuntimeException("Key-value not in pair when build map...");
        }
        for(int i=0;i<objects.length-1;i=i+2){
            map.put(objects[i], objects[i+1]);
        }
        return map;
    }
}
