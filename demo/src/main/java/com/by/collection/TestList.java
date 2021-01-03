package com.by.collection;

import cn.hutool.core.lang.tree.Tree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestList {

    @Test
    public void testArrayList() {

        /*
            Java 的顺序表和链表封装了底层操作，提供了统一接口
            使用起来没有任何差别
         */

        // 顺序表
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        System.out.println(list);

        // 链表
        List<String> linkedList = new LinkedList<>();
        linkedList.add("ddd");
        linkedList.add("eee");
        linkedList.add("fff");
        System.out.println(linkedList);

    }




}
