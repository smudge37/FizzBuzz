package fizzbuzz;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FizzBuzzer {
    private static boolean hasInstance = false;
    private static FizzBuzzer instance;

    private FizzBuzzer() {
        FizzBuzzer.instance = this;
        FizzBuzzer.hasInstance = true;
    }

    public static FizzBuzzer getFizzBuzzer() {
        if (FizzBuzzer.hasInstance) {
            return FizzBuzzer.instance;
        } else {
            return new FizzBuzzer();
        }
    }

    public void runFizzBuzz(int endPoint) {
        for(int counter = 1; counter <= endPoint; counter++) {
            System.out.println(writeOutput(counter));
        }
    }

    private String writeOutput(int number) {
        StringBuilder outputBuilder = new StringBuilder();
        if (number % 3 == 0) {
            outputBuilder.append("Fizz");
        }
        if (number % 5 == 0) {
            outputBuilder.append("Buzz");
        }
        String output = outputBuilder.toString();

        if (output.equals("")) {
            return String.valueOf(number);
        } else {
            return outputBuilder.toString();
        }
    }

    public void printFizzBuzz(int endPoint, String filePath) throws IOException {
        PrintWriter printer = new PrintWriter(new FileWriter(filePath));
        for (int counter = 0; counter <= endPoint; counter++) {
            printer.println(counter + ": " + writeOutput(counter));
        }
    }
}
