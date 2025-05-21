package com.pluarlsight;

import java.util.ArrayList;
import java.util.Collections; // For the Collections.sort() method
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        // Create an ArrayList to store Person objects.
        List<Person> myFamily = new ArrayList<Person>();

        // Add Person objects to the list.
        myFamily.add(new Person("Dana", "Wyatt", 63));
        myFamily.add(new Person("Zachary", "Westly", 31));
        myFamily.add(new Person("Elisha", "Aslan", 14));
        myFamily.add(new Person("Ian", "Auston", 16));
        myFamily.add(new Person("Zephaniah", "Hughes", 9));
        myFamily.add(new Person("Ezra", "Aiden", 17));

        // --- For demonstration: Add a few more to test sorting edge cases ---
        myFamily.add(new Person("Peter", "Wyatt", 30));   // Same last name as Dana
        myFamily.add(new Person("Alice", "Wyatt", 30));  // Same last name and age as Peter, different first name
        myFamily.add(new Person("Bob", "Hughes", 12));    // Same last name as Zephaniah

        System.out.println("--- Original List (Unsorted) ---");
        for (Person person : myFamily) {
            System.out.println(person);
        }

        // Attempt to sort the list using Collections.sort().
        // If Person did NOT implement Comparable, this line would cause a compile-time error
        // because Java wouldn't know how to compare two Person objects.
        // With Comparable implemented, Java uses the compareTo() method we defined in Person.
        Collections.sort(myFamily);

        System.out.println("\n--- Sorted List ---");
        System.out.println("(Sorted by Last Name, then First Name, then Age)");
        for (Person person : myFamily) {
            System.out.println(person);
        }

        // Test with an explicit identical person to see age sorting
        myFamily.add(new Person("Ian", "Auston", 10)); // Same first/last as existing Ian, but younger
        Collections.sort(myFamily);
        System.out.println("\n--- Sorted List (with duplicate name, different age) ---");
        for (Person person : myFamily) {
            System.out.println(person);
        }
    }
}