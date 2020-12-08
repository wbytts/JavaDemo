package com.by.json.jackson;

import com.fasterxml.jackson.core.*;
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
    @Test
    public void test02() throws JsonProcessingException {
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

    /**
     * JsonGenerator
     * Jackson底层的写法，以后再也不会用了！
     */
    @Test
    public void test03() throws IOException {
        JsonFactory factory = new JsonFactory();

        // 此处最终输输出到OutputStreams输出流（此处输出到文件）
        // JsonGenerator 封装了 输出流
        JsonGenerator jsonGenerator = factory.createGenerator(new File("f:/temp/person.json"), JsonEncoding.UTF8);
        jsonGenerator.writeStartObject(); //开始写，也就是这个符号 {   左大括号

        // 写属性，属性名，属性值
        jsonGenerator.writeStringField("name", "YourBatman"); // 写字符串属性 "name": YourBatman"
        jsonGenerator.writeNumberField("age", 18);  // 写数字属性  "age":18

        // 写入Dog对象（枚举对象）
        jsonGenerator.writeFieldName("dog");  // 写一个属性名
        jsonGenerator.writeStartObject();  // 开始写属性值  {  左大括号
        jsonGenerator.writeStringField("name", "旺财");  // "name":"旺财"
        jsonGenerator.writeStringField("color", "WHITE"); // "color":"WHITE"
        jsonGenerator.writeEndObject();  // 对象写完  }  右大括号

        //写入一个数组格式
        jsonGenerator.writeFieldName("hobbies"); // "hobbies" :
        jsonGenerator.writeStartArray(); // [  开始写数组，左中括号
        jsonGenerator.writeString("篮球"); // "篮球"
        jsonGenerator.writeString("football"); // "football"
        jsonGenerator.writeEndArray(); // ]  数组写完，右中括号

        jsonGenerator.writeEndObject(); //结束写，也就是这个符号 }  右大括号

        // 关闭IO流，结束
        jsonGenerator.close();
    }


    /**
     * JsonParser 读
     * @throws JsonProcessingException
     */
    @Test
    public void test04() throws IOException {
        JsonFactory factory = new JsonFactory();

        // 此处InputStream来自于文件
        JsonParser jsonParser = factory.createParser(new File("f:/temp/person.json"));

        // 只要还没到末尾，也就是}这个符号，就一直读取
        // {"name":"YourBatman","age":18,"dog":{"name":"旺财","color":"WHITE"},"hobbies":["篮球","football"]}
        JsonToken jsonToken = null; // token类型
        while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
            String fieldname = jsonParser.getCurrentName();
            if ("name".equals(fieldname)) {
                jsonToken = jsonParser.nextToken();
                System.out.println("==============token类型是：" + jsonToken);
                System.out.println(jsonParser.getText());
            } else if ("age".equals(fieldname)) {
                jsonToken = jsonParser.nextToken();
                System.out.println("==============token类型是：" + jsonToken);
                System.out.println(jsonParser.getIntValue());
            } else if ("dog".equals(fieldname)) {
                jsonToken = jsonParser.nextToken();
                System.out.println("==============token类型是：" + jsonToken);
                while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                    String dogFieldName = jsonParser.getCurrentName();
                    if ("name".equals(dogFieldName)) {
                        jsonToken = jsonParser.nextToken();
                        System.out.println("======================token类型是：" + jsonToken);
                        System.out.println(jsonParser.getText());
                    } else if ("color".equals(dogFieldName)) {
                        jsonToken = jsonParser.nextToken();
                        System.out.println("======================token类型是：" + jsonToken);
                        System.out.println(jsonParser.getText());
                    }
                }
            } else if ("hobbies".equals(fieldname)) {
                jsonToken = jsonParser.nextToken();
                System.out.println("==============token类型是：" + jsonToken);
                while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                    System.out.println(jsonParser.getText());
                }
            }
        }

        // 关闭IO流
        jsonParser.close();
    }

}
