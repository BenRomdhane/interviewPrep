package com.interview.prep.java8.Functional;

/**
 * Created by Nikitash Pawar on 7/5/2017.
 */
public class Factory {

    public static void main(String[] args) {

        PersonFactory<Person> factory=Person::new;
        Person person = factory.create("Nikitash", "Person");
        System.out.println(person.toString());

    }
}

interface PersonFactory<P extends Person>{

    P create(String firstName,String lastName);

}

class Person{

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    String firstName;
    String lastName;

}
