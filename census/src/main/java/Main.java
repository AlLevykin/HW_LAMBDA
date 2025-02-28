package main.java;

import netology.Education;
import netology.Person;
import netology.Sex;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        Predicate<Person> isAdult = p -> p.getAge() > 17;
        Predicate<Person> isChild = p -> !isAdult.test(p);
        Predicate<Person> isRecruit = p -> (p.getSex() == Sex.MAN && isAdult.test(p) && p.getAge() < 27);
        Predicate<Person> isEmployable = p -> (p.getEducation() == Education.HIGHER && isAdult.test(p) && ((p.getSex() == Sex.WOMAN && p.getAge() < 60) || (p.getSex() == Sex.MAN && p.getAge() < 65)));
        Function<Person, String> getFullName = p -> String.format("%s %s", p.getName(), p.getFamily());

        Stream<Person> stream = persons.stream();
        long count = stream.filter(isChild).count();

        stream = persons.stream();
        List<String> recruits = stream.filter(isRecruit).map(getFullName).collect(Collectors.toList());

        stream = persons.stream();
        List<Person> employable = stream.filter(isEmployable).collect(Collectors.toList());

        System.out.println(count);
        System.out.println(recruits);
        System.out.println(employable);
    }
}
