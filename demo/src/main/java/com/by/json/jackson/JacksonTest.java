package com.by.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JacksonTest {

    /**
     * Jackson 基本用法
     */
    @Test
    public void test01() throws IOException {
        // 首先需要一个ObjectMapper对象，序列化和反序列化都需要它
        ObjectMapper mapper = new ObjectMapper();
        // 定义一个对象
        User user = new User(1L, "wby", "123");

        // 对象写为字符串
        String userText = mapper.writeValueAsString(user);
        System.out.println(userText);

        // 对象写入文件
        mapper.writeValue(new File("f:/temp/user.json"), user);

        // 对象写入字节流
        byte[] bytes = mapper.writeValueAsBytes(user);
        System.out.println(new String(bytes));

        // 从字符中读取对象
        User u1 = mapper.readValue(userText, User.class);
        System.out.println(u1);

        // 从文件中读取对象
        User u2 = mapper.readValue(new File("f:/temp/user.json"), User.class);
        System.out.println(u2);

        // 从字节流中读取对象
        User u3 = mapper.readValue(bytes, User.class);
        System.out.println(u3);
    }

    /**
     * 集合的映射
     */
    @Test public void test02() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> map = new HashMap<>();
        map.put("age", 25);
        map.put("name", "yitian");
        map.put("interests", new String[]{"pc games", "music"});

        String text = mapper.writeValueAsString(map);
        System.out.println(text);

        // 从JSON转换为Map对象的时候，由于Java的类型擦除，所以类型需要我们手动用new TypeReference<T>给出
        Map<String, Object> map2 = mapper.readValue(text, new TypeReference<Map<String, Object>>() {});
        System.out.println(map2);

        JsonNode root = mapper.readTree(text);
        String name = root.get("name").asText();
        int age = root.get("age").asInt();

        System.out.println("name:" + name + " age:" + age);
    }

}
