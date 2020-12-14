package com.by.json.jackson;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        Map<String, Object> map2 = mapper.readValue(text, new TypeReference<Map<String, Object>>() {
        });
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


    /**
     * 反序列化，读
     */
    @Test
    public void test05() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(new File("f:/temp/person.json"), Person.class);
        System.out.println(person);
    }

    /**
     * 序列化，写
     */
    @Test
    public void test06() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Dog dog = new Dog("旺财", "白色");

        Person person = new Person();
        person.setName("YourBatman");
        person.setAge(18);
        //person.setDog(dog);
        person.setDog(dog);
        person.setHobbies(new String[]{"足球", "篮球"});

        String jsonStr = objectMapper.writeValueAsString(person);
        System.out.println(jsonStr);
    }

    /**
     * ObjectMapper 将集合写作JSON
     * @throws IOException
     */
    @Test
    public void test07() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);

        String idsStr = objectMapper.writeValueAsString(ids);
        System.out.println(idsStr); // [1,2,3]
    }

    /**
     * ObjectMapper 读取JSON到集合
     */
    @Test
    public void test08() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String idsStr = "[1,2,3]";

        List list = objectMapper.readValue(idsStr, List.class);
        System.out.println(list); // [1, 2, 3]
    }

    /**
     * 泛型擦除的问题
     */
    @Test
    public void test09() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String idsStr = "[1,2,3]";

        // 我认为里面都是数字，所有泛型用Long，看起来是没毛病的
        List<Long> list = objectMapper.readValue(idsStr, List.class);
        // 上一句没报错，所以获取元素，那肯定是Long型呀
        // 异常栈里指出：Long i1 = list.get(0);这一句出现了类型转换的异常，这便是问题原因所在：泛型擦除
        // 明明泛型类型是Long，但实际装的是Integer类型
        Long i1 = list.get(0);
        System.out.println(list);
    }

    /**
     * 泛型擦除问题：
     * 解决方案一：利用成员变量保留泛型
     * 这种实现方式太过于不直接了，使用起来不方便
     */
    @Test
    public void test10() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String idsStr = "{\"ids\" : [1,2,3]}";

        Data data = objectMapper.readValue(idsStr, Data.class);
        Long i1 = data.getIds().get(0);
        System.out.println(data);
    }

    /**
     * 泛型擦除问题：
     * 解决方案二：使用官方推荐的TypeReference<T>
     *
     * 官方早早就为我们考虑好了这类泛型擦除的问题，所以它提供了TypeReference<T>方便我们把泛型类型保留下来
     * 使用起来也是非常的方便的
     * 这种解决方案够直接，代码也显得优雅了许多，推荐小伙伴们以后照着这个方案来解决你所遇到的问题
     */
    @Test
    public void test11() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String idsStr = "[1,2,3]";

        List<Long> list = objectMapper.readValue(idsStr, new TypeReference<List<Long>>() {});
        Long i1 = list.get(0);
        System.out.println(list);
    }

    /**
     * 树模型应用1：仅仅取几个值，没必要全部处理
     *
     * 我只需要color这个属性对应的值肿么办？先全部反序列化再去获取肯定是一种可行的方案，
     * 但是正所谓“打蚊子何须用大炮”，因此我们使用树模型API来搞定它
     */
    @Test
    public void test12() throws JsonProcessingException {
        // {"name":"YourBatman","age":18,"dog":{"name":"旺财","color":"WHITE"},"hobbies":["篮球","football"]}
        String jsonStr = "{\"name\":\"YourBatman\",\"age\":18,\"dog\":{\"name\":\"旺财\",\"color\":\"WHITE\"},\"hobbies\":[\"篮球\",\"football\"]}";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonStr);

        // 注意：如果jsonNode.get("dog")没有这个节点(或者值为null)，是会抛出NPE异常的，因此请保证代码的健壮性
        String color = jsonNode.get("dog").get("color").asText();
        System.out.println(color);
    }

    /*
     * 树模型应用2：不想创建一个Bean与之对应
     */


    /**
     * 树模型应用3：数据结构高度动态
     * 当数据结构高度动态化（随时可能新增、删除节点）时，使用树模型去处理是一个较好的方案（稳定之后再转为Java Bean即可）。
     * 这主要是利用了树模型它具有动态可扩展的特性，满足我们日益变化的结构：
     */
    @Test
    public void test13() throws JsonProcessingException {
        String jsonStr = "{\"name\":\"YourBatman\",\"age\":18,\"dog\":{\"name\":\"旺财\",\"color\":\"WHITE\"},\"hobbies\":[\"篮球\",\"football\"]}";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonStr);
        String color = jsonNode.get("dog").get("color").asText();
        System.out.println(color);

        // 把json扩充属性
        // 强转为ObjectNode
        // JsonNode可以不依托于ObjectMapper来构建，亦可使用JsonNodeFactory来单独构建然后使用
        ObjectNode objectNode = (ObjectNode)jsonNode;
        objectNode.with("myDiy").put("contry", "China");
        jsonStr = objectMapper.writeValueAsString(objectNode);
        System.out.println(jsonStr);
    }

    /**
     * MappingJsonFactory
     * 生成JsonGenerator、JsonParser的实例使用的是JsonFactory，同样的生成ObjectMapper也可以使用工厂：MappingJsonFactory
     * 它位于jackson-databind模块，并且继承自com.fasterxml.jackson.core.JsonFactory
     *
     * 该工厂的实现非常的简单，你可以把ObjectMapper当作一个实例传进来作为工厂的编码/解码器设置进去即可。
     *
     * JsonGenerator、JsonParser必须通过JsonFactory来创建实例，
     * 而为了简化使用，ObjectMapper实例我们是可以直接new的，因此MappingJsonFactory很少被人所知道，在实际应用中确实也用不着~
     *
     * 思考？为何ObjectMapper作为一个编码/解码器直接new出来就能用？
     * 原因是Jackson它自己的设计屏蔽了使用者对工厂的感知，尽量的去简化使用成本。
     */
    @Test
    public void test14() {

    }

    /**
     * JsonMapper
     * 本类是2.10版本新增，是ObjectMapper的（唯一）子类。
     * 由于ObjectMapper的绝大多数场景都是在处理JSON，所以此版本索性就给它分配一个了专用的类，这样看起来也更加专业些嘛~
     *
     * 若你是2.10版本以上的了，若你需要单独创建处理JSON映射的实例时，
     * 建议使用JsonMapper jsonMapper = new JsonMapper();代替ObjectMapper，这样显得专业度更高
     */
    @Test
    public void test15() {

    }


    /**
     * JsonFactory.Feature
     * 控制JsonFactory的一些特征（JsonGenerator和JsonParser公用）
     */
    @Test
    public void test16() {

    }

}





