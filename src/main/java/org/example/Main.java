package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Person person1 = new Person("Vytas",50,"vytas@gmail.com");
        Person person2 = new Person("Egle",40,"egle@gmail.com");
        Person person3 = new Person("Jonas",20,"jonas@gmail.com");

        List<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);
        people.add(person3);


        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);


        File output = new File("src/main/java/org/example/persons.json");
        objectMapper.writeValue(output, people);
        String jsonPersonString = objectMapper.writeValueAsString(people);
        System.out.println(jsonPersonString);

        File input = new File("src/main/java/org/example/persons.json");

        List<Person> peopleFromFile = objectMapper.readValue(input, new TypeReference<>() {});

        System.out.println();
        System.out.println("People:");
        for (Person person : people) {
            System.out.println(person.getName() + " " + person.getAge() + " " + person.getEmail());
        }

        System.out.println();
        System.out.println("People from file:");
        for (Person person : peopleFromFile) {
            System.out.println(person.getName() + " " + person.getAge() + " " + person.getEmail());
        }

    }
}