package com.by.json.jackson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Person {
    private String name;
    private int age;
    private Dog dog;
    private String[] hobbies;
}
