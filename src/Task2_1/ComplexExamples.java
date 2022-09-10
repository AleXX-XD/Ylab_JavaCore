package Task2_1;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class ComplexExamples {

    static class Person {
        final int id;
        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }
    }

    private static final Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };

    public static void main(String[] args) {
        System.out.println("Raw data:");
        System.out.println();

        for (Person person : RAW_DATA) {
            System.out.println(person.id + " - " + person.name);
        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
        System.out.println();

        getUniquePersons().entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(person -> System.out.println("Key: " + person.getKey() + "\nValue : " + person.getValue()));
    }

    private static Map<String, Long> getUniquePersons() {
        return Arrays.stream(ComplexExamples.RAW_DATA)
                .distinct()
                .filter(person -> Objects.nonNull(person) && Objects.nonNull(person.getName()))
                .collect(Collectors.groupingBy(Person::getName, counting()));
    }
}