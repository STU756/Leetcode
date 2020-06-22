package com.jia.leetCode;

import java.util.HashMap;
import java.util.Map;

public class Pro5441 {


    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        String[] res = new String[names.length];
        for(int i = 0; i < names.length; i++) {
            res[i] = names[i];
            if(!map.containsKey(res[i])) {
                map.put(res[i], 0);
            }else {
                while(map.containsKey(res[i])) {
                    int count = map.get(res[i]);
                    map.put(res[i], count + 1);
                    res[i] = res[i] + "(" + count+1 + ")";
                }
                map.put(res[i], 0);
            }
        }
        return res;
    }
}
