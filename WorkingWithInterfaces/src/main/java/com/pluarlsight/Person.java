package com.pluarlsight;

// The Person class implements the Comparable interface.
// This means Person objects can be compared to each other, which is necessary for sorting.
// We specify "Comparable<Person>" because we want to compare a Person object with another Person object.
public class Person implements Comparable<Person> {

    // --- Fields (Instance Variables) ---
    private String firstName;
    private String lastName;
    private int age;

    // --- Constructor ---
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // --- Getter Methods ---
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    // --- Overridden toString() method ---
    // This method provides a nice string representation of the Person object,
    // which is useful when printing the list.
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    // --- Implementation of the compareTo() method from the Comparable interface ---
    // This is the core method that defines how Person objects are compared.
    // It determines the "natural ordering" of Person objects.
    @Override
    public int compareTo(Person otherPerson) {
        // Goal: Sort primarily by last name.
        // If last names are the same, then sort by first name.
        // If first names are also the same, then sort by age.

        // Compare last names first.
        // String's compareTo method compares strings lexicographically (alphabetically).
        int lastNameComparison = this.lastName.compareTo(otherPerson.getLastName());

        // If the last names are different, that's our sorting criteria.
        if (lastNameComparison != 0) {
            return lastNameComparison; // Positive if this.lastName is "greater", negative if "lesser", 0 if equal.
        }

        // If last names are the same, then compare first names (BONUS part 1).
        int firstNameComparison = this.firstName.compareTo(otherPerson.getFirstName());
        if (firstNameComparison != 0) {
            return firstNameComparison;
        }

        // If both last names and first names are the same, then compare by age (BONUS part 2).
        // For integers, simple subtraction works for comparison:
        // - If this.age < otherPerson.age, result is negative.
        // - If this.age > otherPerson.age, result is positive.
        // - If this.age == otherPerson.age, result is 0.
        // Alternatively, use Integer.compare(this.age, otherPerson.age) for more robustness (e.g., with potential nulls, though not an issue here).
        return Integer.compare(this.age, otherPerson.getAge());

        // A simpler way to write the age comparison if you're sure ages are non-negative and won't overflow:
        // return this.age - otherPerson.getAge();
        // However, Integer.compare is generally safer and more explicit.
    }
}
