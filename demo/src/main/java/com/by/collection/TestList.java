package com.by.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestList {

    @Test
    public void testArrayList() {
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
