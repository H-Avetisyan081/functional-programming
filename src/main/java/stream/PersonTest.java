package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonTest {
    public static void main(String[] args) {
        List<Person> people = getPeople();
        System.out.println(" filter--------------------------------------------------------------");
        //Filter
        List<Person> females = people.stream()
                .filter(p -> p.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());
        females.forEach(System.out::println);

        System.out.println(" sort----------------------------------------------------------------");
        //Sort
        List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .collect(Collectors.toList());
        sorted.forEach(System.out::println);

        System.out.println(" allMatch------------------------------------------------------------");
        //All match
        boolean allMatch = people.stream()
                .allMatch(p -> p.getAge() > 30);
        System.out.println(allMatch);

        //Any match
        System.out.println(" anyMatch------------------------------------------------------------");
        boolean anyMatch = people.stream()
                .anyMatch(p -> p.getAge() > 30);
        System.out.println(anyMatch);

        //None match
        System.out.println(" noneMatch-----------------------------------------------------------");
        boolean noneMatch = people.stream()
                .noneMatch(p -> Objects.equals(p.getName(), "Hovhannes Avetisyan"));
        System.out.println(noneMatch);

        //Max
        System.out.println(" max-----------------------------------------------------------------");
        people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        //Min
        System.out.println(" min-----------------------------------------------------------------");
        people.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        System.out.println(" group---------------------------------------------------------------");
        //GroupBy
        Map<Gender,List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));
        groupByGender.forEach((gender,people1)->{
            System.out.println(gender);
            people1.forEach(System.out::println);
        });

        System.out.println("the oldest Female is-------------------------------------------------");
        Optional<String> oldestFemale = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);
        oldestFemale.ifPresent(System.out::println);

    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("Hovhannes Avetisyan", 41, Gender.MALE),
                new Person("Hayk Avetisyan", 30, Gender.MALE),
                new Person("Hayk Sargsyan", 24, Gender.MALE),
                new Person("Mxithar Mkhitaryan", 28, Gender.MALE),
                new Person("Ani Gasparyan", 24, Gender.FEMALE),
                new Person("Anna Mkrtchyan", 32, Gender.FEMALE)
        );
    }
}
