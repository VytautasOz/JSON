package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Person person = new Person("Vytas",50,"lol@gmail.com");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        File output = new File("src/main/java/org/example/rezultatas.json");
        objectMapper.writeValue(output, person);

        File input = new File("src/main/java/org/example/rezultatas.json");
        Person personJson = objectMapper.readValue(input, Person.class);

        System.out.println(person.getName() + person.getAge() + person.getEmail());
        System.out.println(personJson.getName() + personJson.getAge() + personJson.getEmail());


    }
}