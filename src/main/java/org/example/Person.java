package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    @JsonProperty("Vardas")
    private String name;
    @JsonProperty("Amžius")
    private int age;
    @JsonProperty("Elektroninio pašsto adresas")
    private String email;

    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
