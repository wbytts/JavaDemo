package com.by.json.fastjson;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FastJsonDemo {

    @Test
    public void test1() {
        List<String> list = new ArrayList<>();
        list.add("123123123");
        list.add("456456456");
        list.add("789789789");

        Map<String, Object> map = new HashMap<>();
        map.put("aaa", 111);
        map.put("bbb", 222);
        map.put("list", list);

        String s = JSON.toJSONString(map, true);
        System.out.println(s);
    }

}
