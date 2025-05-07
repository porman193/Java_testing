package org.example.test.fizzbuzz;

public class FizzBuzz {

    public static String fizzBuzz(int number) {

        StringBuilder result = new StringBuilder();

        if (number % 3 == 0) {
            result.append("Fizz");
        }
        if (number % 5 == 0) {
            result.append("Buzz");
        }

        return !result.isEmpty() ? result.toString() : String.valueOf(number);
    }
}
